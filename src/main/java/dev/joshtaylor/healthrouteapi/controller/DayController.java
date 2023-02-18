package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Day;
import dev.joshtaylor.healthrouteapi.domain.Meal;
import dev.joshtaylor.healthrouteapi.domain.Weight;
import dev.joshtaylor.healthrouteapi.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @PatchMapping("{dayId}/weight")
    public ResponseEntity<Day> setWeightForDay (@PathVariable Long dayId,
                                                @RequestBody Weight weight) {

        Optional<Day> optionalDay = dayRepository.findById(dayId);
        if (optionalDay.isPresent()) {
            Day day = optionalDay.get();
            day.setWeight(weight);
            Day updatedDay = dayRepository.save(day);
            return new ResponseEntity<>(updatedDay, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
