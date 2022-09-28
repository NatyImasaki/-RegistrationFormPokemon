package br.com.naty.pokeform.repository;

import br.com.naty.pokeform.entities.TypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<TypeEntity, Long> {
}
