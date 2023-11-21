package com.core.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ReportService {
    private int currentNumber = 0;
    private boolean isSchedulerRunning = false;

    public ReportService() {}

    private void startScheduler() {
        if (!isSchedulerRunning) {
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

            scheduler.scheduleAtFixedRate(() -> {
                if (currentNumber <= 100) {
                    System.out.println("Número Atual: " + currentNumber);
                    currentNumber += 4;
                } else {
                    scheduler.shutdown();
                    currentNumber = 0;
                    isSchedulerRunning = false;
                }
            }, 0, 2, TimeUnit.SECONDS);

            isSchedulerRunning = true;
        } else {
            System.out.println("Scheduler já está em execução.");
        }
    }

    public int getPercentualAtual() {
        return this.currentNumber;
    }
}
