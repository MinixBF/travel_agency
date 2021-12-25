package fr.lernejo.travelsite.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Table("inscription")
public class InscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String userEmail;
    public String userName;
    public String userCountry;
    public String weatherExpectation;
    public double minimumTemperatureDistance;
}
