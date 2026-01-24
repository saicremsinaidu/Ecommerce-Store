package com.cremsi.SpringEcom.controller;

import com.cremsi.SpringEcom.model.Product;
import com.cremsi.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts()
    {
//        System.out.println(productService.getProducts());
        return new ResponseEntity<>( productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id)
    {
        Product product=productService.getProduct(id);
        if(product!=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?>addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile)  {
//        System.out.println("check here"+product);
        try {

            Product savedProduct=productService.addProduct(product,imageFile);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        }
        catch (IOException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]>getImageByProductId(@PathVariable int id)
    {
        Product p=productService.getProduct(id);
        if(p!=null) {
            return new ResponseEntity<>(p.getImageData(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String>updateProduct(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile imageFile)
    {
       Product updatedProduct=null;
       try {
           updatedProduct=productService.updateProduct(product,imageFile);
           return new ResponseEntity<>("Updated",HttpStatus.OK);
       }
       catch (IOException e)
       {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable int id)
    {

        try{
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>>searchProducts(@RequestParam String keyword)
    {
//        System.out.println("Searching with "+keyword);
        return new ResponseEntity<>(productService.searchProducts(keyword),HttpStatus.OK);
    }
}
