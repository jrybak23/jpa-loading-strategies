package com.example.springdatademo.dto;

import java.util.List;

/**
 * @author Igor Rybak
 * @since 27-Mar-2019
 */
public class ADTO {
    private String name;
    private List<BDTO> bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BDTO> getBs() {
        return bs;
    }

    public void setBs(List<BDTO> bs) {
        this.bs = bs;
    }
}
