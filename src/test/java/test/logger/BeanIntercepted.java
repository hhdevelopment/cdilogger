/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.logger;

import fr.hhdev.logger.LoggerMDC;

/**
 *
 * @author hhfrancois
 */
public class BeanIntercepted {
	
	@LoggerMDC(key = "MDC", value = "TEST")
	public void methodWithMDCUpdated() {
		
	}
	
	@LoggerMDC(key = "MDC", value = "TEST2")
	public void method2WithMDCUpdated() {
		
	}
}
