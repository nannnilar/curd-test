package com.example.storecurd.controller;

import com.example.storecurd.entity.Product;
import com.example.storecurd.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return service.save(product);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product oldProduct,@PathVariable int id){
        Product newProduct = service.findById(id);
        if (oldProduct == null) {
            return ResponseEntity.notFound().build();
        }
        newProduct.setName(oldProduct.getName());
        newProduct.setDescription(oldProduct.getDescription());
        Product updatedProduct = service.update(newProduct);

        return ResponseEntity.ok(updatedProduct);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id){
        Product product = service.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
    @GetMapping("/all")
    public List<Product> findAll(Product product){
        return service.findAll(product);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable int id){
        Product product = service.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(product);
        return ResponseEntity.ok(product);
    }
}
