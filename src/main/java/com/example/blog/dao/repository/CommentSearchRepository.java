package com.example.blog.dao.repository;

import com.example.blog.domain.elasticDao.SrchbleCommt;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
/*@Repository*//*
public interface CommentSearchRepository extends ElasticsearchRepository<SrchbleCommt, String> {

    List<SrchbleCommt> findByWords(String word);
}*/
