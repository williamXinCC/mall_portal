package com.william.mall_portal;

import cn.hutool.setting.dialect.Props;
import com.william.mall_portal.config.MyDateConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class WilliamPortalApplication implements WebMvcConfigurer {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
				.maxAge(3600)
				.allowCredentials(true);
	}

	@Bean
	public Converter<String, Date> addNewConvert() {
		return new MyDateConvert() ;
	}

	@Bean("url_properties")
	public HashSet<String> loadUrl(){
		// 读取放行的url
		Props properties = new Props("props/interceptorUrl.properties","UTF-8");
		// 遍历判断url是否放行
		Enumeration enu=properties.elements();
		HashSet<String> set = new HashSet<String>();
		while(enu.hasMoreElements()){
			String key = (String)enu.nextElement();
			set.add(key);
		}
		return set;
	}


	public static void main(String[] args) {
		SpringApplication.run(WilliamPortalApplication.class, args);
	}

}
