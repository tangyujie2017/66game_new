package cn.game.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	public interface Values {
		Long getGameServiceNumber();

		Long getGameSysSendScore();

		Integer getGameStartNumber();

		
	}

	@Value("${game.service.number}")
	private Long gameServiceNumber;
	@Value("${game.system.sendscore}")
	private Long gameSysSendScore;
	@Value("${game.start.number}")
	private Integer gameStartNumber;

	

	@Bean(name = "values")
	public Values values() {
		return new Values() {

			@Override
			public Long getGameServiceNumber() {

				return gameServiceNumber;
			}

			@Override
			public Long getGameSysSendScore() {

				return gameSysSendScore;
			}

			@Override
			public Integer getGameStartNumber() {

				return gameStartNumber;
			}

			
		};
	}
}
