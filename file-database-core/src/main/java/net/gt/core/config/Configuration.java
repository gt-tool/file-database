package net.gt.core.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置类
 *
 * @author gt-it
 * @since 2022/12/18
 */
public class Configuration {

    private String fileDatabasePth;

    private Map<Class<?>, FileConfiguration> map = new HashMap<>();

    public String getFileDatabasePth() {
        return fileDatabasePth;
    }

    public void setFileDatabasePth(String fileDatabasePth) {
        this.fileDatabasePth = fileDatabasePth;
    }

    public Map<Class<?>, FileConfiguration> getMap() {
        return map;
    }

    public void setMap(Map<Class<?>, FileConfiguration> map) {
        this.map = map;
    }
}
