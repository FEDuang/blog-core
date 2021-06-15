package org.za.blog.dao.mongo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {

    /**
     * 保存实体,执行完成本方法后，所引用实体的主键id会自动赋上值
     *
     * @param entity 要保存的实体
     * @return
     */
    T save(T entity);

    /**
     * 更新多个值，相当于 set newKey=newValue where key=value
     *
     * @param key      查询用的key
     * @param value    查询用的value
     * @param newKey   要更新的key
     * @param newValue 要更新的value
     */
    void update(String key, Object value, String newKey, Object newValue);

    /**
     * 仅更新一个值，相当于 set newKey=newValue where key=value，<br>
     * 适用于确定只有一个值会被更改的情况（比如key为主键时），加快运行速度
     *
     * @param key      查询用的key
     * @param value    查询用的value
     * @param newKey   要更新的key
     * @param newValue 要更新的value
     */
    void updateOne(String key, Object value, String newKey, Object newValue);

    /**
     * 根据id删除对应的项
     *
     * @param ids 被删除的项的id们
     */
    void delete(Serializable... ids);

    /**
     * 删除多个项，相当于 delete where key = value
     *
     * @param key   要被删除的key
     * @param value 要被删除的项的value
     */
    void delete(String key, Object value);

    /**
     * 通过主键查找，一定只有一个
     *
     * @param id 查找的值
     * @return 查找的结果
     */
    T find(Serializable id);

    /**
     * 返回整个集合中的内容，运行耗时耗资源，慎用！
     *
     * @return 返回整个集合
     */
    List<T> findAll();

    /**
     * 通过key和value查找一个值
     *
     * @param propName  key
     * @param propValue value
     * @return 查找的结果
     */
    T findOneByProp(String propName, Object propValue);

    /**
     * 通过多个key和多个value查找一个值
     *
     * @param propName  key数组
     * @param propValue value数组
     * @return 结果
     */
    T findOneByProps(String[] propName, Object[] propValue);

    /**
     * 通过多个key和多个value查找一个值
     *
     * @param prop key-value对
     * @return 结果
     */
    T findOneByProps(Map<String, Object> prop);

    /**
     * 通过key和value查找多个值
     *
     * @param propName  key
     * @param propValue value
     * @return 结果
     */
    List<T> findByProp(String propName, Object propValue);

    /**
     * 通过多个key和多个value查找多个值
     *
     * @param propName  key数组
     * @param propValue value数组
     * @return 结果
     */
    List<T> findByProps(String[] propName, Object[] propValue);

    /**
     * 通过多个key和多个value查找多个值
     *
     * @param prop key-value对
     * @return 结果
     */
    List<T> findByProps(Map<String, Object> prop);

}

