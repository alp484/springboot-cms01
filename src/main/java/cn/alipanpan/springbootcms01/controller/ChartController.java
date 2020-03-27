package cn.alipanpan.springbootcms01.controller;

import cn.alipanpan.springbootcms01.bean.Customer;
import cn.alipanpan.springbootcms01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ChartController {

    @GetMapping("/charts")
    public String charts(Map parMap) {
        return "charts";
    }
}
