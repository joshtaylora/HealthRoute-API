package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Day;
import dev.joshtaylor.healthrouteapi.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/days")
public class DayController {
    @Autowired
    private DayRepository dayRepository;

    @GetMapping("")
    public List<Day> getDailyLogs () {
        return dayRepository.findAll();
    }

    @PostMapping("")
    public Day createDailyLog (@RequestBody Day day) {
        Day newDay = new Day(day.getDate());
        return dayRepository.save(newDay);
    }

}
