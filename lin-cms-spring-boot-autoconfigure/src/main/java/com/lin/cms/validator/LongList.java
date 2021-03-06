package com.lin.cms.validator;

import javax.validation.Payload;

/**
 * 整型列表校验，校验 List<Long> 类型
 */
public @interface LongList {

    String message() default "Integer list cannot can't be blank";

    /**
     * 每一个整数的最小值
     */
    long min() default 0;

    /**
     * 每一个整数的最大值
     */
    long max() default Long.MAX_VALUE;

    /**
     * 允许链表为 NULL 和 size == 0
     */
    boolean allowBlank() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
