package com.IMDb.controller;

import com.IMDb.data.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@RestController
//@RequestMapping("dynamic")
public class AppController {
    
    @GetMapping("/")
    @ResponseBody
    public String root() {
        return "Hello from root";
    }

    @GetMapping("/page")
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView("page1");
        mv.addObject("message", "Hello World");
        return mv;
    }
        
    @GetMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello? %s!", name);
    }
    
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
      model.addAttribute("greeting", new Greeting());
      return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
      model.addAttribute("greeting", greeting);
      return "result";
    }
}
