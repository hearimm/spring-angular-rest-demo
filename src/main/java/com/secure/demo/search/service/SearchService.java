package com.secure.demo.search.service;


import com.secure.demo.search.entity.SearchResponseVo;
import org.springframework.http.ResponseEntity;

public interface SearchService {
  ResponseEntity<SearchResponseVo> search(String query, String sort, int page, int size,
      String target, String category);
}
