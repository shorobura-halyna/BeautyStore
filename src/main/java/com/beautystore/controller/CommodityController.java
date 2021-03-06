package com.beautystore.controller;

import com.beautystore.dto.request.CommodityRequest;
import com.beautystore.dto.request.filter.FilterCommodityRequest;
import com.beautystore.dto.response.CommodityResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/commodity")
@CrossOrigin
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping
    public HttpStatus save(CommodityRequest commodityRequest, @RequestParam MultipartFile file) {
        commodityService.save(commodityRequest, file);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestBody @Valid CommodityRequest commodityRequest) {
        commodityService.update(commodityRequest);
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

    @GetMapping("/price/max")
    public int find() {
        return commodityService.getMaxPrice();
    }


    @GetMapping("/one")
    public CommodityResponse find(@RequestParam int id) {
        return commodityService.findOne(id);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        commodityService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping("/filter")
    public DataResponse<CommodityResponse> filter(@RequestParam Integer page,
                                                  @RequestParam Integer size,
                                                  @RequestParam String sortBy,
                                                  @RequestParam Sort.Direction direction,
                                                  @RequestBody FilterCommodityRequest filterCommodityRequest) {
        return commodityService.filter(page, size, sortBy, direction, filterCommodityRequest);
    }
}
