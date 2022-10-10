package br.com.naty.pokeform.repository;

import br.com.naty.pokeform.entities.PokemonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<PokemonEntity, Long> {
}
