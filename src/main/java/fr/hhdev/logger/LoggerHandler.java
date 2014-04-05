/*
 * Exemple d'utilisation du pattern proxy
 * A mettrre dans le producer
 *		LoggerHandler handler = new LoggerHandler();
 *		handler.setLogger(LoggerFactory.getLogger(loggerName));
 *		Logger proxy = (Logger) Proxy.newProxyInstance(
 *				  Logger.class.getClassLoader(),
 *				  new Class[]{Logger.class},
 *				  handler);
 *		return proxy;
 */

package fr.hhdev.logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.slf4j.Logger;

/**
 *
 * @author hhfrancois
 */
public class LoggerHandler implements InvocationHandler {
	
	private Logger logger;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("DANS LE HANDLER");
		return method.invoke(logger, args);
	}
	
}
