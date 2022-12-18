package net.gt.test.controller;

import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xupengan
 * @date 2022/10/10
 */

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("get")
    public void get(@RequestParam Map<Object, Object> paramMap) {
        logger.info("get接口接收到数据：{}", JSON.toJSONString(paramMap));
    }

    @PostMapping("postForm")
    public void postForm(@RequestParam Map<Object, Object> paramMap) {
        logger.info("postForm接口接收到数据：{}", JSON.toJSONString(paramMap));
    }

    @PostMapping("postBody")
    public void postBody(@RequestBody Object obj) {
        logger.info("postBody接口接收到数据：{}", JSON.toJSONString(obj));
    }

    @PostMapping("postBodyObj")
    public void postBodyObj(@RequestBody Map<Object, Object> objMap) {
        logger.info("postBodyObj接口接收到数据：{}", JSON.toJSONString(objMap));
    }

    @PostMapping("postBodyList")
    public void postBodyList(@RequestBody List<Object> list) {
        logger.info("postBodyList接口接收到数据：{}", JSON.toJSONString(list));
    }

}
