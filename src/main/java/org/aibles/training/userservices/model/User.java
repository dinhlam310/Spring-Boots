package org.aibles.training.userservices.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "The user's name must not be null.")
    @Size(min = 1,max = 30, message = "Name must have at least 1 character")
    @Column(name = "name")
    private String name;

    @Min(value = 1, message = "Age should not be less than 0")
    @Column(name = "age")
    private int age;

    public User (int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
    return getId() == user.getId();
    }
    @Override
    public int hashCode(){
        return 31;
    }

}
