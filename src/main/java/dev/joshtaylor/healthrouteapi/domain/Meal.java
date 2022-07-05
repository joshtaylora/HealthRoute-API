package dev.joshtaylor.healthrouteapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meal_id;

    private String timestamp;

    public Meal (String timestamp) {
        this.timestamp = timestamp;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity=Food.class, mappedBy="mealId")
    public List<Food> foods;

    private Long dailyLogId;
    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
