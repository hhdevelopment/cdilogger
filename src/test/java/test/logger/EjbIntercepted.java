/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.logger;

import fr.hhdev.logger.LoggerMDC;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author hhfrancois
 */
@Stateless
@LocalBean
public class EjbIntercepted implements Serializable {

	@Inject
	private Logger logger;

	@LoggerMDC(key = "MDC", value = "TEST2")
	public void methodWithMDCUpdated() {
		logger.debug("Call : "+this.getClass().getSimpleName()+".methodWithMDCUpdated()");
	}
	
}
