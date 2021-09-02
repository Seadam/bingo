package com.example.bingo;

import com.example.bingo.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.bingo"})
@MapperScan(value = {
		"com.example.**.dao",
		"com.example.**.mapper"
},markerInterface = BaseMapper.class)
public class BingoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BingoApplication.class, args);
	}

}
