
package com.poscodx.jblog.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Auth {
	// public String value() default "test";
	public enum Role {ADMIN, USER};
	public Role role() default Role.USER;
	public boolean test() default true;
}
