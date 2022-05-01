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
public class Food
{
    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "calories", nullable = false)
    private int calories;


    @Column(name = "carbohydrates", nullable = false)
    private int carbs;

    @Column(name = "protein", nullable = false)
    private int protein;

    @Column(name = "fat", nullable = false)
    private int fat;

}
