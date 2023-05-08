package farm.tomato.repository.custom;

import farm.tomato.domain.Tomato;

import java.util.List;

public interface TomatoRepositoryCustom {
    List<Tomato> findAllTomato(Long fieldId);
}
