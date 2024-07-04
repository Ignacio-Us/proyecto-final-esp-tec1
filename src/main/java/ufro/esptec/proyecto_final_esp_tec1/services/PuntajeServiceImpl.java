package ufro.esptec.proyecto_final_esp_tec1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufro.esptec.proyecto_final_esp_tec1.dto.PuntajeDTO;
import ufro.esptec.proyecto_final_esp_tec1.mappers.PuntajeMapper;
import ufro.esptec.proyecto_final_esp_tec1.models.Puntaje;
import ufro.esptec.proyecto_final_esp_tec1.repositories.PuntajeRepository;

@Service
@AllArgsConstructor
public class PuntajeServiceImpl implements PuntajeService {
    
    private final PuntajeRepository puntajeRepository;
    private final PuntajeMapper puntajeMapper;
    @Override
    public List<PuntajeDTO> getAllPuntajes() throws Exception {
        try {
            List<Puntaje> puntajes = puntajeRepository.findAll();
            return puntajes.stream()
                    .map(puntajeMapper::toPuntajeDTO)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new Exception("Error fetching users: " + e.getMessage());
        }
    }
    @Override
    public PuntajeDTO createPuntaje(PuntajeDTO puntajeToCreated) throws Exception {
        try {
            Puntaje puntaje = puntajeMapper.toEntity(puntajeToCreated);
            puntaje = puntajeRepository.save(puntaje);
            return puntajeMapper.toPuntajeDTO(puntaje);
        } catch (DataAccessException e) {
            throw new Exception("Error creating user: " + e.getMessage());
        }
    }


}
