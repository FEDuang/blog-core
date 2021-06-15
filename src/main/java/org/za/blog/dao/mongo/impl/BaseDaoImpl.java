package org.za.blog.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.za.blog.dao.mongo.IBaseDao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
    protected abstract Class<T> getEntityClass();

    protected MongoTemplate mgt;

    @Autowired
    public void setMgt(MongoTemplate mgt) {
        this.mgt = mgt;
    }

    @Override
    public void save(T entity) {
        mgt.save(entity);
    }

    @Override
    public void update(String key, Object value, String newKey, Object newValue) {
        mgt.updateMulti(new Query(where(key).is(value)), new Update().set(newKey, newValue), getEntityClass());
    }

    @Override
    public void updateOne(String key, Object value, String newKey, Object newValue) {
        mgt.updateFirst(new Query(where(key).is(value)), new Update().set(newKey, newValue), getEntityClass());
    }

    @Override
    public void delete(Serializable... ids) {
        if (ids != null) {
            for (Serializable id : ids) {
                mgt.remove(Objects.requireNonNull(mgt.findById(id, getEntityClass())));
            }
        }
    }

    @Override
    public void delete(String key, Object value) {
        mgt.remove(new Query(where(key).is(value)), getEntityClass());
    }

    @Override
    public T find(Serializable id) {
        return mgt.findById(id, getEntityClass());
    }

    @Override
    public List<T> findAll() {
        return mgt.findAll(getEntityClass());
    }

    @Override
    public T findOneByProp(String propName, Object propValue) {
        return mgt.findOne(new Query(where(propName).is(propValue)), getEntityClass());
    }

    @Override
    public T findOneByProps(String[] propName, Object[] propValue) {
        return mgt.findOne(createQuery(propName, propValue), getEntityClass());
    }

    @Override
    public T findOneByProps(Map<String, Object> prop) {
        return mgt.findOne(createQuery(prop), getEntityClass());
    }

    @Override
    public List<T> findByProp(String propName, Object propValue) {
        return mgt.find(new Query(where(propName).is(propValue)), getEntityClass());
    }

    @Override
    public List<T> findByProps(String[] propName, Object[] propValue) {
        return mgt.find(createQuery(propName, propValue), getEntityClass());
    }

    @Override
    public List<T> findByProps(Map<String, Object> prop) {
        return mgt.find(createQuery(prop), getEntityClass());
    }

    protected Query createQuery(String[] keys, Object[] values) {
        Query query = new Query();
        for (int i = 0; i < keys.length; ++i) {
            query.addCriteria(where(keys[i]).is(values[i]));
        }
        return query;
    }

    protected Query createQuery(Map<String, Object> map) {
        Query query = new Query();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            query.addCriteria(where(entry.getKey()).is(entry.getValue()));
        }
        return query;
    }

}
