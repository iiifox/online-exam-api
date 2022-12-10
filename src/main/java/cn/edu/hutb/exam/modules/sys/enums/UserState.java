package cn.edu.hutb.exam.modules.sys.enums;

import lombok.Getter;

/**
 * @author 田章
 * @description 用户状态枚举类
 * @datetime 2022/12/10 21:05
 */
@Getter
public enum UserState {

    /**
     * 普通状态，正常的
     */
    NORMAL(0),

    /**
     * 非正常状态，禁用，下架等
     */
    ABNORMAL(1);

    Integer statue;

    UserState(Integer statue) {
        this.statue = statue;
    }
}
