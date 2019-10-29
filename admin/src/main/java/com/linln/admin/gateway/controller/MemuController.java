package com.linln.admin.gateway.controller;

import com.linln.admin.gateway.validator.MemuValid;
import com.linln.common.enums.StatusEnum;
import com.linln.common.utils.*;
import com.linln.common.vo.ResultVo;
import com.linln.modules.gateway.domain.Memu;
import com.linln.modules.gateway.service.MemuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author chenmm
 * @date 2019/10/30
 */
@Controller
@RequestMapping("/gateway/memu")
public class MemuController {

    @Autowired
    private MemuService memuService;

    // 对象存储访问域名
    @Value("${oss.endpoint}")
    private String endpoint;
    // 阿里api-key
    @Value("${oss.access-key-id}")
    private String accessKeyId;
    // 阿里云api秘钥
    @Value("${oss.access-key-secret}")
    private String accessKeySecret;
    // 对象存储实例名称
    @Value("${oss.bucket-name}")
    private String backName;
    @Value("${server.port}")
    private String port;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("gateway:memu:index")
    public String index(Model model, Memu memu) {

        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.contains());

        // 获取数据列表
        Example<Memu> example = Example.of(memu, matcher);
        Page<Memu> list = memuService.getPageList(example);

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/gateway/memu/index";
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("gateway:memu:add")
    public String toAdd(Model model) {
        model.addAttribute("oneMemu",memuService.listAllOneLevel());
        return "/gateway/memu/add";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("gateway:memu:edit")
    public String toEdit(@PathVariable("id") Memu memu, Model model) {
        model.addAttribute("memu", memu);
        return "/gateway/memu/add";
    }

    /**
     * 保存添加/修改的数据
     * @param valid 验证对象
     */
    @PostMapping("/save")
    @RequiresPermissions({"gateway:memu:add", "gateway:memu:edit"})
    @ResponseBody
    public ResultVo save(@Validated MemuValid valid, Memu memu) {
        // 复制保留无需修改的数据
        if (memu.getId() != null) {
            Memu beMemu = memuService.getById(memu.getId());
            EntityBeanUtil.copyProperties(beMemu, memu);
        }

        // 保存数据
        memuService.save(memu);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("gateway:memu:detail")
    public String toDetail(@PathVariable("id") Memu memu, Model model) {
        model.addAttribute("memu",memu);
        return "/gateway/memu/detail";
    }

    /**
     * 设置一条或者多条数据的状态
     */
    @RequestMapping("/status/{param}")
    @RequiresPermissions("gateway:memu:status")
    @ResponseBody
    public ResultVo status(
            @PathVariable("param") String param,
            @RequestParam(value = "ids", required = false) List<Long> ids) {
        // 更新状态
        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
        if (memuService.updateStatus(statusEnum, ids)) {
            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
        } else {
            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
        }
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
        // 验证视频
        String reg = "(webp|bmp|pcx|tif|gif|jpeg|tga|exif|fpx|svg|psd|cdr|pcd|dxf|ufo|eps|ai|png|hdri|raw|wmf|flic|emf|ico)";
        Pattern p = Pattern.compile(reg);
        if(!p.matcher(file.getOriginalFilename()).find())
            return JsonUtil.fail("请上传图片文件");
        try {
            String fileUidName = UUID.randomUUID().toString() + "|" + file.getOriginalFilename();
            OSSUtil.videoUp(file.getInputStream(),backName,endpoint,accessKeyId,accessKeySecret,fileUidName);
            return JsonUtil.success("图片上传成功","https://" + backName + "." + endpoint + "/" +fileUidName);
        } catch (Exception e) {
            return JsonUtil.fail("图片失败，请检查OSS配置并重新操作");
        }
    }
}