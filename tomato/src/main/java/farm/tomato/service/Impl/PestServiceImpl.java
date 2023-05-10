package farm.tomato.service.Impl;

import farm.tomato.repository.PestRepository;
import farm.tomato.service.PestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PestServiceImpl implements PestService {
    private final PestRepository pestRepository;
}
