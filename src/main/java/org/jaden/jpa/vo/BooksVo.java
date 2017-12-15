package org.jaden.jpa.vo;

import java.util.Date;

public class BooksVo {
    private String id;
    private String name;
    private String author;
    private String price;
    private String description;
    private Date createTime;
    private Date updateTime;

    //分页相关参数
    private String limit;
    private String offset;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksVo booksVo = (BooksVo) o;

        if (id != null ? !id.equals(booksVo.id) : booksVo.id != null) return false;
        if (name != null ? !name.equals(booksVo.name) : booksVo.name != null) return false;
        if (author != null ? !author.equals(booksVo.author) : booksVo.author != null) return false;
        if (price != null ? !price.equals(booksVo.price) : booksVo.price != null) return false;
        if (description != null ? !description.equals(booksVo.description) : booksVo.description != null) return false;
        if (createTime != null ? !createTime.equals(booksVo.createTime) : booksVo.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(booksVo.updateTime) : booksVo.updateTime != null) return false;
        if (limit != null ? !limit.equals(booksVo.limit) : booksVo.limit != null) return false;
        return offset != null ? offset.equals(booksVo.offset) : booksVo.offset == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (limit != null ? limit.hashCode() : 0);
        result = 31 * result + (offset != null ? offset.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BooksVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", limit='" + limit + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
