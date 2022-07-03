package dev.joshtaylor.healthrouteapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
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

    @Column(name = "timestamp")
    private String mealTime;

    @OneToMany(
            mappedBy = "meal",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Column(name = "foods")
    private Set<Food> foods;

    public void setTimeStamp(java.sql.Timestamp timeStamp) {
        this.mealTime = timeStamp.toString();
    }
}
