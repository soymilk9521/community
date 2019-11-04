package com.airskr.community.config;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  fastJson转换格式配置（单例模式）
 *  fastJson支持四种格式：
 *  camelCase： personId（默认格式）
 *  snakeCase： person_id
 *  PascalCase： PersonId
 *  KebabCase： person-id
 *
 * </p>
 *
 * @author KR
 * @since 2019/11/04 10:00
 */
@Component
public class FastJsonSerializeConfig {
    @Bean("snakeCaseSerializeConfig")
    @Scope("singleton")
    public SerializeConfig snakeCaseSerializeConfig() {
        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        return config;
    }
}
