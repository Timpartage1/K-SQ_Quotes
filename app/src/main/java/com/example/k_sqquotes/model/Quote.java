package com.example.k_sqquotes.model;

import com.google.gson.annotations.SerializedName;

public class Quote {
    private String quoteTitle;
    private String quoteDescription;
    private String quoteContent;
    private String quoteUrl;

    public Quote(String quoteTitle, String quoteDescription, String quoteContent, String quoteUrl) {
        this.quoteTitle = quoteTitle;
        this.quoteDescription = quoteDescription;
        this.quoteContent = quoteContent;
        this.quoteUrl = quoteUrl;
    }

    public String getQuoteTitle() {
        return quoteTitle;
    }

    public void setQuoteTitle(String quoteTitle) {
        this.quoteTitle = quoteTitle;
    }

    public String getQuoteDescription() {
        return quoteDescription;
    }

    public void setQuoteDescription(String quoteDescription) {
        this.quoteDescription = quoteDescription;
    }

    public String getQuoteContent() {
        return quoteContent;
    }

    public void setQuoteContent(String quoteContent) {
        this.quoteContent = quoteContent;
    }

    public String getQuoteUrl() {
        return quoteUrl;
    }

    public void setQuoteUrl(String quoteUrl) {
        this.quoteUrl = quoteUrl;
    }
}
