package com.beautystore.dto.response;

import com.beautystore.model.Basket;
import com.beautystore.model.Brand;
import com.beautystore.model.Commodity;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;


public class BasketResponseTest {

    @Test
    public void convert_basket_to_basket_response_test(){
        //given
        Basket basket = new Basket();
        basket.setAmount(100);
        basket.setId(1);
        Brand brand = new Brand();
        brand.setName("brand1");
        Commodity commodity = new Commodity("com1", 20);
        commodity.setBrand(brand);
        basket.setCommodities(Arrays.asList(commodity));


        //when
        BasketResponse basketResponse = new BasketResponse(basket);

        //then
        assertEquals(basket.getId(), basketResponse.getId());
        assertEquals(basket.getAmount(), basketResponse.getAmount());
        assertEquals(1, basketResponse.getCommodities().size());
        assertEquals(commodity.getName(), basketResponse.getCommodities().get(0).getName());
        assertEquals(commodity.getPrice(), basketResponse.getCommodities().get(0).getPrice());


    }


}
