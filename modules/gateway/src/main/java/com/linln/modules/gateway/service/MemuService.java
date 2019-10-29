package com.linln.modules.gateway.service;

import com.linln.common.enums.StatusEnum;
import com.linln.modules.gateway.domain.Memu;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenmm
 * @date 2019/10/30
 */
public interface MemuService {

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    Page<Memu> getPageList(Example<Memu> example);

    /**
     * 根据ID查询数据
     * @param id 主键ID
     */
    Memu getById(Long id);

    /**
     * 保存数据
     * @param memu 实体对象
     */
    Memu save(Memu memu);

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> idList);

    /**
     * @params
     * @Description 查询全部一级菜单  <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/21 15:51
     */
    List<Memu> listAllOneLevel();

    /**
     * @params
     * @Description 查询全部二级菜单 <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/21 15:53
     */
    List<Memu> listAllTwoLevel();

    /**
      *
     * @params
     * @Description 查询全部  <br/>
     * @return 返回查询结果
     * @author chenmoumou
     * @createTime 2019/10/18 11:34
     */
    List<Memu> findAll();

    /**
      *
     * @params
     * @Description 根据id查询  <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/18 11:35
     */
    Memu findOneMemu(Long id);

    /**
      *
     * @params
     * @Description 根据 pid  查询 <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/18 11:36
     */
    List<Memu> findByPid(Long pid);

    /**
      *
     * @params
     * @Description 总数计数 <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/18 11:58
     */
    Long countAll();
}