package cn.game.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import cn.game.core.Core;
@Import(Core.class)
@SpringBootApplication
public class AdminApplication {
	private static Logger logger = LogManager.getLogger(AdminApplication.class);

	public static void main(String[] args) {
		logger.info("游戏后台开始启动");
		SpringApplication.run(AdminApplication.class, args);
	}
}
