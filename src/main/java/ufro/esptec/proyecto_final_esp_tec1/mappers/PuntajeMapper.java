package ufro.esptec.proyecto_final_esp_tec1.mappers;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import ufro.esptec.proyecto_final_esp_tec1.dto.PuntajeDTO;
import ufro.esptec.proyecto_final_esp_tec1.models.Puntaje;
import ufro.esptec.proyecto_final_esp_tec1.models.Usuario;
import ufro.esptec.proyecto_final_esp_tec1.repositories.UsuarioRepository;

@Component
@AllArgsConstructor
public class PuntajeMapper {
    
    private final UsuarioRepository usuarioRepository;

    public PuntajeDTO toPuntajeDTO(Puntaje puntaje){
        PuntajeDTO puntajeDTO = new PuntajeDTO();

        puntajeDTO.setId(puntaje.getId());
        puntajeDTO.setPuntaje(puntaje.getPuntaje());
        puntajeDTO.setIdUsuario(puntaje.getUsuario().getId());
        puntajeDTO.setNombreUsuario(puntaje.getUsuario().getNombre());

        return puntajeDTO;
    }

    public Puntaje toEntity(PuntajeDTO puntajeDTO) throws Exception{
        Puntaje puntaje = new Puntaje();

        puntaje.setId(puntajeDTO.getId());
        puntaje.setPuntaje(puntajeDTO.getPuntaje());

        Usuario usuario = usuarioRepository.findById(puntajeDTO.getIdUsuario()).
        orElseThrow(() -> new Exception("User not found with ID: " + puntajeDTO.getIdUsuario()));

        puntaje.setUsuario(usuario);

        return puntaje;
    }
}
