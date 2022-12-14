package com.formacionbdi.springboot.app.oauth.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

@FeignClient(name="servicio-usuarios")
public interface UsuarioFeignClient {
    

    @GetMapping("/usuarios/search/buscar-username")
    public Usuario findByUsername(@RequestParam("nombre") String username);


    @PutMapping("/usuarios/{id}")
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);
    

}
