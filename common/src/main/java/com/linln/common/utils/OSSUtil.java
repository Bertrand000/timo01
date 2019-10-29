package com.linln.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Callback;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.linln.common.config.properties.ProjectProperties;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author ：chenmm
 * @date ：Created in 2019/10/29 21:29
 * @description：阿里云对象存储(OSS)工具类
 * @modified By：
 * @version: 1.0
 */
public class OSSUtil {
    /**
     * create by: chenmm
     * description: OSS视频上传
     * create time: 2019/10/29 23:40
     * @Param: null
     * @return
     */
    public static String videoUp(InputStream inputStream,String backName,String endpoint,String accessKeyId,String accessKeySecret,String filaName) throws Exception{
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        PutObjectResult putObjectResult = ossClient.putObject(backName, filaName, inputStream);
        // 关闭OSSClient
        ossClient.shutdown();
        return "";
    }

}
