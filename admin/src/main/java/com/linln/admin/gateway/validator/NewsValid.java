package com.linln.admin.gateway.validator;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 * @author chenmm
 * @date 2019/10/29
 */
@Data
public class NewsValid implements Serializable {
    @NotEmpty(message = "标题不能为空")
    private String title;
}