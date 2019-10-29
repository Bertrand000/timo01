//package com.linln.modules.system.domain;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
///**
// *  
// *  * All rights Reserved, Designed By chenmoumou
// *  * @description     菜单实体类
// *     默认共二级菜单
// *  * @author chenmoumou    
// *  * @date   2019 2019/10/18 11:25  
// *  * @version V1.fontawesome.fontawesome
// *  
// */
//@Entity
//@Table(name = "gateway_memu")
//@Data
//public class GatewayMemu {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    /**
//     * 名称
//     */
//    private String name;
//
//    /**
//     * 图标
//     */
//    private String imageUrl;
//
//    /**
//     * 父级菜单id，一级菜单则为0
//     */
//    private Long pid;
//
//    /**
//     * 排序序号
//     */
//    @Column(name = "order")
//    private int order;
//
//    /**
//     * 前段菜单展示样式
//     */
//    private int style;
//
//    /**
//     * 二级菜单属性
//     */
//    private int attribute;
//
//    private byte status;
//
//}
