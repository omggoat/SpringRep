package cn.shil.entity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class Student {
    @NotNull(message = "{student.notnull}")
    private String id;

    @NotNull(message = "{student.notnull}")
    @Size(min = 5,max = 10,message = "{student.size}")
    private String name;

    @NotNull(message = "{student.notnull}")
    @Min(20)
    @Max(50)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
