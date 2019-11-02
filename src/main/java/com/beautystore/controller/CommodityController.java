package com.beautystore.controller;

import com.beautystore.dto.request.CommodityRequest;
import com.beautystore.dto.request.filter.FilterCommodityRequest;
import com.beautystore.dto.request.filter.FilterUserRequest;
import com.beautystore.dto.response.CommodityResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.model.Commodity;
import com.beautystore.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping
    public HttpStatus save(@RequestBody @Valid CommodityRequest commodityRequest) {
        commodityService.save(commodityRequest);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam String commodityName) {
       commodityService.save(new Commodity(id, commodityName));
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<CommodityResponse> find(@RequestParam Integer page,
                                                @RequestParam Integer size,
                                                @RequestParam String sortBy,
                                                @RequestParam Sort.Direction direction,
                                                @RequestParam(required = false) String name) {
        return commodityService.findAll(page, size, sortBy, direction, name);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        commodityService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping("/filter")
    public List<CommodityResponse> filter(@RequestBody FilterCommodityRequest filterCommodityRequest){
        return commodityService.filter(filterCommodityRequest);
    }
}
