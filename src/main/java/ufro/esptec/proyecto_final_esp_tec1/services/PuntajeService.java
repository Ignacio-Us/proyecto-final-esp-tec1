package ufro.esptec.proyecto_final_esp_tec1.services;

import java.util.List;

import ufro.esptec.proyecto_final_esp_tec1.dto.PuntajeDTO;

public interface PuntajeService {

    public List<PuntajeDTO> getAllPuntajes() throws Exception;

    public PuntajeDTO createPuntaje() throws Exception;
}
