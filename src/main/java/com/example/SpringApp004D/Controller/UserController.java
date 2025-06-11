package com.example.SpringApp004D.Controller;


import com.example.SpringApp004D.Assemblers.UserModelAssembler;
import com.example.SpringApp004D.Model.Usuario;
import com.example.SpringApp004D.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name="Controlador Usuarios",description = "Servicios Rest para gestion de usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener Usuarios",description = "Obtiene la lista completa de usuarios registrados en sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Retorna lista completa de usuarios"),
            @ApiResponse(responseCode = "404",description = "No se encuentran datos")
    })
    public ResponseEntity<CollectionModel<EntityModel<Usuario>>> getAllUsers(){
        List<Usuario> lista = userService.getAllUsers();
        if(lista.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(assembler.toCollectionModel(lista),HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar Usuario por ID",description = "Obtiene un usuario segun el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Retorna Usuario"),
            @ApiResponse(responseCode = "404",description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del usuario", example = "123")
    public ResponseEntity<EntityModel<Usuario>> getUserById(@PathVariable int id){
        Usuario us = userService.getUserById(id);
        if(us!=null){
            return new ResponseEntity<>(assembler.toModel(us),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Agregar Usuario",description = "Permite registrar un usuario en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Usuario creado",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "204",description = "No hay contenido en la solicitud")
    })
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario user){
        userService.addUser(user);
        if(userService.getUserById(user.getId())!=null){
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar Usuario por ID",description = "Elimina un usuario segun el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Retorna Usuario"),
            @ApiResponse(responseCode = "404",description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del usuario", example = "123")
    public ResponseEntity<Void> deleteUserById(@PathVariable int id){
        if(userService.getUserById(id)!=null){
            userService.deleteUser(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario",description = "Permite actualizar los datos de un usuario segun su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Usuario creado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "204",description = "No hay contenido en la solicitud")
    })
    @Parameter(description = "El ID del usuario", example = "123")
    public ResponseEntity<Usuario> updateUser(@PathVariable int id, @RequestBody Usuario user){
        if(userService.getUserById(id)!=null){
            userService.updateUser(id,user);
            return  new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
