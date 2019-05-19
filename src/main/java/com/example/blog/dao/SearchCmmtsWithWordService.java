package com.example.blog.dao;

import com.example.blog.dao.repository.CommentSearchRepository;
import com.example.blog.domain.elasticDao.SrchbleCommt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by debnathchatterjee on 19/05/19.
 */

/*
public class SearchCmmtsWithWordService {

    @Autowired
    CommentSearchRepository commentSearchRepository;

    public SrchbleCommt save(SrchbleCommt srchbleCommt){
        return commentSearchRepository.save(srchbleCommt);
    }

    public void delete(SrchbleCommt SrchbleCommt) {
        commentSearchRepository.delete(SrchbleCommt);
    }

    public List<SrchbleCommt> findOneWord(String word) {
        return commentSearchRepository.findByWords(word);
    }
}
*/
