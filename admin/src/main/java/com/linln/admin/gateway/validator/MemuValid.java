package com.linln.admin.gateway.validator;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 * @author chenmm
 * @date 2019/10/30
 */
@Data
public class MemuValid implements Serializable {
    @NotEmpty(message = "菜单名不能为空")
    private String name;
}