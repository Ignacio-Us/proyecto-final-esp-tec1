package ufro.esptec.proyecto_final_esp_tec1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufro.esptec.proyecto_final_esp_tec1.models.Puntaje;

@Repository
public interface PuntajeRepository extends JpaRepository<Puntaje, Integer> {
    
}
