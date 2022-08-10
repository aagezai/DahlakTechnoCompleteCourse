package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class A {
    public static void main(String args[]){

        Set a = null;
        Set b = null;
        List<String> c = null;
        c.addAll(a);
        c.addAll(b);
        c.stream().filter(el -> a.contains(el) && b.contains(el)).collect(Collectors.toList());



    }
}
