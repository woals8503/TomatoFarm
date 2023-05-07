package farm.tomato.service.Impl;

import farm.tomato.repository.Impl.FieldRepositoryImpl;
import farm.tomato.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldRepositoryImpl gameRepository;

    @Override
    public void createField() {
        // 1. 먼저 필드를 생성해야한다

    }
}
