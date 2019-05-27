package com.example.demo.dao.impl;

import com.example.demo.entity.QUser;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl {
    @Autowired
    private EntityManager em;
    private QUser qUser=QUser.user;

    public List<Map<String,Object>> countDemo(){
        JPAQuery<com.querydsl.core.Tuple> q = new JPAQuery<>(em);
        List<Map<String,Object>> result=new ArrayList<>();
        /**
         * 对于q增加条件
         * q.select(qUser.id).from(qUser); 模型是这样和sql语句类似
         */
        q.select(qUser.id,qUser.name).from(qUser);
        /**
         * 里面list类型根据上面 select 来写
         *
         */
        List<Tuple> resultT = q.fetch();
        for (com.querydsl.core.Tuple t : resultT) {
            Map<String, Object> map = new HashMap<>();
            map.put("sumNum", t.get(qUser.name));
            result.add(map);
        }
        return  result;
    }
}
