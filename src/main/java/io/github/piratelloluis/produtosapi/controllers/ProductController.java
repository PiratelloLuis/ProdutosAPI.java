package io.github.piratelloluis.produtosapi.controllers;

import io.github.piratelloluis.produtosapi.models.Product;
import io.github.piratelloluis.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping()
    public Product SaveProduct(@RequestBody Product product){
        System.out.println("Produto recebido: " +product);

        //Gerar ID
        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product GetProductByID(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String DeleteProduct(@PathVariable("id") String id){
        productRepository.deleteById(id);
        return "Product deleted: " +id;
    }

    @PutMapping("/{id}")
    public Product UpdateProduct(@PathVariable("id") String id, @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @GetMapping
    public List<Product> SearchProductByParams(@RequestParam("name") String name){
        return productRepository.findByName(name);
    }

    @GetMapping("/products")
    public List<Product> ListProducts(){
        return productRepository.findAll();
    }


}
