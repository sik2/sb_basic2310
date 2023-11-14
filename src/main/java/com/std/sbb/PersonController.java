package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PersonController {
    List<Person> people;

    PersonController () {
        people = new ArrayList<>();
    }


    @GetMapping("/home/addPerson")
    @ResponseBody
    public String addPerson (String name, int age) {
        Person p = new Person(name, age);

        people.add(p);

        return p.getId() + "번 사람이 추가되었습니다.";
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> people () {
        return people;
    }
}


@AllArgsConstructor
@Getter
class Person {
    private static int lastId;
    private final int id;
    private final int age;
    private final String name;

    static {
        lastId = 0;
    }

    Person (String name, int age) {
            this.id = ++lastId;
            this.name = name;
            this.age = age;
    }
}
