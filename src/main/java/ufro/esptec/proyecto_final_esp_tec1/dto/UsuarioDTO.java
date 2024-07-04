package ufro.esptec.proyecto_final_esp_tec1.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    
    private Integer id;
    private String nombre;
    private String email;
    private String contrasena;
}
