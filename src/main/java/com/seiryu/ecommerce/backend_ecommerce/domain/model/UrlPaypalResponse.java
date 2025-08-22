package com.seiryu.ecommerce.backend_ecommerce.domain.model;

import lombok.Data;

@Data
public class UrlPaypalResponse {

    private String url;

    public UrlPaypalResponse() {
    }

    public UrlPaypalResponse(String url) {
        this.url = url;
    }

}
