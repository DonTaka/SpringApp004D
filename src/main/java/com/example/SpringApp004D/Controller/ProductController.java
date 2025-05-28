package com.example.SpringApp004D.Controller;

import com.example.SpringApp004D.Model.Product;
import com.example.SpringApp004D.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name="Productos",description = "Servicios de gestion de productos Fullstack I")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Obtener productos",description = "Servicio GET para obtener la lista completa de productos existentes")
    public String getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    @Operation(summary = "Agregar Producto",description = "Servicio POST para agregar un nuevo producto en el sistema")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }
}
