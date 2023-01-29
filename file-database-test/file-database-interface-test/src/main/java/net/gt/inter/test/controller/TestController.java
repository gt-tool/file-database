package net.gt.inter.test.controller;

import net.gt.inter.test.service.CalculateService;
import net.gt.inter.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private CalculateService calculateService;

    @RequestMapping("/test")
    public String getHello() {
        String testList = testService.getList("code123", "name456");
        String calculateResult = calculateService.getResult("测试");
        return (testList + "," + calculateResult);
    }
}