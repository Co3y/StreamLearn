package com.zengfk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.List;

/**
 * @Author: ZengFK
 * @Date: 2023/7/9 9:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // 用于后期的去重使用
public class Author {
    // id
    private Long id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 简介
    private String intro;
    // 作品
    private List<Book> books;
}
