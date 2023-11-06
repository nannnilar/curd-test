package com.example.storecurd.service;

import com.example.storecurd.dao.ProductDao;
import com.example.storecurd.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public Product save(Product product) {
       return productDao.save(product);
    }
    public Product findById(int id){
        return productDao.findById(id).orElse(null);
    }

    public Product update(Product newProduct) {
        return productDao.save(newProduct);
    }

    public List<Product> findAll(Product product) {
        return productDao.findAll();
    }

    public void delete(Product product) {
        productDao.delete(product);
    }
}
