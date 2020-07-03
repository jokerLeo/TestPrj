package com.mrray.ray.common.plugin;

import com.mrray.ray.common.AESUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * 配置解密,只能自定义一个PropertySourcesPlaceholderConfigurer,否则会报异常
 *
 * @author lyc
 **/
public class EncryptPropertyPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer implements InitializingBean {

    /**
     * 需要解密的配置项前缀
     */
    private static final String PREFIX_ENC = "enc:";

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected Properties mergeProperties() throws IOException {
        Properties mergedProperties = new Properties();
        for (Properties localProp : localProperties) {
            mergedProperties.putAll(localProp);
        }

        for (Map.Entry entry : mergedProperties.entrySet()) {
            if (entry.getValue().toString().startsWith(PREFIX_ENC)) {
                String key = System.getProperty("enc.key");
                String value = entry.getValue().toString().replace(PREFIX_ENC, StringUtils.EMPTY);
                mergedProperties.setProperty(entry.getKey().toString(), AESUtil.decode(value, key));
            }
        }

        //针对sharding-jdbc datasource自定义解密的特殊处理
        //因为sharding-jdbc的datasource注入是从environment中获取propertySource,
        // 不能直接通过PropertySourcesPlaceholderConfigurer定义的datasource获取
        MutablePropertySources sources = ((ConfigurableEnvironment) environment).getPropertySources();
        sources.addFirst(new PropertiesPropertySource(LOCAL_PROPERTIES_PROPERTY_SOURCE_NAME, mergedProperties));

        return mergedProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        localOverride = true;
    }
}
