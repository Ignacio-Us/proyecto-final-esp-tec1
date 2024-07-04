package ufro.esptec.proyecto_final_esp_tec1.mappers;

import org.springframework.stereotype.Component;

import ufro.esptec.proyecto_final_esp_tec1.dto.UsuarioDTO;
import ufro.esptec.proyecto_final_esp_tec1.models.Usuario;

@Component
public class UsuarioMapper {

    public UsuarioDTO toUsuarioDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setContrasena(usuario.getContrasena());

        return usuarioDTO;
    }
    
    public Usuario toEntity(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();

        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setContrasena(usuarioDTO.getContrasena());

        return usuario;
    }
}
