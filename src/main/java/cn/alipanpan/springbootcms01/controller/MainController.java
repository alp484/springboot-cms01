package cn.alipanpan.springbootcms01.controller;

import cn.alipanpan.springbootcms01.bean.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class MainController {


    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/customer";
    }

    @GetMapping("/index")
    public String hello(Model model) {
        Customer customer = new Customer();
        customer.setName("传入参数");
        model.addAttribute("customer", customer);
        return "dashboard";
    }

    @GetMapping("/springCloud-ui")
    public String springCloudUI(Map parMap) {
        return "springCloud-ui";
    }

    @RequestMapping("/login")
    public String login(Map parMap) {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Map parMap) {
        return "login";
    }
}
