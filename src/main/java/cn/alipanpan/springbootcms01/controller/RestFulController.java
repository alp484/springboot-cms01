package cn.alipanpan.springbootcms01.controller;

import cn.alipanpan.springbootcms01.bean.Customer;
import cn.alipanpan.springbootcms01.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/restFulAPI")
@Api(value = "用户的增删改查")
public class RestFulController {

    @Autowired
    public CustomerService customerService;


    @PostMapping("/customer/_search")
    public ResponseEntity<Object> search(Map parMap) {
        return new ResponseEntity<>(customerService.getByMap(parMap), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Object>  getCustomer(@PathVariable(name = "id") Integer id, Model model) {
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<Object>  getCustomer(Map parMap) {
        return search(parMap);
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.update(customer), HttpStatus.OK);

    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id, Map parMap) {
        return new ResponseEntity<>(customerService.deleteJpa(id), HttpStatus.OK);
    }
}
