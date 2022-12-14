package net.gt.test.query;

import net.gt.test.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类描述
 *
 * @author gt-it
 * @since 2022/12/14
 */
@RestController
public class QueryTestController {

    @Resource
    private UserQueryFileDatabase queryFileDatabase;

    @RequestMapping("test1")
    public void test1() {

        User user = queryFileDatabase.getOne(User.class);
        System.out.println(user);


    }

}
