package com.example.delivery.controllers;

import com.example.delivery.domain.dados.Dados;
import com.example.delivery.domain.dados.DadosRepository;
import com.example.delivery.domain.dados.RequestDados;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dados")
public class DadosController {
    @Autowired
    private DadosRepository repository;
    @GetMapping
    public ResponseEntity getAllDados(){
        var allDados = repository.findAll();
        return ResponseEntity.ok(allDados);
    }

    @PostMapping
    public ResponseEntity registerDados(@RequestBody @Valid RequestDados data) {
        Dados newDados = new Dados(data);
        repository.save(newDados);
        return  ResponseEntity.ok().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity updateDados(@RequestBody @Valid RequestDados data){
        Optional<Dados> optionalDados = repository.findById(data.id());
        if(optionalDados.isPresent()) {
            Dados dados = optionalDados.get();
            dados.setName(data.name());
            dados.setCpf(data.cpf());
            dados.setCapacidadeveiculo(data.capacidadeveiculo());
            return ResponseEntity.ok(dados);
        }else {
            return ResponseEntity.notFound().build();
        }


    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDados(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
