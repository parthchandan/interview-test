package com.test.interview.data.model;

import java.util.List;

public class AboutCananda {
    private   String title;
    private List<CanadaDetails> rows;

//    public AboutCananda(String title, List<CanadaDetails> rows) {
//        this.title = title;
//        this.rows = rows;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CanadaDetails> getRows() {
        return rows;
    }

    public void setRows(List<CanadaDetails> rows) {
        this.rows = rows;
    }
}
