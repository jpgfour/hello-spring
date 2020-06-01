package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@ResponseBody
//@RequestMapping("hello") <---might need to restore to get select list working again
public class HelloController {

//    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //lives /hello/hello
    //Handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name) {

        return "Hello, " + "this is not the form response, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    //TODO Handles requests of the the form /hello?name=LaunchCode&hellos=English
    @ResponseBody
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public static String createMessage(@RequestParam String name, @RequestParam String hellos){

        String greeting = "";


        switch(hellos) {
            case "english":
                greeting = "Hello";
                break;
            case "french":
                greeting = "Bonjour";
                break;
            case "spanish":
                greeting = "Hola";
                break;
            case "german":
                greeting = "Guten tag";
                break;
            case "italian":
                greeting = "Bonjourno";
        }

        return  /* "The value of hellos is " + hellos + "," +*/ greeting + ", this is the form response, " + name + "!";


    }


//     /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

//below this point:  (re)creating CLEAN code and doing work for Chris' 'Thymeleaf Part 2' videos
    //responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    //responds to
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting","Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names",names);
        return "hello-list";
    }

}
