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

    public void add(PokemonEntity pokemon) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokeform","root", "919191nY#");
        Statement stmt = conn.createStatement();
        String query = "insert into pokemon (gender, level, name, nature, nick, poke_id) " +
                "VALUES ('"+pokemon.getGender()+"', "+pokemon.getLevel()+ ", '"+pokemon.getName()+"', '"+pokemon.getNature()+"','"+pokemon.getNick()+"', "+pokemon.getPokeId()+")";
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);

        stmt.close();

        for (int i = 0; i < pokemon.getTypes().size(); i++){
            String typeQuery = "insert into pokemon_types (pokemon_entity_id, types_id) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(typeQuery);
            pstmt.setInt(1, id);
            pstmt.setLong(2, pokemon.getTypes().get(i).getId());
            pstmt.execute();

            pstmt.close();
        }
        conn.close();
    }

    public void remove(Long id) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokeform","root", "919191nY#");
        Statement stmt = conn.createStatement();
        String query = "delete from pokemon_types where pokemon_entity_id = " + id;
        stmt.executeUpdate(query);

        stmt.close();

        stmt = conn.createStatement();
        query = "delete from pokemon where id = " + id;
        stmt.executeUpdate(query);

        stmt.close();
    }
}
