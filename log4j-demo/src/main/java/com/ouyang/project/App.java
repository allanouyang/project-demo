package com.ouyang.project;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Log4jA log4jA = new Log4jA();
        Log4jB log4jB = new Log4jB();
        Log4jC log4jC = new Log4jC();
        Log4jD log4jD = new Log4jD();
        log4jA.testLog();
        log4jB.testLog();
        log4jC.testLog();
        log4jD.testLog();
    }
}
