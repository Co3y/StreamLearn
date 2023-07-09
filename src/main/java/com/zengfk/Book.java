package com.zengfk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: ZengFK
 * @Date: 2023/7/9 9:46
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // 用于后期的去重使用
public class Book {
    // id
    private Long id;
    // 书名
    private String name;
    // 分类
    private String category;
    // 评分
    private Integer score;
    // 简介
    private String intro;
}
