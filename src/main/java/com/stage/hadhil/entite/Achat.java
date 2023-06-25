package com.stage.hadhil.entite;

import lombok.Data;

import javax.persistence.*; //jpa

@Entity
@Data
@Table(name = "ACHAT")
public class Achat {

    @Id
    private Long id;

    @Column( length = 2, nullable = false)
    private String mois;

    @Column( length = 4, nullable = false)
    private String annee;

    @Column( length = 2, nullable = false)
    private String siege;

    @Column(  nullable = false)
    private String numPiece;

    @Column( nullable = false)
    private String numPost;

    @Column(  nullable = false)
    private String ntx;

    @Column( nullable = false)
    private String ntc;

    @Column( nullable = false)
    private String libelle;

    @Column( nullable = false)
    private String dateRealisation;

    @Column(nullable = false)
    private Long montant;
}