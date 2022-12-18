package net.gt.test.entity;

import net.gt.core.annotations.FileTableName;

/**
 * 类描述
 *
 * @author gt-it
 * @since 2022/12/14
 */

@FileTableName("user")
public class User {

    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
