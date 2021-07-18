package com.jinidev.myspring.mining.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "miner_log")
public class MinerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;

    private Timestamp date;
    private String worker;

    @Column(name = "gpu_id")
    private int gpuId;

    @Column(name = "gpu_name")
    private String gpuName;

    private double temperature;

    @Column(name = "fan_speed")
    private int fanSpeed;

    @Column(name = "hash_rate")
    private int hashRate;

    @Column(name = "core_clock")
    private int coreClock;

    @Column(name = "memory_clock")
    private int memoryClock;

    private int power;
    private double efficiency;
}
