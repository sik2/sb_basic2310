package com.std.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller 의 의미
// 개발자가 스프링부트에게 말한다.
// 아래 있는 HomeController 는 컨트롤러이다.
@Controller
public class HomeController {
    private int number;

    HomeController () {
        number = -1;
    }

    // @GetMapping("/home/main") 의 의미
    // 개발자가 스프링부트에게 말한다.
    // 만약에 /home/main 이런 요청이 오면 아래 메서드를 실행해줘
    @GetMapping("/home/main")
    @ResponseBody
    public String ShowMain() {
        return "안녕하세요";
    }


    //    http://localhost:8080/home/main2
    //    응답 : 반갑습니다.
    @GetMapping("/home/main2")
    @ResponseBody
    public String showMain2() {
        return "반갑습니다.";
    }

    //    http://localhost:8080/home/main3
    //    즐거웠습니다.
    @GetMapping("/home/main3")
    @ResponseBody
    public String showMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease() {
        number++;
        return number;
    }

    // @RequestParam 의 의미
    // 개발자가 스프링부트에게 말한다.
    // int a 는 쿼리스트링에서 a 파라미터의 값을 얻은 후 정수화 한 값이어야 한다.
    // @RequestParam 는 생략가능
    @GetMapping("/home/plus")
    @ResponseBody
    public int showPlus(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/home/minus")
    @ResponseBody
    public int showMinus(int a,  int b) {
        return a - b;
    }

    @GetMapping("/home/multiply")
    @ResponseBody
    public int showMultiply(int a,  int b) {
        return a * b;
    }

    @GetMapping("/home/divide")
    @ResponseBody
    public int shoDivide(int a,  int b) {
        return a / b;
    }
}
