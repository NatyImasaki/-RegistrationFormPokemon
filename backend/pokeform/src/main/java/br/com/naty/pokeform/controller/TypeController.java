package br.com.naty.pokeform.controller;

import br.com.naty.pokeform.entities.TypeEntity;
import br.com.naty.pokeform.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TypeController {
    @Autowired
    private TypeRepository repository;

    @GetMapping("/type/list")
    public Iterable<TypeEntity> listAll(){
        return repository.findAll();
    }

}
