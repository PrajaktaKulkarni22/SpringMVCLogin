package com.spmvc.springmvcdemo.controller;

import com.spmvc.springmvcdemo.model.Login;
import com.spmvc.springmvcdemo.model.User;
import com.spmvc.springmvcdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showRegister(Model model){
        model.addAttribute("login",new Login());
        return "login";
    }

  /*  @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(User user){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");


        return modelAndView;
    }*/

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model){
      //  model.addAttribute("user",new User());

        System.out.println(login);
       User u= userRepository.findByEmailIdAndPassword(login.getEmailId(),login.getPassword());
       if (u == null){
           return "error";
       }

           List<User> userList= userRepository.findAll();
           model.addAttribute("user",userList);
           return "userList";

    }

    @GetMapping("/registration")
    public String showRegisterForm(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/processregister")
    public String createNewUser(User user){
        userRepository.save(user);
        return "registersuccess";
    }

    @GetMapping("/user")
    public String viewUsers(Model model){
        List<User> userList= userRepository.findAll();
        model.addAttribute("user",userList);
        return "userList";
    }
}
