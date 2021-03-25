package com.jxm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxm.entity.User;
import com.jxm.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findByPage/{current}/{countOfPage}")
    @ResponseBody
    public IPage<User> findByPage(@PathVariable("current") Integer current, @PathVariable("countOfPage") Integer countOfPage){
        return userService.findByPage(current, countOfPage);
    }

    @PostMapping("/saveUser")
    @ResponseBody
    public String saveUser(@RequestBody User user){
        Integer result = userService.saveUser(user);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody User user){
        Integer result = userService.updateUser(user);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Integer id){
        Integer result = userService.deleteUser(id);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    /*-----------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------*/

    @GetMapping("/show")
    public String show(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findById(id);
        modelAndView.setViewName("update");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/user/show";
    }

    @PostMapping("/update")
    public String updateById(User user){
        userService.updateById(user);
        return "redirect:/user/show";
    }

    @GetMapping("/toSave")
    public String toSave(){
        return "save";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/user/show";
    }
}
