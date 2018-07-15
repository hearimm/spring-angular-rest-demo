package com.secure.demo.search.entity;

import java.time.LocalDateTime;
import java.util.List;

public class DocumentsVo {
  String title;
  String contents;
  String isbn;
  LocalDateTime dateTime;
  List<String> authors;
  String publisher;
  List<String> translators;
  int price;
  int sale_price;
  String sale_yn;
  String category;
  String thumbnail;
  String barcode;
  String ebook_barcode;
  String status;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public List<String> getTranslators() {
    return translators;
  }

  public void setTranslators(List<String> translators) {
    this.translators = translators;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getSale_price() {
    return sale_price;
  }

  public void setSale_price(int sale_price) {
    this.sale_price = sale_price;
  }

  public String getSale_yn() {
    return sale_yn;
  }

  public void setSale_yn(String sale_yn) {
    this.sale_yn = sale_yn;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getEbook_barcode() {
    return ebook_barcode;
  }

  public void setEbook_barcode(String ebook_barcode) {
    this.ebook_barcode = ebook_barcode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
