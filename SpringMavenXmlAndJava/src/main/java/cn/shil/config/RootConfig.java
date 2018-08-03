package cn.shil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置扫描的service、dao、model等bean
 */
@Configuration
@ComponentScan({"cn.shil.dao","cn.shil.entity","cn.shil.service","cn.shil.common"})
public class RootConfig {
}
