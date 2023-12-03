package com.example.delivery.domain.dados;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "dados")
@Entity(name = "/dados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dados {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer cpf;

    private Integer capacidadeveiculo;

    public Dados(RequestDados requestDados){
        this.name = requestDados.name();
        this.cpf = requestDados.cpf();
        this.capacidadeveiculo = requestDados.capacidadeveiculo();
    }

}
