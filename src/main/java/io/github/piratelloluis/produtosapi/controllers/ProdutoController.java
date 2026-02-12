package io.github.piratelloluis.produtosapi.controllers;

import io.github.piratelloluis.produtosapi.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProdutoController {


    @PostMapping()
    public Product SaveProduct(@RequestBody Product produto){
        System.out.println("Produto recebido: " +produto);
        return produto;
    }

}
