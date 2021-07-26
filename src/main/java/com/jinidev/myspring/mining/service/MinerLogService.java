package com.jinidev.myspring.mining.service;

import com.jinidev.myspring.mining.model.MinerLog;
import com.jinidev.myspring.mining.repository.MinerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MinerLogService {

    @Autowired
    private MinerLogRepository repository;

    public List<String> GetWorkerList() {
        List<MinerLog> log = repository.findAll();

        return log.stream()
                .map(MinerLog::getWorker)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> GetGpuIdList(String worker) {
        List<MinerLog> log = repository.findByWorker(worker);

        return log.stream()
                .map(MinerLog::getGpuId)
                .distinct()
                .collect(Collectors.toList());
    }

    public String GetGpuName(String worker, int gpuId){
        List<MinerLog> log = repository.findByWorkerAndGpuId(worker, gpuId);

        Optional<String> opt = log.stream()
                .map(MinerLog::getGpuName)
                .distinct()
                .findFirst();

        return opt.orElse("");
    }

    public List<Object[]> GetLogHistory(String day) {
        List<Object[]> logList = repository.getLogHistory(day);

        return logList;
    }

}
