package com.feevale.tirimania.model;

import java.util.List;
import java.util.Vector;

public class Item {

    private List<Sabor> sabores;
    private String nome;

    private Float preco;

    public Item(String nome, List<Sabor> sabores, Float preco) {
        this.nome = nome;
        this.sabores = sabores;
        this.preco = preco;
    }

    public Vector<Sabor> getSabores() {
        if (sabores == null || sabores.isEmpty())
            return new Vector<>();
        return new Vector<>(sabores);
    }

    public Float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome;
    }
}
