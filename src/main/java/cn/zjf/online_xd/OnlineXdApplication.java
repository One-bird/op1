package cn.zjf.online_xd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.zjf.online_xd.mapper")
@EnableTransactionManagement
public class OnlineXdApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineXdApplication.class, args);
	}

}
