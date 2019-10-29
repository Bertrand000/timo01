//package com.linln.modules.system.service;
//
//import com.linln.modules.system.domain.GatewayMemu;
//
//import java.util.List;
//
///**
// *  
// *  * All rights Reserved, Designed By chenmoumou
// *  * @description    菜单管理服务接口
// *  * @author chenmoumou    
// *  * @date   2019 2019/10/18 11:31  
// *  * @version V1.fontawesome.fontawesome
// *  
// */
//public interface GatewayMemuManageService {
//
//    /**
//      *
//     * @params
//     * @Description 添加或编辑数据 <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/18 11:33
//     */
//    GatewayMemu saveAndEdit(GatewayMemu memu);
//
//    /**
//     * @params
//     * @Description 查询全部一级菜单  <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/21 15:51
//     */
//    List<GatewayMemu> listAllOneLevel();
//
//    /**
//     * @params
//     * @Description 查询全部二级菜单 <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/21 15:53
//     */
//    List<GatewayMemu> listAllTwoLevel();
//
//    /**
//      *
//     * @params
//     * @Description 查询全部  <br/>
//     * @return 返回查询结果
//     * @author chenmoumou
//     * @createTime 2019/10/18 11:34
//     */
//    List<GatewayMemu> findAll();
//
//    /**
//      *
//     * @params
//     * @Description 根据id查询  <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/18 11:35
//     */
//    GatewayMemu findOneMemu(Long id);
//
//    /**
//      *
//     * @params
//     * @Description 根据 pid  查询 <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/18 11:36
//     */
//    List<GatewayMemu> findByPid(Long pid);
//
//    /**
//      *
//     * @params
//     * @Description 总数计数 <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/18 11:58
//     */
//    Long countAll();
//
//}
