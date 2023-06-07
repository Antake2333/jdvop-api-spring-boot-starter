package com.orcas.autoconfigure;

import com.orcas.constant.JdVopApiConstant;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Orcas
 * @date 2022/10/22
 */
@Configuration
@EnableConfigurationProperties(JdVopProperties.class)
// 存在对应配置信息时初始化该配置类
@ConditionalOnProperty(
    prefix = JdVopApiConstant.JD_VOP, // 存在配置前缀hello
    value = "enabled", // 开启
    matchIfMissing = true)
public class JdVopAutoConfigure {}
