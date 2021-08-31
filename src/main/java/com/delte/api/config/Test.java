package com.delte.api.config;

import java.text.DecimalFormat;

/**
 * @Author rohit
 * @Date 31/08/21
 **/
public class Test {
    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("###.##");
        System.out.println(dF.format(10.155525));
    }
}
