package cn.alipanpan.springbootcms01.controller;


import cn.alipanpan.springbootcms01.service.ProducerService;
import cn.alipanpan.springbootcms01.service.ReceiverService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lip
 * @time 2020/3/13
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private ProducerService producerService;
    @Autowired
    private ReceiverService receiverService;

    @RequestMapping(value = "/set/{key}/{value}",method = RequestMethod.GET)
    public String sendMessage(@PathVariable("key") String key, @PathVariable("value") String value) {
        return producerService.sendMessage(key, value);
    }

    @RequestMapping(value = "/get/{key}",method = RequestMethod.GET )
    public Object getMessage(@PathVariable("key") String key) {
        return receiverService.getMessage(key);
    }
}
