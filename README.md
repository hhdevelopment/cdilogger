README
======

What is cdilogger ?
-------------------

cdilogger is easy use logger SLF4J for jee application with cdi weld

Requirements
------------

an application ear packaged, with bean.xml.
An the implementation of logger chosed in your classpath.
Logback is recommanded.

Installation
------------

Just add jar cdilogger.jar in ear.
and use injection in your code.

Documentation
-------------

``` java
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
```

