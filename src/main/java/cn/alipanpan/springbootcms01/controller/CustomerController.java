package cn.alipanpan.springbootcms01.controller;

import cn.alipanpan.springbootcms01.bean.Customer;
import cn.alipanpan.springbootcms01.config.RedisConfig;
import cn.alipanpan.springbootcms01.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerService customerService;

    @PostMapping("/customer/_search")
    public String search(Map parMap) {
        parMap.put("customerList", customerService.getByMap(parMap));
        return "customerList";
    }

    @GetMapping("/customer/{id}")
    public String getCustomer(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer";
    }

    @GetMapping("/customer")
    public String getCustomer(Map parMap) {
        return search(parMap);
    }

    @GetMapping("/addCustomer")
    public String addCustomer() {
        return "customer";
    }

    @PostMapping("/customer")
    public String saveCustomer(Customer customer, Map parMap) {
        customerService.save(customer);
       // customerService.create(customer);
        logger.info("---我的日志" + customer.toString());
        return "redirect:/customer/";
    }

    @PutMapping("/customer")
    public String updateCustomer(Customer customer, Map parMap) {
        customerService.update(customer);
        //return "redirect:/customer/_search";
        return "redirect:/customer/";
    }

    @DeleteMapping("/customer/{id}")
    public String delete(@PathVariable(name = "id") Integer id, Map parMap) {
        customerService.deleteJpa(id);
       // customerService.delete(id);
        return "redirect:/customer/";
    }
}
