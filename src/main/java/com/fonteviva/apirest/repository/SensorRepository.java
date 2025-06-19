package com.fonteviva.apirest.repository;
import com.fonteviva.apirest.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByEstacaoTratamentoId(Long idEstacao);
}

