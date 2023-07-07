package com.sohaib.entitires;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@ToString
@Entity
@Table(name = "personne")
public class PersonneEntity extends AbstractEntity {


    @Column(name = "nom")
    String nom;

    @Column(name = "prenom")
    String prenom;

}
