package ufro.esptec.proyecto_final_esp_tec1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufro.esptec.proyecto_final_esp_tec1.dto.UsuarioDTO;
import ufro.esptec.proyecto_final_esp_tec1.mappers.UsuarioMapper;
import ufro.esptec.proyecto_final_esp_tec1.models.Usuario;
import ufro.esptec.proyecto_final_esp_tec1.repositories.UsuarioRepository;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> getAllUsuarios() throws Exception {
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return usuarios.stream()
                    .map(usuarioMapper::toUsuarioDTO)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new Exception("Error fetching users: " + e.getMessage());
        }
    }

    @Override
    public UsuarioDTO getUsuarioById(Integer id) throws Exception {
        Optional<Usuario> optionalUser = usuarioRepository.findById(id);
        if (optionalUser.isPresent()) {
            return usuarioMapper.toUsuarioDTO(optionalUser.get());
        } else {
            throw new Exception("User not found with id: " + id);
        }
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) throws Exception {
        try {
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            usuario = usuarioRepository.save(usuario);
            return usuarioMapper.toUsuarioDTO(usuario);
        } catch (DataAccessException e) {
            throw new Exception("Error creating user: " + e.getMessage());
        }
    }
    
}
