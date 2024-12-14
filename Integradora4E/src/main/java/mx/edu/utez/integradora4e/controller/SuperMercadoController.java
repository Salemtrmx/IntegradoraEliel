package mx.edu.utez.integradora4e.controller;


import mx.edu.utez.integradora4e.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supermercado")
public class SuperMercadoController {

    @Autowired
    private CarritoService carritoService;



}
