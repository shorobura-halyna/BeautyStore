package com.beautystore.service.impl;

import com.beautystore.dao.SubcategoryDao;
import com.beautystore.model.Subcategory;
import com.beautystore.service.SubcategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
@ComponentScan(basePackages = "com.beautystore.service.*")
public class SubcategoryServiceImplTest {

    @Autowired
    private SubcategoryDao subcategoryDao;

    @Autowired
    private SubcategoryService subcategoryService;


    @Test
    public void delete() {
//        given
        Subcategory subcategory = subcategoryDao.getOne(1);
        assertNotNull(subcategory);
        assertNotEquals(0, subcategory.getCommodities().size());
        int subcategoriesSizeBefore = subcategoryDao.findAll().size();
//        when
        subcategoryService.delete(1);

//        then
        int subcategoriesSizeAfter = subcategoryDao.findAll().size();
        assertEquals(subcategoriesSizeBefore - 1, subcategoriesSizeAfter);

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void should_throw_exception_deleted_second_time_same_id() {
        Subcategory subcategory = subcategoryDao.getOne(2);
        assertNotNull(subcategory);

        //        when
        subcategoryService.delete(2);

        subcategoryService.delete(2);

    }
}
