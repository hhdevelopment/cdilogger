/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.hhdev.logger;

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
     * @param injectionPoint
     * @return
     */
    @Produces
    @Default
    public Logger getLogger(InjectionPoint injectionPoint) {
        String loggerName = injectionPoint.getMember().getDeclaringClass().getName();
        return LoggerFactory.getLogger(loggerName);
    }

    /**
     *
     * @param injectionPoint
     * @return
     */
    @Produces
    @LoggerName("")
    public Logger getLoggerNamed(InjectionPoint injectionPoint) {
        Annotated annotated = injectionPoint.getAnnotated();
        LoggerName ln = annotated.getAnnotation(LoggerName.class);
        return LoggerFactory.getLogger(ln.value());
    }
}
