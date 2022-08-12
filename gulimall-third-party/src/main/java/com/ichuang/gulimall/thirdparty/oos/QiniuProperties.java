package com.ichuang.gulimall.thirdparty.oos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "oos")
public class QiniuProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
}
