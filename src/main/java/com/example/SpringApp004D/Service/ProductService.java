package com.example.SpringApp004D.Service;

import com.example.SpringApp004D.Model.Product;
import com.example.SpringApp004D.Repository.ProductRepository;
import com.example.SpringApp004D.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //Listar
    public String getAllProducts(){
        String output="";

        for(Product product:productRepository.findAll()){
            output+="ID Producto: "+product.getID()+"\n";
            output+="Nombre: "+product.getName()+"\n";
            output+="Descripcion: "+product.getDescription()+"\n";
            output+="Precio: $"+product.getPrice()+"\n";
            output+="Stock: "+product.getStock()+"\n";
        }
        if(output.isEmpty()){
            return "No hay productos registrados";
        }else{
            return output;
        }
    }

    //Buscar
    public String getProductById(int id){
        String output="";
        if(productRepository.existsById(id)){
            Product buscado=productRepository.findById(id).get();
            output+="ID Producto: "+buscado.getID()+"\n";
            output+="Nombre: "+buscado.getName()+"\n";
            output+="Descripcion: "+buscado.getDescription()+"\n";
            output+="Precio: $"+buscado.getPrice()+"\n";
            output+="Stock: "+buscado.getStock()+"\n";
            return output;
        }else{
            return "Producto no encontrado";
        }
    }

    //Agregar
    public String addProduct(Product product) {

        if(!productRepository.existsById(product.getID())){
            productRepository.save(product);
            return "Producto agregado correctamente";
        }else{
            return "Producto ya existe";
        }
    }

    //Eliminar
    public String deleteProduct(int id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Producto eliminado correctamente";
        }else{
            return "Producto no encontrado";
        }
    }

    //Actualizar
    public String updateProduct(int id,Product product) {
        if(productRepository.existsById(id)){
            Product buscado=productRepository.findById(id).get();
            buscado.setName(product.getName());
            buscado.setDescription(product.getDescription());
            buscado.setPrice(product.getPrice());
            buscado.setStock(product.getStock());
            productRepository.save(buscado);
            return "Producto actualizado correctamente";
        }else{
            return "Producto no encontrado";
        }
    }
}
