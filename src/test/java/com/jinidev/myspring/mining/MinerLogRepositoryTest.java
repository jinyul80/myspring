package com.jinidev.myspring.mining;

import com.fasterxml.jackson.databind.node.MissingNode;
import com.jinidev.myspring.mining.model.MinerLog;
import com.jinidev.myspring.mining.repository.MinerLogRepository;
import com.jinidev.myspring.mining.service.MinerLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MinerLogRepositoryTest {

    @Autowired
    private MinerLogRepository repository;

    @Autowired
    private MinerLogService service;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void findCount() {
        List<MinerLog> log = repository.findAll();
        System.out.println("DB 줄수:" + log.size());
    }

    @Test
    public void printLast100row() {
        List<MinerLog> log = repository.findAll();

        int startNum = log.size() - 100;

        for (int i = startNum; i < log.size() ; i++) {
            MinerLog ml = log.get(i);
            System.out.println(String.format("%d %ty-%tm-%td %s %d %s %.0f %d %d %d %d %d %.0f", ml.getPk(),
                    ml.getDate(), ml.getDate(), ml.getDate(), ml.getWorker(), ml.getGpuId(), ml.getGpuName(),
                    ml.getTemperature(), ml.getFanSpeed(), ml.getHashRate(), ml.getCoreClock(), ml.getMemoryClock(),
                    ml.getPower(), ml.getEfficiency()));
        }
    }

    @Test
    public void getWorkerList(){
        List<String> workerList = service.GetWorkerList();
        System.out.println(workerList);
    }

    @Test
    public void getGpuIdList(){
        List<String> workerList = service.GetWorkerList();

        for (String worker: workerList) {
            System.out.println("**** Worker:" + worker + "****");

            List<Integer> gpuIdList = service.GetGpuIdList(worker);

            for (int id:gpuIdList) {
                String gpuName = service.GetGpuName(worker, id);
                System.out.println("ID:" + id + ", Gpu Name:" + gpuName);
            }

            System.out.println();
        }
    }

    @Test
    public void getLogHistory(){
        String day = "-1";

        List<Object[]> logList = service.GetLogHistory(day);

        for (Object[] log: logList ) {
            System.out.printf("%s %s %s %d %n", log[0], log[1], log[2], Integer.parseInt(log[3].toString()));
        }
    }

}
