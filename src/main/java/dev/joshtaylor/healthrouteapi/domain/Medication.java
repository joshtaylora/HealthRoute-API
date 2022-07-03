package dev.joshtaylor.healthrouteapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "MEDICATIONS")
@RequiredArgsConstructor
public class Medication
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medication_id", nullable = false)
    private Long medication_id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "strength")
    private int strength;

    @Column(name = "dosage_unit")
    private String dosage_unit;
}
