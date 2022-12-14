package net.gt.test;

import net.gt.core.api.QueryFileDatabase;
import net.gt.test.query.UserQueryFileDatabase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类描述
 *
 * @author gt-it
 * @since 2022/12/13
 */
public class FileTest {

//    private final QueryFileDatabase<User> queryFileDatabase = new QueryFileDatabase<>();

    @Resource
    private UserQueryFileDatabase queryFileDatabase;

    @Test
    public void test1() {

        User user = queryFileDatabase.getOne(User.class);
        System.out.println(user);
    }

    @Test
    public void test2() {
        List<User> list = queryFileDatabase.list(User.class);
        System.out.println(list);
    }

}
