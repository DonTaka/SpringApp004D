package com.example.SpringApp004D;

import com.example.SpringApp004D.Model.Product;
import com.example.SpringApp004D.Repository.ProductRepository;
import com.example.SpringApp004D.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ProductService productService;

    @Test
    void FindAllProductsTest() {
        List<Product> productos = productRepository.findAll();

        assertNotNull(productos);
        assertEquals(1, productos.size());

    }

    @Test
    void checkNameProduct() {
        Product producto = productRepository.findById(1).get();

        assertNotNull(producto);
        assertEquals("Telefono", producto.getName());
    }

    @Test
    void checkGetAllProductsService() {
        Mockito.when(productService.getAllProducts()).thenReturn("ListaCompleta");

        try {
            //Intento de accion
            mockMvc.perform(get("/product"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("ListaCompleta"));
        } catch (Exception ex) {
            //Si sale mal , ejecuta este codigo
            System.out.println("error: " + ex.getMessage());
            fail();
        }

    }
}
