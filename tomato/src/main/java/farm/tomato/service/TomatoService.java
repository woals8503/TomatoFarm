package farm.tomato.service;

public interface TomatoService {

    void createTomato(Long tomatoId);

    void water(Long tomatoId);

    void harvest(Long tomatoId, Long fieldId);

}

