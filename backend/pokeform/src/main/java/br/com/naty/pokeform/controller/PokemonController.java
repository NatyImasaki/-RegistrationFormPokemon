package br.com.naty.pokeform.controller;

import br.com.naty.pokeform.entities.PokemonEntity;
import br.com.naty.pokeform.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @PostMapping("/pokemon/add")
    public String addPokemon(@RequestBody PokemonEntity pokemon){
        repository.save(pokemon);
        return "ok";
    }
    @GetMapping("/pokemon/list")
    public Iterable<PokemonEntity> listAll(){
        return repository.findAll();
    }

    @DeleteMapping("/pokemon/remove")
    public String deletePokemon(@RequestParam Long id){
        repository.deleteById(id);
        return "Pokemon removido";
    }
}