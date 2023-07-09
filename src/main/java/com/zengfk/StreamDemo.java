package com.zengfk;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: ZengFK
 * @Date: 2023/7/9 9:50
 */

public class StreamDemo {

    public static void main(String[] args) {
        List<Author> authors = getAuthors();

        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));

        for (Map.Entry<String, List<Book>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
//        Set<Book> bookSet = authors.stream()
//                .flatMap(author -> author.getBooks().stream())
//                .collect(Collectors.toSet());
//        System.out.println(bookSet);

//        List<String> nameList = authors.stream()
//                .map(Author::getName)
//                .collect(Collectors.toList());
//        System.out.println(nameList);


//        Optional<Integer> max = authors.stream()
//                .flatMap(author -> author.getBooks().stream())
//                .distinct()
//                .map(book -> book.getScore())
//                .min((o1, o2) -> o1 - o2);
//        System.out.println(max.get());
//        authors.stream()
//                .map(Author::getName)
//                .distinct()
//                .forEach(System.out::println);

//        authors.stream()
//                .flatMap(author -> author.getBooks().stream())
//                .distinct()
//                .flatMap(book -> Arrays.stream(book.getCategory().split("，")))
//                .distinct()
//                .forEach(System.out::println);

//        authors.stream()
//                .flatMap(author -> author.getBooks().stream())
//                .distinct()
//                .forEach(book -> System.out.println(book.getName()));

//        authors.stream()
//                .map(Author::getBooks)
//                .forEach(books -> {
//                    for (Book book : books) {
//                        System.out.println(book);
//                    }
//                });


//        authors.stream()
//                .distinct()
//                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
//                .skip(1)
//                .forEach(author -> System.out.println(author.getName()));


//        authors.stream()
//                .map(author -> author.getName())
//                .forEach(s -> System.out.println(s));
//        authors.stream()
//                .map(Author::getAge)
//                .map(age -> age + 10)
//                .forEach(System.out::println);

//        Integer[] arr = {1, 2, 3, 4, 5};
//        Stream<Integer> stream1 = Arrays.stream(arr);
//        Stream<Integer> stream2 = Stream.of(arr);
//        Map<String, Integer> map = new HashMap<>();
//        map.put("蜡笔小新", 19);
//        map.put("黑子", 17);
//        map.put("日向", 16);
//
//        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();


//        test01(authors);
    }

    // 打印所有年龄小于18的作家的名字，并且去重
    private static void test01(List<Author> authors) {
        authors.stream()    // 把集合转换成流
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        // 数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        // 书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧", "哲学，爱情", 88, "用一把刀"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长，爱情", 99, "讲述如何"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维"));
        books2.add(new Book(4L, "吹或不吹", "爱情，个人传记", 56, "一个哲学家的爱恨离愁"));

        books3.add(new Book(5L, "你的剑", "爱情", 56, "无法想象"));
        books3.add(new Book(6L, "附件", "个人传记", 100, "两个哲学家的灵魂"));
        books3.add(new Book(6L, "附件", "个人传记", 100, "两个哲学家的灵魂"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;

    }

}
