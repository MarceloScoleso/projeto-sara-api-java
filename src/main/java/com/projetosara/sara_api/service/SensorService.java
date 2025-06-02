package com.projetosara.sara_api.service;

import com.projetosara.sara_api.dto.SensorDTO;
import com.projetosara.sara_api.entity.Sensor;
import com.projetosara.sara_api.mapper.SensorMapper;
import com.projetosara.sara_api.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class SensorService {
    private final SensorRepository repository;
    private final SensorMapper mapper;

    @Cacheable(value = "sensores", key = "#tipo + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<SensorDTO> listar(long tipoSensorId, Pageable pageable) {
        return repository.findByFiltro(tipoSensorId, pageable).map(mapper::toDTO);
    }

    @Cacheable(value = "sensores", key = "#id")
    public Optional<SensorDTO> findById(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @CacheEvict(value = "sensores", allEntries = true)
    public SensorDTO save(SensorDTO dto) {
        Sensor entidade = mapper.toEntity(dto);
        Sensor salva = repository.save(entidade);
        return mapper.toDTO(salva);
    }

    @CacheEvict(value = "sensores", allEntries = true)
    public Optional<SensorDTO> update(Long id, SensorDTO dto) {
        return repository.findById(id).map(existing -> {
            dto.setId(id);
            Sensor entidadeAtualizada = mapper.toEntity(dto);
            Sensor salva = repository.save(entidadeAtualizada);
            return mapper.toDTO(salva);
        });
    }

    @CacheEvict(value = "sensores", allEntries = true)
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
