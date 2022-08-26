package com.wecgcm.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DemoConfiguration {
    @Value("${mock.api.key}")
    private String mockApiKey;

    @Value("${MOCK_API_ENABLE:false}")
    private Boolean mockApiEnable;

    @Value("${secret.username}")
    private String userName;

    @Value("${secret.password}")
    private String password;
}
