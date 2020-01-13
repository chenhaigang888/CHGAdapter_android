package com.chg.chgadapterdemo.Found.Model;

import java.util.List;

public class FoundContent {
    private String content;
    private List<Source> source;
    private int browses;

    public int getBrowses() {
        return browses;
    }

    public void setBrowses(int browses) {
        this.browses = browses;
    }

    public List<Source> getSource() {
        return source;
    }

    public void setSource(List<Source> source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
