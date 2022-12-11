package br.com.natalia.backendroots.controller;

import br.com.natalia.backendroots.dao.PokemonDAO;
import br.com.natalia.backendroots.entities.PokemonEntity;
import br.com.natalia.backendroots.entities.TypeEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PokemonController {
    @GetMapping("/pokemon/list")
    public List<PokemonEntity> listAll(){
        try {
            return new PokemonDAO().listAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/pokemon/add")
    public String add(@RequestBody PokemonEntity pokemon) {
        PokemonDAO dao = new PokemonDAO();
        try {
            dao.add(pokemon);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }

    @DeleteMapping("/pokemon/remove")
    public String remove(@RequestParam Long id) {
        PokemonDAO dao = new PokemonDAO();
        try {
            dao.remove(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }
}
