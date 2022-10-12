package br.com.natalia.backendroots.entities;


import java.util.List;

public class PokemonEntity {

    private Long id;

    private Long pokeId;
    private String name;
    private String nick;
    private Short level;
    private Character gender;
    private String nature;

    public PokemonEntity(Long id, Long pokeId, String name, String nick, Short level,
                         Character gender, String nature, List<TypeEntity> types) {
        this.id = id;
        this.pokeId = pokeId;
        this.name = name;
        this.nick = nick;
        this.level = level;
        this.gender = gender;
        this.nature = nature;
        this.types = types;
    }

    private List<TypeEntity> types;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPokeId() {
        return pokeId;
    }

    public void setPokeId(Long pokeId) {
        this.pokeId = pokeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public List<TypeEntity> getTypes() {
        return types;
    }

    public void setTypes(List<TypeEntity> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "PokemonEntity{" +
                "id=" + id +
                ", pokeId=" + pokeId +
                ", name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", level=" + level +
                ", gender=" + gender +
                ", nature='" + nature + '\'' +
                ", types=" + types +
                '}';
    }
}
