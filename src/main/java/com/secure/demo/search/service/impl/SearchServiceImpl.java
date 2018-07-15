package com.secure.demo.search.service.impl;

import com.secure.demo.account.AccountService;
import com.secure.demo.search.entity.SearchResponseVo;
import com.secure.demo.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import sun.management.snmp.util.MibLogger;

@Service
public class SearchServiceImpl implements SearchService {
  private static final String API_KEY = "KakaoAK 53a2819975ee9de75382a51193170b03";
  private static final String URL = "https://dapi.kakao.com/v2/search/book";
  public static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

  public ResponseEntity<SearchResponseVo> search(
      String query, String sort, int page, int size, String target, String category) {
    HttpEntity<?> entity = getHttpEntity();
    String url = getUriString(query, sort, page, size, target, category);
    return getResponse(entity, url);
  }

  private HttpEntity<?> getHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.set("Authorization", API_KEY);
    return new HttpEntity<>(headers);
  }

  private String getUriString(
      String query, String sort, int page, int size, String target, String category) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL)
            .queryParam("query", query)
            .queryParam("sort", sort)
            .queryParam("page", page)
            .queryParam("size", size)
            .queryParam("target", target);

    if (category != null) {
      builder.queryParam("category", category);
    }
    return builder.build(false).toUriString();
  }

  private ResponseEntity<SearchResponseVo> getResponse(HttpEntity<?> entity, String url) {
    RestTemplate restTemplate = new RestTemplate();
    logger.debug(url);
    return restTemplate.exchange(url, HttpMethod.GET, entity, SearchResponseVo.class);
  }
}
