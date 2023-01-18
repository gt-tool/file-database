package net.gt.inter.test.service;

/**
 * 计算服务
 *
 * @author jason
 * @date 2023/01/18
 */
public interface CalculateService {
    /**
     * 得到结果
     *
     * @param name 名字
     * @return {@link String}
     */
    String getResult(String name);
}