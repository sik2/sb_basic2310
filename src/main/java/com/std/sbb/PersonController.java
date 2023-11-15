package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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

    @GetMapping("/home/removePerson")
    @ResponseBody
    public String removePerson(int id) {
        boolean removed = people.removeIf(person -> person.getId() == id);

        if (removed == false) {
            return id + "번 사람이 존재하지 않습니다.";
        }

        return id + "번 사람이 삭제 되었습니다.";
    }

    @GetMapping("/home/modifyPerson")
    @ResponseBody
    public String modifyPerson(int id, String name, int age) {
        Person foundPerson = people
                        .stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElse(null);

        if (foundPerson == null) {
            return  id + "번 사람이 존재하지 않습니다.";
        }

        foundPerson.setAge(age);
        foundPerson.setName(name);

        return  id + "번 사람이 수정 되었습니다.";
    }
}


@AllArgsConstructor
@Getter
class Person {
    private static int lastId;
    private final int id;
    @Setter
    private int age;
    @Setter
    private String name;

    static {
        lastId = 0;
    }

    Person (String name, int age) {
            this.id = ++lastId;
            this.name = name;
            this.age = age;
    }
}
