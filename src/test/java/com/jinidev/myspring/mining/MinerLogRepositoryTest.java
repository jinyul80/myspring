package com.jinidev.myspring.mining;

import com.jinidev.myspring.mining.model.MinerLog;
import com.jinidev.myspring.mining.repository.MinerLogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MinerLogRepositoryTest {

    @Autowired
    private MinerLogRepository repository;

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

}