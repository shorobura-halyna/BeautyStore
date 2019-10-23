package com.beautystore.dto.response;

import com.beautystore.model.Commodity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class BrandResponse {
    private String name;
    private List<CommodityResponse> commodities;
}
