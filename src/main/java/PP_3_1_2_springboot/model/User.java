package PP_3_1_2_springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private static int count = 0;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;


    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.id = ++count;
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
    public String toString() {
        return "Id:" + id + ",  Name:" + name + ",  age:" + age;
    }
}

