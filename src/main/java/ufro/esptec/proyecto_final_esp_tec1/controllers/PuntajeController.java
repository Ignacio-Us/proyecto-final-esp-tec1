package ufro.esptec.proyecto_final_esp_tec1.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ufro.esptec.proyecto_final_esp_tec1.dto.PuntajeDTO;
import ufro.esptec.proyecto_final_esp_tec1.services.PuntajeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
public class PuntajeController {
    
    private final PuntajeService puntajeService;

    @GetMapping
    public ResponseEntity<List<PuntajeDTO>> getAllPuntajes(){
       try {
            return ResponseEntity.ok(puntajeService.getAllPuntajes());
       } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       } 
    }

    @PostMapping
    public ResponseEntity<PuntajeDTO> createPuntaje(@RequestBody PuntajeDTO puntajeToCreate){
        try {
            return ResponseEntity.ok(puntajeService.createPuntaje(puntajeToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
