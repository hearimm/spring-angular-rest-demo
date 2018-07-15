package com.secure.demo.search.controller;

import com.secure.demo.search.entity.SearchResponseVo;
import com.secure.demo.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class SearchController {

  @Autowired SearchService searchService;

  @GetMapping("/book")
  public ResponseEntity<SearchResponseVo> getBooksList(
      @RequestParam(value = "query") String query,
      @RequestParam(value = "sort", required = false, defaultValue = "accuracy") String sort,
      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
      @RequestParam(value = "target", required = false, defaultValue = "all") String target,
      @RequestParam(value = "category", required = false) String category) {
    return searchService.search(query, sort, page, size, target, category);
  }
}
