package net.gt.spring.boot.test.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author gt-it
 * @version 0.0.1
 * @since 2023/01/17
 */

@Data
public class UserPO implements Serializable {

    private static final long serialVersionUID = 544164987710506892L;

    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

}
