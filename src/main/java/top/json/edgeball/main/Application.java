package top.json.edgeball.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(
        scanBasePackages = {"top.json.edgeball"}
)
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String []args) {
        logger.info("开始启动...");

        SpringApplication application = new SpringApplication(Application.class);
        application.setWebEnvironment(true);
        try {
            application.run(args);
        } catch (Error error) {
            logger.error("应用启动失败!", error);
        }
    }
}
