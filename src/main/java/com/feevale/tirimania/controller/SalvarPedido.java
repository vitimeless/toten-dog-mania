package com.feevale.tirimania.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feevale.tirimania.model.Pedido;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SalvarPedido {
    public static final String CAMINHO_ARQUIVO_PEDIDOS = "files/order-list.json";
    public static final String ITENS = "itens";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static final String VALOR_TOTAL = "valorTotal";
    public static final String CONCLUIDO = "concluido";

    public static boolean salvarPedido(Pedido pedido) {
        try {
            File arquivoJson = new File(CAMINHO_ARQUIVO_PEDIDOS);
            List<LinkedHashMap<String, Object>> saboresExistentes = new ArrayList<>();
            if (arquivoJson.exists()) {
                saboresExistentes = objectMapper.readValue(arquivoJson, new TypeReference<>() {});
            }
            LinkedHashMap<String, Object> pedidoAtual = new LinkedHashMap<>();
            pedidoAtual.put(ITENS, pedido.getItens());
            pedidoAtual.put(VALOR_TOTAL, pedido.getValorTotal());
            pedidoAtual.put(CONCLUIDO, pedido.isConcluido());
            saboresExistentes.add(pedidoAtual);
            objectMapper.writeValue(arquivoJson, saboresExistentes);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
