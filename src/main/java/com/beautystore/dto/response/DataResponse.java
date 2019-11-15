package com.beautystore.dto.response;

import com.beautystore.controller.LoginController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class DataResponse<T> {
    private List<T> data;
    private Integer page;
    private Integer size;
    private Long totalEl;
    private int numberOfPages;
    private String currentUserRole;

    public DataResponse(List<T> data) {
        this.data = data;
    }

    public DataResponse(List<T> data, Page page) {
        this.data = data;
        this.size = page.getSize();
        this.page = page.getNumber();
        this.totalEl = page.getTotalElements();
        this.numberOfPages = page.getTotalPages();
        this.currentUserRole = Objects.isNull(LoginController.user) ? "" : LoginController.user.getRole();
    }
}
