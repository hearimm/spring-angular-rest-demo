package com.secure.demo.search.entity;

import java.util.List;


public class SearchResponseVo {
  MetaVo meta;
  List<DocumentsVo> documents;

  public MetaVo getMeta() {
    return meta;
  }

  public void setMeta(MetaVo meta) {
    this.meta = meta;
  }

  public List<DocumentsVo> getDocuments() {
    return documents;
  }

  public void setDocuments(List<DocumentsVo> documents) {
    this.documents = documents;
  }
}
