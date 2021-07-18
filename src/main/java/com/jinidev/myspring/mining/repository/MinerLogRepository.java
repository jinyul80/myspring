package com.jinidev.myspring.mining.repository;

import com.jinidev.myspring.mining.model.MinerLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinerLogRepository extends JpaRepository<MinerLog, Integer> {
}
