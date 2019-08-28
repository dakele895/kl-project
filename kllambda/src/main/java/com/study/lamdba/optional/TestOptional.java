package com.study.lamdba.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @Auther: dalele
 * @Date: 2019/8/28 22:49
 * @Description:
 * Optional.empty() : 创建一个空的 Optional 实例
 * Optional.of(T t) : 创建一个 Optional 实例
 * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * isPresent() : 判断是否包含值
 * T get(): 如果调用对象包含值，返回该值，否则抛异常
 * orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
 * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

    @Test
    public void test() {
        // Optional.of(T t) : 创建一个 Optional 实例,参数也可为null 表示把null封装进了OPtional容器
        Optional<Person> optional = Optional.of(new Person("李四", 59));

        // T get(): 如果调用对象包含值，返回该值，否则抛异常
        Person person = optional.get();
        System.out.println("person" + person);
        System.out.println("===========");
        // 参数设为null的情况 会报空指针异常
        Optional<Person> optiona2 = Optional.of(null);
        System.out.println(optiona2.get());

    }


    @Test
    public void test1() {
        // Optional.empty() :创建一个空的Optional实例
        Optional<Person> empty = Optional.empty();
        // 因为Optional容器里面是空的 所以报了个NoSuchElementException，这样容易定位空指针
        // 和Optional.of(null)还不太一样。Optional.of(null).get()就报了个空指针
        System.out.println("empty.get():" + empty.get());
    }


    @Test
    public void test2() {
        // Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
        Optional<Object> nullable = Optional.ofNullable(null);
        // T为null创建空实例，融合了of()方法的缺陷
        System.out.println("nullable:" + nullable);
    }

    @Test
    public void test3() {
        Optional<Object> nullable = Optional.ofNullable(null);
        Optional<Person> person=Optional.ofNullable(null);
        // isPresent() : 判断是否包含值 nullable为空 所以返回false
        boolean present = nullable.isPresent();
        System.out.println("present:" + present);
    }

    @Test
    public void test4() {
        Optional<Person> optional = Optional.of(new Person("李四", 59));
        // orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
        // 就是先看optional这个容器里面有值与否 若有，则直接返回 若没有 返回T
        Object orElse = optional.orElse(new Person());
        System.out.println(orElse);
    }

    @Test
    public void test5() {
        // orElseGet(Supplier s) :如果调用对象(调用者是Optional类)包含值，返回该值，否则返回 s 获取的值
        // 和上面不同的是这里的参数需要我们提供一个Supplier类型的函数式接口
        // ，这样我们就可以在Lambda表达式体中写自己的逻辑没最后返回个T
        Optional<Person> optional = Optional.of(new Person("李四", 59));
        Person orElseGet = optional.orElseGet(() -> new Person());
        // 因为optional包含的对象是有值的。所以返回new Person("李四", 59)
        System.out.println("orElseGet:" + orElseGet);
        Optional<Object> nullable = Optional.ofNullable(null);
        // 这个nulllable时空的
        Object elseGet = nullable.orElseGet(() -> new Person());
        // 所以返回参数(函数式接口与返回的值，即无参构造器返回的是默认值)
        System.out.println("elseGet:" + elseGet);
    }

    @Test
    public void test6() {
        // map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
        Optional<Person> optional = Optional.of(new Person("李四", 59));
        Optional<String> map = optional.map(Person::getName);
        System.out.println("map:"+map);
    }

    @Test
    public void test7() {
        // flatMap(Function mapper):与 map 类似，
        Optional<Person> optional = Optional.of(new Person("李四", 59));
        //要求返回值必须是Optional  所以在参数那里 Lambda表达式的返回值用Optional包装了一层
        Optional<String> flatMap = optional.flatMap((e) -> Optional.of(e.getName()));
        System.out.println("flatMap"+flatMap);
    }


    @Test
    public void test8() {
        Father father =new Father();
        //报了个空指针
        //getSonName(father);
        //可以用if判断语句嵌套判断 避免空指针 但若嵌套太深  代码可读性也会变差
        Optional<Father2> optional = Optional.ofNullable(new Father2(Optional.ofNullable(new Son("小明"))));
        System.out.println(getSonName1(optional));;
    }
    //需求：获取父亲的儿子的名字
    public String getSonName(Father father) {
        return father.getSon().getName();
    }
    //传进来的father也有可能为空   所以用Optional包装
    public String getSonName1(Optional<Father2> optional) {
        //若传进来的对象为空没给一个默认值，保证了传进来的对象不会为空
        return optional.orElse(new Father2())
                .getSon()
                //这个人可能还没有儿子，若没有 默认为孙悟空   避免了getName()方法的空指针
                .orElse(new Son("孙悟空"))
                .getName();
    }




}
