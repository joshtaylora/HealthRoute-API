package dev.joshtaylor.healthrouteapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MEALS")
@RequiredArgsConstructor
public class Meal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meal_id", nullable = false)
    private Long meal_id;

    @Column(name = "timestamp", nullable = false)
    private java.sql.Timestamp mealTime;

    @OneToMany(mappedBy = "meal")
    @Column(name = "foods", nullable = false)
    private Set<Food> foods;
}
