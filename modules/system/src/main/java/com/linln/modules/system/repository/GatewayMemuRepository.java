//package com.linln.modules.system.repository;
//
//import com.linln.modules.system.domain.GatewayMemu;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
///**
// *  
// *  * All rights Reserved, Designed By chenmoumou
// *  * @description     菜单数据持久层
// *  * @author chenmoumou    
// *  * @date   2019 2019/10/18 11:29  
// *  * @version V1.fontawesome.fontawesome
// *  
// */
//public interface GatewayMemuRepository extends BaseRepository<GatewayMemu,Long> {
//
//    /**
//     * @params  * @Description 根据pid查询列表  <br/>
//     *  * @return
//     *  * @author chenmoumou
//     *  * @createTime 2019/10/18 11:44
//     *  
//     */
//    List<GatewayMemu> findByPidOrderByOrder(Long pid);
//
//
//    /**
//     * @params  * @Description 查询全部并根据序号排序  <br/>
//     *  * @return
//     *  * @author chenmoumou
//     *  * @createTime 2019/10/21 9:59
//     *  
//     */
//    @Query(value="select * from gateway_memu order by order",nativeQuery = true)
//    List<GatewayMemu> findAllOrderByOrder();
//
//    /**
//     * @params
//     * @Description 查询一级菜单  <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/21 15:58
//     */
//    @Query(value = "select * from gateway_memu where pid=0 order by order ",nativeQuery = true)
//    List<GatewayMemu> findAllOneLevel();
//
//    /**
//     * @params
//     * @Description TODO  <br/>
//     * @return
//     * @author chenmoumou
//     * @createTime 2019/10/21 15:59
//     */
//    @Query(value = "select * from gateway_memu where pid!=0 order by order ",nativeQuery = true)
//    List<GatewayMemu> findAllTwoLevel();
//}
//
