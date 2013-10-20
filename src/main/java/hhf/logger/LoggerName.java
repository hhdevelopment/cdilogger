/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhf.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author François
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LoggerName {
	String value();
}
