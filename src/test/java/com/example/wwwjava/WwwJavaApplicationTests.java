package com.example.wwwjava;

import com.example.wwwjava.dao.CategoryDao;
import com.example.wwwjava.dao.CategoryDaoImpl;
import com.example.wwwjava.models.Category;
import com.example.wwwjava.models.Product;
import com.example.wwwjava.models.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)

@SpringBootTest


class WwwJavaApplicationTests {

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryDaoImpl categoryDaoImpl;


    @Test//albo tu zrobic categoryDaoImpl.NotNull, albo plik text-context(on swoja droga nie smiga i wgl
        //klasy testu nie znajduje, albo jeszcze jakieś szmery bajery ale no dalibuj  )
    void contextLoads() {


    }

    @Test
    void getCategoryById()
    {
        long id=1;
        categoryDaoImpl.getCategoryById(id);
        System.out.println(categoryDaoImpl.getCategoryById(id));

    }
    @Test//ja wiem że to jest SWIETNY test ale prosze nie oceniać. Dziekuję
    void getCategoryByIdException()
    {
        CategoryDaoImpl categoryDao=new CategoryDaoImpl();
        long id=10000;
        categoryDao.getCategoryById(id);
        System.out.println(categoryDao.getCategoryById(id));

    }

}
