package com.test2.getit.configuration;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @ClassName: PictureConfiguration
 * @Description: 配置类，让本地图片位置与服务器位置匹配
 * @Author Chen Gavin
 * @Date 2022/3/25
 * @Version 1.0
 */

@Configuration
public class PictureConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Path/**").addResourceLocations("file:/D:/springproject/test1/src/main/resources/static/image/");
    }
}
