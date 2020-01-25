package com.company.demo.controller;

import com.company.demo.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {
    private static Map<Integer,Product> productMap = new HashMap<>();
    static {
        Product p1 = new Product(1,"Honey");
        Product p2 = new Product(2,"Butter");
        productMap.put(1,p1);
        productMap.put(2,p2);
    }
    @GetMapping("/getProducts")
    public Map<Integer, Product> getProducts(){
        return productMap;
    }

    @PostMapping ("createProduct")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        Integer id = productMap.keySet().stream().max(Comparator.comparing(Integer::intValue)).get();
        productMap.put(++id,product);
        return new ResponseEntity<>("Product is Added", HttpStatus.OK);
    }

    @PutMapping  ("updateProuct/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id,@RequestBody Product product){
        if (!productMap.containsKey(id)){
            throw new ProductNotFoundException();
        }
        productMap.remove(id);
        productMap.put(id,product);
        return new ResponseEntity<>("Product is updated", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getALlProducts(){
        return new ResponseEntity<>(productMap.values(),HttpStatus.OK);
    }
    @DeleteMapping("/deleteProducts/{id}")
    public ResponseEntity<Object> deleteProducts(@PathVariable("id") Integer id){
        productMap.remove(id);
        return new ResponseEntity<>("Deleted ",HttpStatus.OK);
    }
}
