package com.feevale.tirimania.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Item> itens = new ArrayList<>(); // evita null pointer
    private Float valorTotal = 0.0f;
    private boolean concluido;

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


}
