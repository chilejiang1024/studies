package work.zhili.password;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("work.zhili.password.mapper")
public class PasswordWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordWebApplication.class, args);
		System.out.println("password started ...");
	}
}
