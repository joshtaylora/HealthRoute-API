package dev.joshtaylor.healthrouteapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @OneToMany(targetEntity = Meal.class, mappedBy = "day_id")
    private List<Meal> meals;

    @OneToMany(targetEntity = Medication.class, mappedBy = "day_id")
    private List<Medication> medications;

    @OneToOne(targetEntity = Weight.class)
    private Weight weight;

    public Day (String date) {

        this.date = date;
    }

}
