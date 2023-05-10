package farm.tomato.repository.custom;

import com.querydsl.core.Tuple;
import farm.tomato.domain.Tomato;
import farm.tomato.domain.dto.PestTureTomatoDTO;
import farm.tomato.domain.dto.TomatoDTO;

import java.util.List;

public interface TomatoRepositoryCustom {
    List<Tomato> findAllTomato(Long fieldId);

    List<PestTureTomatoDTO> findPestTomato(Long fieldId);
}
