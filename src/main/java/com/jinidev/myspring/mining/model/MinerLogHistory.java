package com.jinidev.myspring.mining.model;

import java.sql.Timestamp;

public interface MinerLogHistory {
    Timestamp getDate();
    String getWorker();
    String getGpuName();
    int getHashRate();
}
