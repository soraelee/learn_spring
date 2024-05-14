package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration //설정에 관련된 내용임
public class FileConfig {
	@Bean
	public CommonsMultipartResolver  multipartResolver() { 
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		
		mr.setMaxUploadSize(52428800); //업로드된 파일의 사이즈 설정 50MB
		mr.setDefaultEncoding("utf-8");
		return mr;
	}

}
