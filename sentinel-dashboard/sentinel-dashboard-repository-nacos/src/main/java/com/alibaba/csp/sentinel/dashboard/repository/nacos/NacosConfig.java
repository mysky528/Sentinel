package com.alibaba.csp.sentinel.dashboard.repository.nacos;

import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author cdfive
 */
@Configuration
@ConditionalOnClass(ConfigService.class)
@ConditionalOnProperty(name = "rule.repository.type", havingValue = "nacos")
@EnableConfigurationProperties(NacosProperties.class)
public class NacosConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(NacosConfig.class);

    @Autowired
    private NacosProperties nacosProperties;

    @Bean
    @ConditionalOnMissingBean
    public ConfigService nacosConfigService() throws Exception {
        String serverAddr = nacosProperties.getServerAddr();
        AssertUtil.notEmpty(serverAddr, "Nacos ConfigService init failed, serverAddr can't be empty");

        LOGGER.info("Nacos ConfigService init start, serverAddr={}", serverAddr);
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, serverAddr);
        try {
            ConfigService configService = ConfigFactory.createConfigService(properties);
            LOGGER.info("Nacos ConfigService init success");
            return configService;
        } catch (Throwable e) {
            LOGGER.error("Nacos ConfigService init error", e);
            throw e;
        }
    }
}
