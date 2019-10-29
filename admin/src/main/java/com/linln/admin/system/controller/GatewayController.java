package com.linln.admin.system.controller;

import com.linln.modules.gateway.domain.Memu;
import com.linln.modules.gateway.service.MemuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：chenmm
 * @date ：Created in 2019/10/29 17:55
 * @description：门户主页
 * @modified By：
 * @version: 1.0
 */
@Controller
@RequestMapping("/gateway/index/")
public class GatewayController {
    @Autowired
    MemuService memuManageService;

    /**
     * IndexView
     * @params [model]
     * @Description 首页视图<br/>
     * @return java.lang.String
     * @author 陈某某
     * @createTime 2019/9/10 16:04
     */
    @RequestMapping("view")
    public String IndexView(Model model){
        List<Memu> oneLevel = memuManageService.listAllOneLevel();
        List<Memu> twoLevel = memuManageService.listAllTwoLevel();
        List<List> handledMemu = memuHandle(twoLevel);
        model.addAttribute("oneLevel",oneLevel);
        model.addAttribute("twoLevel",twoLevel);
        model.addAttribute("newSee",handledMemu.get(0));
        model.addAttribute("other",handledMemu.get(1));
        model.addAttribute("oneStyle",handledMemu.get(2));
        return "/gateway/index";
    }


    /**
     *
     * @params
     * @Description 菜单分类处理  <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/23 14:41
     */
    public List<List> memuHandle(List<Memu> mList){
        List<Memu> seeList = new ArrayList<>();
        List<Memu> otherList = new ArrayList<>();
        List<Memu> oneStyleList = new ArrayList<>();
        List<List> newsList = new ArrayList<>();
        for (Memu m: mList ) {
            if(m.getAttribute()==1 && m.getStyle() == 2)
                seeList.add(m);
            if(m.getAttribute()==2 && m.getStyle() == 2)
                otherList.add(m);
            if(m.getStyle() == 1)
                oneStyleList.add(m);
        }

        newsList.add(seeList);
        newsList.add(otherList);
        newsList.add(oneStyleList);

        return newsList;
    }
}
