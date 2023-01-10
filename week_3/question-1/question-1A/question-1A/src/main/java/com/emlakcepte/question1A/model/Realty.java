package com.emlakcepte.question1A.model;

import com.emlakcepte.question1A.model.enums.RealtyCategory;
import com.emlakcepte.question1A.model.enums.RealtyType;
import com.emlakcepte.question1A.model.enums.Type;
import com.emlakcepte.question1A.model.enums.TypeOfStructure;

import java.time.LocalDateTime;

public class Realty {

    private Long no;
    private String title;
    private LocalDateTime publishedDate;
    private User user;
    private RealtyType status;
    private String province;
    private String county;
    private RealtyCategory category;
    private Type type;
    private TypeOfStructure typeOfStructure;
    private int price;

    public Realty() {
        super();
    }

    public Realty(Long no, String title, LocalDateTime publishedDate, User user, RealtyType status,
                  RealtyCategory category, Type type, TypeOfStructure typeOfStructure, int price,String province,String county) {
        super();
        this.no = no;
        this.title = title;
        this.publishedDate = publishedDate;
        this.user = user;
        this.status = status;
        this.category = category;
        this.type = type;
        this.typeOfStructure = typeOfStructure;
        this.price = price;
        this.province=province;
        this.county=county;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RealtyType getStatus() {
        return status;
    }

    public void setStatus(RealtyType status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public RealtyCategory getCategory() {
        return category;
    }

    public void setCategory(RealtyCategory category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type housingType) {
        this.type = type;
    }

    public TypeOfStructure getTypeOfStructure() {
        return typeOfStructure;
    }

    public void setTypeOfStructure(TypeOfStructure typeOfStructure) {
        this.typeOfStructure = typeOfStructure;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate + ", user=" + user
                + ", status=" + getStatus() + ", province=" + province + "]";
    }


}
