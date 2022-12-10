package cn.edu.hutb.exam.config;

import cn.edu.hutb.exam.core.shiro.JwtUtils;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 在请求头当中配置JWT令牌字符串，SpringDoc需要额外在方法上添加注解，我们也可以在Knife4j中设置全局请求头
                .components(new Components().addSecuritySchemes(JwtUtils.TOKEN_HEADER_FIELD, new SecurityScheme()))
                .info(new Info()
                        .title("在线考试系统 API")
                        .version("0.0.1")
                        .contact(new Contact().name("田章").url("https://iiifox.github.io/").email("tianzhang.chn@gmail.com"))
                        .description("使用Knife4j集成SpringDoc-OpenApi生成的后端API接口文档，" +
                                "提供导出4种格式的离线文档(Html/Markdown/Word/OpenAPI)的功能。")
                        .license(new License().name("Apache 2.0")));
    }

}