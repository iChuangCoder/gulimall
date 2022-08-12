package com.ichuang.gulimall.thirdparty.controller;

import com.ichuang.gulimall.thirdparty.oos.QiniuProperties;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thirdparty/oss")
//@RestController
@Slf4j
public class OosController {


    @Autowired
    QiniuProperties qiniuProperties;

    @GetMapping("/policy")
    public String uploadToken(String fileName) {
        String accessKey = qiniuProperties.getAccessKey();
        String secretKey = qiniuProperties.getSecretKey();
        String bucket = qiniuProperties.getBucket();
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        log.info("上传凭证发出:{},上传文件:{}",upToken,fileName);
        return upToken;
    }

}
