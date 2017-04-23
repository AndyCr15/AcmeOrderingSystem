package com.Acme.testing;

import com.Acme.utils.MyDate;

/**
 * Created by AndyCr15 on 15/03/2017.
 */
public class PassByExperiment {


    public static void passObject(MyDate d) {
        d.setYear(2009);
    }

    public static void passPrimitive(int i) {
        i = 2010;
    }

    public static void passString(String s) {
        int yearSlash = s.lastIndexOf('/');
        s = s.substring(0, yearSlash + 1);
        s += "2012";
        System.out.println("New date string: " + s);
    }

    public static void passStringBuilder(StringBuilder sb) {
        sb.setLength(Math.max(sb.length() - 4, 0));
        sb.append(2012);
        System.out.println("New date string: " + sb);
    }
}