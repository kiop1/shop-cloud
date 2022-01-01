package cn.xyq.cloud.websitefontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebsiteFontendApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteFontendApplication.class, args);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*") //允许所有域
//                .allowedMethods("*") //允许所有请求方法(post、get等)
//                .allowCredentials(true) //允许证书
//                .maxAge(3600); //表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
//    }
}
