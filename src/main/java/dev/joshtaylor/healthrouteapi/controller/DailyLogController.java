package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.DailyLog;
import dev.joshtaylor.healthrouteapi.repository.DailyLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dailylogs")
public class DailyLogController {
    @Autowired
    private DailyLogRepository dailyLogRepository;

    @GetMapping("")
    public List<DailyLog> getDailyLogs () {
        return dailyLogRepository.findAll();
    }

    @PostMapping("")
    public DailyLog createDailyLog (@RequestBody DailyLog day) {
        DailyLog newDailyLog = new DailyLog(day.getDate());
        return dailyLogRepository.save(newDailyLog);
    }

}
