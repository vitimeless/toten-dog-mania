package com.feevale.tirimania.model;

public class Sabor {
    private String nome;

    public Sabor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
