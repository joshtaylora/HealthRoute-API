package dev.joshtaylor.healthrouteapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "weights")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unit;

    private double value;

    public String toString() {
        return String.format("%.2f", getValue()) + " " + getUnit();
    }

}
