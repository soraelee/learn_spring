package com.care.root.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyScheduler {
	@Scheduled(cron = "*/10 * * * * *") //10초에 한번 실행해주세요
	public void test1() {
		//특정 메소드를 어느 날짜에 실행해주세요
		System.out.println("-----10초에 한번-----");
	}
	@Scheduled(cron = "*0-59 * * * * *") //10초에 한번 실행해주세요
	public void test2() {
		//특정 메소드를 어느 날짜에 실행해주세요
		System.out.println("매초마다");
	}
}
