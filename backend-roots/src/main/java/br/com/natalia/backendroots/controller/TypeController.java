package br.com.natalia.backendroots.controller;


import br.com.natalia.backendroots.dao.TypeDAO;
import br.com.natalia.backendroots.entities.TypeEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TypeController {

    @GetMapping("/type/list")
    public List<TypeEntity> listAll(){
        try {
            return new TypeDAO().lisAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
