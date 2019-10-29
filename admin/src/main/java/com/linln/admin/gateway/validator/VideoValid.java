package com.linln.admin.gateway.validator;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 * @author chenmm
 * @date 2019/10/29
 */
@Data
public class VideoValid implements Serializable {
    @NotEmpty(message = "标题不能为空")
    private String title;
//    @URL(message = "URL地址格式不对")
//    private String uri;

}