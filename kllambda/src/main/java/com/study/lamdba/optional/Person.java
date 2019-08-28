package com.study.lamdba.optional;

import java.util.Objects;

/**
 * @Auther: dalele
 * @Date: 2019/8/28 22:50
 * @Description:
 */

public class Person {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;
    /**
     * 状态
     */
    private String status;

    public  Person(){

    }

    public  Person(String name,int age){
        this.age=age;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(status, person.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, status);
    }
}
