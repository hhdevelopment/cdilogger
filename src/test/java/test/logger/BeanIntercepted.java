/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.logger;

import fr.hhdev.logger.LoggerMDC;
import javax.ejb.EJB;

/**
 *
 * @author hhfrancois
 */
public class BeanIntercepted {
	
	@EJB
	private EjbIntercepted ejb;

	@LoggerMDC(key = "MDC", value = "TEST")
	public void methodWithMDCUpdated() {
		
	}
	
	@LoggerMDC(key = "MDC", value = "TEST2")
	public void method2WithMDCUpdated() {
		
	}

	public void methodWithCallEJB() {
		ejb.methodWithMDCUpdated();
	}
}
