package com.cppba.base.dao.impl;

import com.cppba.base.dao.BaseRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
        implements BaseRepository<T,ID> {

    private final EntityManager em;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    /*public int executeUpdate(String hql){
        Query query = em.createQuery(hql);
        return query.executeUpdate();
    }

    public List<T> findByHql(final String hql, final Map params) {
        List<Object> list = null;
        Query query = em.createQuery(hql);
        if (params != null && params.size() > 0) {
            for (Object key : params.keySet()) {
                query.setParameter(key.toString(), params.get(key));
            }
        }
        return (List<T>) query.getResultList();
    }

    public Page<T> pageByHql(final String hql, final Map params, final Integer page, final Integer size) {
        Query query = em.createQuery(hql);
        PageRequest pageRequest = new PageRequest(page, size);
        if (params != null && params.size() > 0) {
            for (Object key : params.keySet()) {
                query.setParameter(key.toString(), params.get(key));
            }
        }
        if(page>0 && size>0){
            query.setFirstResult((page - 1) * size);
            query.setMaxResults(size);
        }else{
            pageRequest = new PageRequest(1,Integer.MAX_VALUE);
        }
        List<T> list = query.getResultList();
        return new PageImpl<T>(list,pageRequest,count(hql,params));
    }

    public Long count(final String hql, final Map params) {
        final String countHQL = prepareCountHql(hql);
        Query query = em.createQuery(countHQL);
        if (params != null && params.size() > 0) {
            for (Object key : params.keySet()) {
                query.setParameter(key.toString(), params.get(key));
            }
        }
        Long count = (Long)query.getSingleResult();
        return count;
    }

    *//**
     * 获取HQL的count(*)
     *//*
    protected String prepareCountHql(final String HQL) {
        String fromHql = HQL;
        fromHql = "from" + StringUtils.substringAfter(fromHql, "from");
        fromHql = StringUtils.substringBefore(fromHql, "order by");
        int whereIndex = fromHql.indexOf("where");
        int leftIndex = fromHql.indexOf("left join");
        if (leftIndex >= 0) {
            if (whereIndex >= 0) {
                String temp = StringUtils.substringBefore(fromHql, "left");
                fromHql = temp + " where "
                        + StringUtils.substringAfter(fromHql, "where");
            } else {
                fromHql = StringUtils.substringBefore(fromHql, "left");
            }
        }
        String countHql = "select count(*) " + fromHql;
        return countHql;
    }*/
}