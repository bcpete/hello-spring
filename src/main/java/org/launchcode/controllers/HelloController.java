package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Brady on 3/5/17.
 */
@Controller
public class HelloController {

    @RequestMapping(value ="")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");
        if(name == null){
            name = "World";
        }
        return "Hello " + name;
    }
    @RequestMapping(value="hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html ="<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                "<option value='french'>French</option>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<option value='portuguese'>Portuguese</option>"+
                "</select>" +
                "<input type='submit' value ='Greet me' />" +
                "</form>";

        return html;
    }
    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
    String name = request.getParameter("name");
    String language = request.getParameter("language");
    String greeting = "";

    switch (language) {
        case "french" :
            greeting = "Bonjour ";
            break;
        case "english" :
            greeting = "Hello ";
            break;
        case "spanish" :
            greeting = "Hola ";
            break;
        case "german" :
            greeting = "Hallo ";
            break;
        case "portuguese" :
            greeting = "Ola ";
            break;
    }

    return greeting + name;
    }
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
    return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye(){
        return "redirect:/";

    }

}
