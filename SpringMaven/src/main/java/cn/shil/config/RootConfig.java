package cn.shil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置扫描的service、dao、model等bean
 */
@Configuration
@ComponentScan({"cn.shil.repository"})
public class RootConfig {
}
