package net.gt.core.api;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONException;
import net.gt.core.exception.FileDatabaseException;
import net.gt.core.util.FileUtils;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询类
 *
 * @author gt-it
 * @since 2022/12/13
 */

public class QueryFileDatabase<T> {

//    public QueryFileDatabase queryFileDatabase(){
//        return new QueryFileDatabase();
//    }


    public T getOne(Class<T> clazz) {
        String fileInfo = FileUtils.getFileInfo("test");
        List<T> objects;
        try {
            objects = JSON.parseArray(fileInfo, clazz);
        } catch (JSONException e) {
            throw new FileDatabaseException(e.getMessage());
        }
        if (CollectionUtils.isNotEmpty(objects)) {
            return objects.get(0);
        }
        return null;
    }

    public List<T> list(Class<T> clazz) {

        String fileInfo = FileUtils.getFileInfo("test");

        List<T> list = new ArrayList<>();
        try {
            list = JSON.parseArray(fileInfo, clazz);
        } catch (JSONException e) {
            throw new FileDatabaseException(e.getMessage());
        }
        return list;
    }

}
