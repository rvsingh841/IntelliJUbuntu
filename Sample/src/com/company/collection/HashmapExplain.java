package com.company.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashmapExplain {
    public static void main(String[] args) {
        MyClass first = new MyClass("Ravi","Singh");
        MyClass second = new MyClass("Ravi","Singh");
        System.out.println(first.equals(second));
        System.out.println(first==second);
        Map<MyClass,String> map = new HashMap<>();
        map.put(first,"first");
        map.put(second,"second");
        System.out.println(map);
    }
}

class MyClass{
    private final String a;
    private final String b;

    public MyClass(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(a, myClass.a) &&
                Objects.equals(b, myClass.b);
    }


    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}