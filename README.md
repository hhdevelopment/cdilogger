README
======

What is cdilogger?
-----------------

cdilogger is easy use logger for jee application with cdi weld

Requirements
------------

an application ear packaged, with bean.xml.

Installation
------------

Just add jar cdilogger.jar in ear.
and use injection in your code.

Documentation
-------------

@LocalBean
@Stateless
public class MyEJB {

@Inject
private Logger logger;


@Inject
@LoggerName("SECURITY")
private Logger loggerSecurity;


}

