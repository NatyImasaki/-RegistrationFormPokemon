package br.com.natalia.backendroots.dao;

import br.com.natalia.backendroots.entities.TypeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO {
    public List<TypeEntity> lisAll() throws SQLException {
        List<TypeEntity> types = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokeform","root", "919191nY#");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from types");

        while (resultSet.next()){
            TypeEntity type = new TypeEntity(resultSet.getLong("id"), resultSet.getString("type"));
            types.add(type);
        }

        resultSet.close();
        stmt.close();
        conn.close();

        return types;
    }
}
