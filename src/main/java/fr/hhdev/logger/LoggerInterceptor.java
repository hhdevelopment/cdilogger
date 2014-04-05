/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.hhdev.logger;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.MDC;

/**
 *
 * @author hhfrancois
 */
@Interceptor
@LoggerMDC(key="", value = "")
public class LoggerInterceptor implements Serializable {
	
	/**
	 * Positionne le MDC pour une méthode annoté LoggerMDC
	 * Si le MDC etait déjà positionné (non null) alors il est remit en sortie
	 * @param invocationContext
	 * @return
	 * @throws Exception 
	 */
	@AroundInvoke
	public Object decorate(InvocationContext invocationContext) throws Exception {
		LoggerMDC mdc = invocationContext.getMethod().getAnnotation(LoggerMDC.class);
		String oldValue = MDC.get(mdc.key());
		System.out.println("================MDC = "+oldValue);
		MDC.put(mdc.key(), mdc.value());
		Object result = invocationContext.proceed();
		if(oldValue!=null) {
			MDC.put(mdc.key(), oldValue);
		}
		return result;
	}
}
