//package com.linln.modules.system.service.impl;
//
//import com.linln.modules.system.domain.GatewayMemu;
//import com.linln.modules.system.repository.GatewayMemuRepository;
//import com.linln.modules.system.service.GatewayMemuManageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// *  
// *  * All rights Reserved, Designed By chenmoumou
// *  * @description     菜单服务接口实体类
// *  * @author chenmoumou    
// *  * @date   2019 2019/10/18 11:36  
// *  * @version V1.fontawesome.fontawesome
// *  
// */
//@Service
//public class GatewayMemuManageServiceImpl implements GatewayMemuManageService {
//
//    @Autowired
//    GatewayMemuRepository memuDao;
//
//    @Override
//    public GatewayMemu saveAndEdit(GatewayMemu memu) {
//        return memuDao.saveAndFlush(memu);
//    }
//
//    /**
//      *
//     * @params
//     * @Description 查询全部一级菜单  <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/21 15:53
//     */
//    @Override
//    public List<GatewayMemu> listAllOneLevel() {
//        return memuDao.findAllOneLevel();
//    }
//
//    /**
//      *
//     * @params
//     * @Description 查询全部二级菜单  <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/21 15:53
//     */
//    @Override
//    public List<GatewayMemu> listAllTwoLevel() {
//        return memuDao.findAllTwoLevel();
//    }
//
//    @Override
//    public List<GatewayMemu> findAll() {
//        return memuDao.findAllOrderByOrder();
//    }
//
//    @Override
//    public GatewayMemu findOneMemu(Long id) {
//        return memuDao.findById(id).get();
//    }
//
//    @Override
//    public List<GatewayMemu> findByPid(Long pid) {
//        return memuDao.findByPidOrderByOrder(pid);
//    }
//
//    @Override
//    public Long countAll() {
//        return memuDao.count();
//    }
//}
