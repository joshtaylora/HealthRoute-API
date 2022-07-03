package dev.joshtaylor.healthrouteapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "FOODS")
@RequiredArgsConstructor
public class Food {

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id", nullable = false)
    private Long foodId;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private int calories;


    @Column(name = "carbohydrates")
    private int carbs;

    @Column(name = "protein")
    private int protein;

    @Column(name = "fat")
    private int fat;

}
