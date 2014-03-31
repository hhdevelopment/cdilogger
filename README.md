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

<code java>
@LocalBean
@Stateless
package myPackage {
  public class MyEJB() {

    /**
     * This inject a logger name "myPackage.MyClass"
     * Like you write logger = LoggerFactory.getLogger(MyClass.class)
     */
    @Inject
    Logger logger;

    /**
     * And this inject logger named "SPECIFICLOGGER"
     * Like you write logger = LoggerFactory.getLogger("SPECIFICLOGGER")
     */
    @Inject
    @LoggerName("SPECIFICLOGGER")
    Logger logger;
  }
}
</code>

