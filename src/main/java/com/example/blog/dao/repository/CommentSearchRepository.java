package com.example.blog.dao.repository;

import com.example.blog.domain.elasticDao.SrchbleCommt;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
public interface CommentSearchRepository extends ElasticsearchRepository<SrchbleCommt, String> {

    List<SrchbleCommt> findByWords(String word);
}
