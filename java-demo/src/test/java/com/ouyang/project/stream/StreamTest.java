package com.ouyang.project.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ouyang on 2017/12/16.
 */
public class StreamTest {

    @Test
    public void testStreamGenerate() {
        Stream s1 = Stream.generate(new Supplier<Double>() {

            @Override
            public Double get() {
                return Math.random();
            }
        });
        System.out.println("s1 line: ");
        s1.limit(10).forEach(System.out::println);
        Stream s2 = Stream.generate(Math::random);
        System.out.println("s2 line: ");
        s2.limit(10).forEach(System.out::println);
        Stream s3 = Stream.generate(() -> Math.random());
        System.out.println("s3 line: ");
        s3.limit(10).forEach(System.out::println);
    }

    @Test
    public void testStreamIterator() {
        Stream.iterate(2, item -> item + 1).limit(10).forEach(System.out::println);
    }

    @Test
    public void testStreamMix() {
        List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("sum is:"+nums.stream().filter(num -> num != null).
        distinct().mapToInt(num -> num * 2)
                .skip(2)
                .peek(System.out::println)
                .limit(4).sum());
    }

    @Test
    public void testStreamCollection() {
        List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        List<Integer> numsWithoutNull = nums.stream().filter(item -> item != null)
                .collect(() -> new ArrayList<Integer>(),
                        (list, item) -> list.add(item),
                        (list1, list2) -> list1.addAll(list2));
        List<Integer> numsWithoutNull2 = nums.stream().filter(item -> item != null)
                .collect(Collectors.toList());
        numsWithoutNull.forEach(System.out::println);
        numsWithoutNull2.forEach(System.out::println);
    }

    @Test
    public void testStreamReduce() {
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());
        Integer r = ints.stream().reduce(0, (sum, item) -> sum + item);
        System.out.println("ints sum is:" + r);
        System.out.println(ints.stream().allMatch(item -> item < 8));
        ints.stream().max((o1, o2) -> o1.compareTo(o2)).ifPresent(System.out::println);
        System.out.println(ints.stream().max((o1, o2) -> o1.compareTo(o2)).get());
    }

    @Test
    public void testStreamPeek() {
        List<String> s = Stream.of("one", "two", "three", "four")
                .filter(item -> item.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        s.forEach(System.out::println);
    }
}
