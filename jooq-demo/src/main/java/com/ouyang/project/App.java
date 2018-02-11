package com.ouyang.project;

import com.ouyang.project.jooq.Main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void m(Main.TestCanal t){
        t.setId(2);
        t = new Main.TestCanal();
        t.setId(3);
    }
    public static void main( String[] args )
    {
        Main.TestCanal t = new Main.TestCanal();
        t.setId(1);
        m(t);
        System.out.println(t.getId());
    }
}
