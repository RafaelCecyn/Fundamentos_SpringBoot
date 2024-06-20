package br.com.rafaelcecyn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {

    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id) {
        return "O parametro é " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id) {
        return "O parametro com metodoComQueryParams é " + id;
    }

    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String,String> allParams) {
        return "O parametro com metodoComQueryParams são " + allParams.entrySet();
    }

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody String username) {
        return "metodoComBodyParams " + username;
    }

    @PostMapping("/metodoComBodyParams2")
    public String metodoComBodyParams2(@RequestBody Usuario usuario) {
        return "metodoComBodyParams " + usuario.username;
    }

    @PostMapping("/metodoComHeaders")
    public String metodoComHeaders(@RequestHeader("name") String name) {
        return "metodoComHeaders " + name;
    }

    @PostMapping("/metodoComHeaders2")
    public String metodoComHeaders2(@RequestHeader("name") Map<String,String> all) {
        return "metodoComHeaders2 " + all.entrySet();
    }

    @GetMapping("metodoResponseEntity/{id}")
    public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id) {
        var usuario = new Usuario("rafaelcecyn");
        if(id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valor deve ser maior que 5");
    }



    record Usuario(String username) {}


}
