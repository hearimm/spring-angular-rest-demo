package com.secure.demo.search.entity;

public class MetaVo {
  int totalCount;
  int pageableCount;
  boolean isEnd;

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getPageableCount() {
    return pageableCount;
  }

  public void setPageableCount(int pageableCount) {
    this.pageableCount = pageableCount;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public void setEnd(boolean end) {
    isEnd = end;
  }
}
