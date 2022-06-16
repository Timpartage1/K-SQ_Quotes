package com.example.k_sqquotes;

public class QuoteModel {
    private String title;
    private String category;
    private String content;
    private String cdate;
    private int img;
    private String url;

    public QuoteModel(String title, String category, String content, String cdate,String url) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.cdate = cdate;
        this.url=url;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }


}
