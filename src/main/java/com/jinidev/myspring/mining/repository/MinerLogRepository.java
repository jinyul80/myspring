package com.jinidev.myspring.mining.repository;

import com.jinidev.myspring.mining.model.MinerLog;
import com.jinidev.myspring.mining.model.MinerLogHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MinerLogRepository extends JpaRepository<MinerLog, Integer> {

    List<MinerLog> findByWorker(String worker);

    List<MinerLog> findByWorkerAndGpuId(String worker, int gpuId);

    @Query(
            value = "SELECT STR_TO_DATE(concat(date_format(date, '%y-%m-%d %H:'), floor(MINUTE(date)/ 10) * 10, ':00'), '%y-%m-%d %H:%i:%s') AS date," +
            " worker, gpu_name as gpuName , FLOOR(AVG(hash_rate)) as hashRate" +
            " FROM jini_db.miner_log ml" +
            " WHERE date > DATE_ADD(now(), INTERVAL ?1 DAY)" +
            " GROUP BY floor(date_format(date, '%y%m%d%H%i') / 10), worker, gpu_id, gpu_name" +
            " ORDER BY date DESC, worker, gpu_id"
            , nativeQuery = true)
    List<MinerLogHistory> getLogHistory(String day);
}
