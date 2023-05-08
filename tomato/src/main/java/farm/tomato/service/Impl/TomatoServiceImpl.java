package farm.tomato.service.Impl;

import farm.tomato.repository.TomatoRepository;
import farm.tomato.service.TomatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TomatoServiceImpl implements TomatoService {
    private final TomatoRepository tomatoRepository;
}
