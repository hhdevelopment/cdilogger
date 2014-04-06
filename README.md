README
======

What is cdilogger ?
-------------------

cdilogger is easy use logger SLF4J for jee application with cdi weld

Requirements
------------

An application ear/war packaged, with bean.xml.
An the implementation of logger chosed in your classpath.
Logback is recommanded.

Installation
------------

Just add jar cdilogger.jar in lib of your ear or war.
and use injection in your code.

Documentation
-------------

``` java
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

You can add MDC infos, like you can for example mark a specific thread

``` java
@Stateless
package myPackage {
  public class MyBoundaryEJB() {

    /**
     * This inject a logger name "myPackage.MyClass"
     * Like you write logger = LoggerFactory.getLogger(MyClass.class)
     */
    @Inject
    Logger logger;

    @LoggerMDC(key="CALL", value="EXTERN")
    public String getMessage() {
      String msg = "foo";
      // call logger method
      logger.info("call getMessage : {}", msg);
    }
  }
}
```

Here the method 'getMessage' is decorate by the additionnal MDC setting.
if MDC settings are cascading, the previous setting is define when the method done.

```
<appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender"> 
  <layout>
    <Pattern>%X{CALL} - %m%n</Pattern>
  </layout> 
</appender>
```

```
log : EXTERN - call getMessage : foo
```




