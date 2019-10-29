package com.linln.modules.gateway.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.linln.common.enums.StatusEnum;
import com.linln.common.utils.StatusUtil;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author chenmm
 * @date 2019/10/30
 */
@Data
@Entity
@Table(name="gateway_memu")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = StatusUtil.NOT_DELETE)
public class Memu implements Serializable {
    // 主键ID
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    // 菜单图标
    private String imageUrl;
    // 父级菜单id
//    private Long pid;
    // 别名
    private String rickName;
    // 排序序号
    private Integer sort;
    // 二级菜单样式
    private Integer style;
    // 二级菜单属性
    private Integer attribute;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pid")
    private List<Memu> smemu;

    @ManyToOne(targetEntity=Memu.class)
    @JoinColumn(name="pid")
    private Memu pid;

//
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Memu sMemu;

    // 状态
    private Byte status = StatusEnum.OK.getCode();
    // 创建时间
    @CreatedDate
    private Date createDate;
}