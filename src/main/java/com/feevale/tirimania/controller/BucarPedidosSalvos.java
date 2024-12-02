package com.feevale.tirimania.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.feevale.tirimania.model.Item;
import com.feevale.tirimania.model.Pedido;
import com.feevale.tirimania.model.Sabor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.feevale.tirimania.controller.SalvarPedido.CAMINHO_ARQUIVO_PEDIDOS;
import static com.feevale.tirimania.controller.SalvarPedido.objectMapper;

public class BucarPedidosSalvos {

    public static final String EXTENISION_FILE = ".txt";
    public static final String FILES_NOTA_FISCAL = "files/relatorio-pedidos";

    public List<Pedido> buscarPedidos() {
        File arquivoJson = new File(CAMINHO_ARQUIVO_PEDIDOS);
        List<LinkedHashMap<String, Object>> pedidos = new ArrayList<>();
        if (arquivoJson.exists()) {
            try {
                pedidos = objectMapper.readValue(arquivoJson, new TypeReference<>() {
                });
                return converterParaPedidos(pedidos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    private List<Pedido> converterParaPedidos(List<LinkedHashMap<String, Object>> pedidos) {
        return pedidos.stream().map(p -> {
            Double preco = (Double) p.get("valorTotal");
            List<Item> itens = converterItens((List<LinkedHashMap<String, Object>>) p.get("itens"));
            return new Pedido(itens, preco.floatValue(), true);
        }).toList();
    }

    private List<Item> converterItens(List<LinkedHashMap<String, Object>> item) {

        return item.stream().map(i -> {
            String nome = (String) i.get("nome");
            LinkedHashMap<String, String> sabor = (LinkedHashMap<String, String>) i.get("saborSelecionado");
            String nomeSabor = sabor.get("nome");
            Double preco = (Double) i.get("preco");
            return new Item(nome, new Sabor(nomeSabor), preco.floatValue());
        }).toList();
    }
}

