package br.com.naty.pokeform.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="POKEMON")
public class PokemonEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nick;
    private Short level;
    private Character gender;
    private String nature;

    @ManyToMany
    private Set<TypeEntity> types;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<TypeEntity> getTypes() {
        return types;
    }

    public void setTypes(Set<TypeEntity> types) {
        this.types = types;
    }
}
