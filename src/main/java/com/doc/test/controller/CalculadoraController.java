package com.doc.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
    @GetMapping("/suma")
    public String suma(@RequestParam int a,@RequestParam int b){
        try{
            int resultado = a+b;
            return "El resultado de la suma es: " + resultado;
        } catch (ArithmeticException e) {
            return "Error al sumar: " + e.getMessage();
        }
    }

    @GetMapping("/home")
    public String home(){
        return "Hola. Soy la calculadora DevOps corriendo en docker";
    }
}