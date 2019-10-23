package com.beautystore.dto.response;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class DataResponse<T> {
    private List<T> data = new ArrayList<>();
    private Integer page;
    private Integer size;
    private Long totalEl;

    public DataResponse(List<T> data, Page page) {
        this.data = data;
        this.size = page.getSize();
        this.page = page.getNumber();
        this.totalEl = page.getTotalElements();
    }
}
