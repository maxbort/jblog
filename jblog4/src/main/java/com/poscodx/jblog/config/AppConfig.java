package com.poscodx.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.poscodx.jblog.config.app.DBConfig;
import com.poscodx.jblog.config.app.MyBatisConfig;

@Configuration // 스프링 설정 클래스 명시
@EnableAspectJAutoProxy // Spring AOP 지원 활성화
@EnableTransactionManagement // Spring 선언전 트랜잭션 관리 활성화
@ComponentScan({"com.poscodx.jblog.service", "com.poscodx.jblog.repository", "com.poscodx.jblog.aspect"}) // 지정된 패키지에서 스프링 Bean 검색 후 자동 등록
@Import({DBConfig.class, MyBatisConfig.class}) // 다른 구성 클래스 가져와서 이 클래스 일부로 포함
public class AppConfig {

}
