package cn.edu.hutb.exam;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@MapperScan("cn.edu.hutb.exam.modules.**.mapper")
public class OnlineExamApiApplication {

    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext application = SpringApplication.run(OnlineExamApiApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        // 未配置默认8080
        if (port == null) {
            port = "8080";
        }
        String path = env.getProperty("server.servlet.context-path");
        // 未配置默认空白
        if (path == null) {
            path = "";
        }

        log.info("\n----------------------------------------------------------\n\t" +
                "在线考试系统启动成功，访问路径如下:\n\t" +
                "本地路径: \thttp://localhost:" + port + path + "/\n\t" +
                "网络地址: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "API文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }

}
