package com.feevale.tirimania.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sabor {

    @JsonProperty
    private String nome;

    @JsonCreator
    public Sabor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return nome;
    }
}
