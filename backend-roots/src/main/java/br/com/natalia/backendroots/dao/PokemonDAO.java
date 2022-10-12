package br.com.natalia.backendroots.dao;

import br.com.natalia.backendroots.entities.PokemonEntity;
import br.com.natalia.backendroots.entities.TypeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {
    public List<PokemonEntity> listAll() throws SQLException {
        List<PokemonEntity> pokemons = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokeform","root", "919191nY#");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from pokemon");

        while (resultSet.next()) {

            PokemonEntity pokemon = new PokemonEntity(resultSet.getLong("id"),
                    resultSet.getLong("poke_id"),
                    resultSet.getString("name"),
                    resultSet.getString("nick"),
                    resultSet.getShort("level"),
                    resultSet.getString("gender").charAt(0),
                    resultSet.getString("nature"),
                    new ArrayList<>());

            Statement typeStmt = conn.createStatement();
            ResultSet typeRs = typeStmt.executeQuery("select * from types join pokemon_types pt on types.id = pt.types_id and pt.pokemon_entity_id = " + pokemon.getId());

            while (typeRs.next()){
                pokemon.getTypes().add(new TypeEntity(typeRs.getLong("id"),
                        typeRs.getString("type")));
            }

            typeRs.close();
            typeStmt.close();

            pokemons.add(pokemon);
        }

        resultSet.close();
        stmt.close();
        conn.close();

        return pokemons;
    }
}
