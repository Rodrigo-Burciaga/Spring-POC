package com.rodrigo.poc.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HomeController {

    @RequestMapping("")
    public String home() {
        return "main-menu";
    }

    @RequestMapping("/showForm")
    public String showPAge() {
        return "hellowold-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormTwo")
    public String letShout(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName").toUpperCase();
        String result = "Yo! " + name;
        model.addAttribute("message", result);
        return "helloworld";
    }

    @RequestMapping("/processFormThree")
    public String processVThree(@RequestParam("studentName") String studentName, Model model) {
        String result = "YO! " + studentName.toUpperCase();
        model.addAttribute("message", result);
        return "helloworld";

    }
}
