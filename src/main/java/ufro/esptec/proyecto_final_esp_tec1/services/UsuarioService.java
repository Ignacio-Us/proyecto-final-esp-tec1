package ufro.esptec.proyecto_final_esp_tec1.services;

import java.util.List;

import ufro.esptec.proyecto_final_esp_tec1.dto.UsuarioDTO;

public interface UsuarioService {

    public List<UsuarioDTO> getAllUsuarios() throws Exception;

    public UsuarioDTO getUsuarioById(Integer id) throws Exception;

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) throws Exception;

    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) throws Exception;
}
