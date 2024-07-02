package com.maen.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder //Crea objetos segun la necesidad y no como se hallan definido los constructores.
@Entity //Indica que es una entidad.
@AllArgsConstructor //Constructor con parametros.
@NoArgsConstructor //Constructor sin parametros.
@Table(name = "users") //Nombre de la tabla de la base de datos.
public class UserEntity {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private byte age;
}