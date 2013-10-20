/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhf.logger;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author François
 */
public class LoggerProducer {
	
	/**
	 *
	 * @param ip
	 * @return
	 */
	@Produces
	@Default
	public Logger getLogger(InjectionPoint injectionPoint) {
		String loggerName = injectionPoint.getMember().getDeclaringClass().getName();
		Annotated annotated = injectionPoint.getAnnotated();
		if(annotated.isAnnotationPresent(LoggerName.class)) {
			LoggerName ln = annotated.getAnnotation(LoggerName.class);
			loggerName = ln.value();
		}
		return LoggerFactory.getLogger(loggerName);
	}
}
