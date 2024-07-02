package com.poscodx.jblog.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Configuration
public class LocaleConfig {
	// Locale Resolver
		@Bean
		public LocaleResolver localeResolver() {
			CookieLocaleResolver localeResolver = new CookieLocaleResolver();
			localeResolver.setCookieName("lang");
			localeResolver.setCookieHttpOnly(false);
			
			return localeResolver;
		}
		

}
