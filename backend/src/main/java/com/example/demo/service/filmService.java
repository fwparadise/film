package com.example.demo.service;

import com.example.demo.entity.film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class filmService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public filmService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Page<film> getPage(int current,int size){
        Pageable pageable=PageRequest.of(current,size);
        Query query=new Query().with(pageable);
        query.fields().include("_id");
        query.fields().include("title");
        query.fields().include("aka");
        query.fields().include("pubdate");
        query.fields().include("rating");
        query.fields().include("genres");
        query.fields().include("poster");
        List<film>list=mongoTemplate.find(query,film.class,"film");
        return PageableExecutionUtils.getPage(
                list,
                pageable,
                () -> mongoTemplate.count(query, film.class,"film"));
    }

    public List<film> findAll(){
        Query query=new Query();
        query.fields().include("countries");
        query.fields().include("genres");
        return mongoTemplate.find(query,film.class,"film");
    }

    public Object findById(String id){
        Query query=new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,film.class,"film");
    }

    public List<film> match(String name){
        Pattern pattern=Pattern.compile("^.*"+name+".*$", Pattern.CASE_INSENSITIVE);
        Criteria criteria=new Criteria();
        criteria.orOperator(Criteria.where("title").regex(pattern),Criteria.where("aka").regex(pattern));
        Query query=new Query(criteria);
        query.fields().include("_id");
        query.fields().include("title");
        return mongoTemplate.find(query,film.class,"film");
    }
}
