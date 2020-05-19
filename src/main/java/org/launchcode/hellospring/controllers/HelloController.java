package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
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
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // /hello/form
//    @GetMapping("form")
//    public String helloForm(){
//        return "<html" +
//                "<body>" +
//                //OMG 'hello' in the next line needed to '/hello'
//                "<form action='/hello' method='get'>" + //submit a request to /hello
//                "<input type='text' name='name'>" +
//                "<input type ='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }
//
    // /hello/form
    @GetMapping("form")
    public String helloAroundTheWorldForm(){
        return "<html" +
                "<body>" +
                "<form action='/hello' method='get'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                //implement dropdown AKA select
//                "<select name=\"hellos\" id=\"hellos-select\">\n" +
//                "    <option value=\"\">--Please choose an option--</option>\n" +
//                "    <option value=\"french\">French</option>\n" +
//                "    <option value=\"spanish\">Spanish</option>\n" +
//                "    <option value=\"german\">German</option>\n" +
//                "    <option value=\"italian\">Italian</option>\n" +
//                "    <option value=\"portuguese\">Portuguese</option>\n" +
//                "    <option value=\"hindi\">Hindi</option>\n" +
//                "    <option value=\"persian-farsi\">Persian (Farsi)</option>\n" +
//                "    <option value=\"russian\">Russian</option>\n" +
//                "    <option value=\"japanese\">Japanese</option>\n" +
//                "    <option value=\"korean\">Korean</option>\n" +
//                "    <option value=\"turkish\">Turkish</option>\n" +
//                "    <option value=\"mongolian\">Mongolian</option>\n" +
//                "    <option value=\"kazakh\">Kazakh</option>\n" +
//                "    <option value=\"hungarian\">Hungarian</option>\n" +
//                "    <option value=\"arabic\">Arabic</option>\n" +
//                "    <option value=\"hausa\">Hausa</option>\n" +
//                "    <option value=\"swahili\">Swahili</option>\n" +
//                "    <option value=\"mandarin\">Mandarin</option>\n" +
//                "    <option value=\"cantonese\">Cantonese</option>\n" +
//                "    <option value=\"bahasa-indonesia\">Bahasa Indonesia</option>\n" +
//                "    <option value=\"english\">English</option>\n" +
//                "</select>" +
                "<input type ='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
