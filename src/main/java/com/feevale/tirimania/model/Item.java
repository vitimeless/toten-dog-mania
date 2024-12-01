package com.feevale.tirimania.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Vector;

public class Item {
    @JsonIgnore
    private List<Sabor> sabores;
    @JsonProperty
    private String nome;
    @JsonProperty
    private Sabor saborSelecionado;
    @JsonProperty
    private Float preco;

    public Item(String nome, List<Sabor> sabores, Float preco) {
        this.nome = nome;
        this.sabores = sabores;
        this.preco = preco;
    }

    @JsonCreator
    public Item(String nome, Sabor saborSelecionado, Float preco) {
        this.nome = nome;
        this.preco = preco;
        this.saborSelecionado = saborSelecionado;
    }

    public Item(List<Sabor> sabores, String nome, Sabor saborSelecionado, Float preco) {
        this.sabores = sabores;
        this.nome = nome;
        this.saborSelecionado = saborSelecionado;
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

    public void selecionarSabor(Sabor sabor) {
        this.saborSelecionado = sabor;
    }

    public Sabor getSaborSelecionado() {

        if (saborSelecionado == null)
            return new Sabor("");
        return saborSelecionado;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
