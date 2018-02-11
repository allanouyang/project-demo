package com.ouyang.project.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by ouyang on 2017/8/14.
 */
public class OptionalTest {
    @Test(expected = NullPointerException.class)
    public void testOf() {
        Optional<String> name = Optional.of("Sanaulla");
        Assert.assertEquals(name.get(), "Sanaulla");
        Optional<String> someNull = Optional.of(null);
    }

    @Test
    public void testOfNullable() {
        Optional empty = Optional.ofNullable(null);
        Assert.assertFalse(empty.isPresent());
    }

    @Test
    public void testIfPresent() {
        Optional<String> name = Optional.of("Sanaulla");
        name.ifPresent((value) -> Assert.assertEquals(value, "Sanaulla"));
        Optional empty = Optional.ofNullable(null);
        empty.ifPresent((value) -> System.out.println("此行不执行..."));
    }

    @Test
    public void testOrElse() {
        Optional<String> name = Optional.of("Sanaulla");
        Assert.assertEquals(name.orElse("There is some value"), "Sanaulla");
        Optional empty = Optional.ofNullable(null);
        Assert.assertEquals(empty.orElse("There is no value present!"), "There is no value present!");
    }

    @Test
    public void testOrElseGet() {
        Optional<String> name = Optional.of("Sanaulla");
        Assert.assertEquals(name.orElseGet(() -> "Default Value"), "Sanaulla");
        Optional empty = Optional.ofNullable(null);
        Assert.assertEquals(empty.orElseGet(() -> "Default Value"), "Default Value");
    }

    @Test
    public void testOrElseThrow() {
        Optional<String> name = Optional.of("Sanaulla");
        Assert.assertEquals(name.orElseGet(() -> "Default Value"), "Sanaulla");
        try {
            name.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
        Optional empty = Optional.ofNullable(null);
        try {
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }

    private class ValueAbsentException extends Throwable {
        public ValueAbsentException() {
            super();
        }

        public ValueAbsentException(String msg) {
            super(msg);
        }

        @Override
        public String getMessage() {
            return "No value present in the Optional instance";
        }
    }

    @Test
    public void testMap() {
        Optional<String> name = Optional.of("Sanaulla");
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        Assert.assertEquals(upperName.orElse("Default Value"), "SANAULLA");
        Optional<String> upperName2 = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName2.orElse("No value found"));//输出SANAULLA
//        Optional empty = Optional.ofNullable(null);
//        Optional<String> empty2 = empty.map((value) -> value.toLowerCase());
//        Assert.assertEquals(empty2.orElse("Default Value"), "Default Value");
    }

    @Test
    public void testFilter() {
        Optional<String> name = Optional.of("Sanaulla");
        //filter方法检查给定的Option值是否满足某些条件。
        //如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));//输出Sanaulla

        //另一个例子是Optional值不满足filter指定的条件。
        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        //输出：name长度不足6字符
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }

    @Test
    public void testAll() {
        //创建Optional实例，也可以通过方法返回值得到。
        Optional<String> name = Optional.of("Sanaulla");

        //创建没有值的Optional实例，例如值为'null'
        Optional empty = Optional.ofNullable(null);

        //isPresent方法用来检查Optional实例是否有值。
        if (name.isPresent()) {
            //调用get()返回Optional值。
            System.out.println(name.get());
        }

        try {
            //在Optional实例上调用get()抛出NoSuchElementException。
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //ifPresent方法接受lambda表达式参数。
        //如果Optional值不为空，lambda表达式会处理并在其上执行操作。
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });

        //如果有值orElse方法会返回Optional实例，否则返回传入的错误信息。
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));

        //orElseGet与orElse类似，区别在于传入的默认值。
        //orElseGet接受lambda表达式生成默认值。
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(() -> "Default Value"));

        try {
            //orElseThrow与orElse方法类似，区别在于返回值。
            //orElseThrow抛出由传入的lambda表达式/方法生成异常。
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        //map方法通过传入的lambda表达式修改Optonal实例默认值。
        //lambda表达式返回值会包装为Optional实例。
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        //flatMap与map（Funtion）非常相似，区别在于lambda表达式的返回值。
        //map方法的lambda表达式返回值可以是任何类型，但是返回值会包装成Optional实例。
        //但是flatMap方法的lambda返回值总是Optional类型。
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));

        //filter方法检查Optiona值是否满足给定条件。
        //如果满足返回Optional实例值，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));

        //另一个示例，Optional值不满足给定条件。
        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }
}
