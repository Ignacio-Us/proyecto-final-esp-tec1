package ufro.esptec.proyecto_final_esp_tec1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 75)
    private String nombre;

    @Column(name = "email", nullable = false, length = 85)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 20)
    private String contrasena;

    @OneToMany(mappedBy = "usuario")
    private List<Puntaje> puntajes;

}
