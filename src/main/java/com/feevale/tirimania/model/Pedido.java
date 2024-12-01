package com.feevale.tirimania.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    @JsonProperty
    private List<Item> itens = new ArrayList<>(); // evita null pointer
    @JsonProperty
    private Float valorTotal = 0.0f;
    @JsonProperty
    private boolean concluido;

    @JsonCreator
    public Pedido(List<Item> itens, Float valorTotal, boolean concluido) {
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.concluido = concluido;
    }

    public Pedido() {
    }

    public void adicionarItem(Item novoItem) {
        itens.add(novoItem);
        valorTotal += novoItem.getPreco();
    }

    public List<Item> getItens() {
        return itens;
    }

    public Float getValorTotal() {
        return valorTotal;
    }


    public void removerItem(int index) {
        Item removido = itens.remove(index);
        valorTotal -= removido.getPreco();
    }

    public boolean isConcluido() {
        return concluido;
    }
}
