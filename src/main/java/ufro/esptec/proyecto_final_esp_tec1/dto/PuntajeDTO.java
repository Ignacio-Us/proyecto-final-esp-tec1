package ufro.esptec.proyecto_final_esp_tec1.dto;

import lombok.Data;

@Data
public class PuntajeDTO {
    
    private Integer id;
    private Short puntaje;
    private Integer idUsuario;
    private String nombreUsuario;
}
