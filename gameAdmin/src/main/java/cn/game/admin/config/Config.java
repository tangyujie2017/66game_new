package cn.game.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */
@Configuration
public class Config {

	public interface Values {
	
	}

	
	@Bean(name = "values")
	public Values values() {
		return new Values() {
		
		};
	}

}
