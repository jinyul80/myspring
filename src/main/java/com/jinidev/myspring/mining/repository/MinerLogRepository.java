package com.jinidev.myspring.mining.repository;

import com.jinidev.myspring.mining.model.MinerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MinerLogRepository extends JpaRepository<MinerLog, Integer> {

    List<MinerLog> findByWorker(String worker);

    List<MinerLog> findByWorkerAndGpuId(String worker, int gpuId);
}
