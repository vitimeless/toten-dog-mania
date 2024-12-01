package com.feevale.tirimania.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feevale.tirimania.model.Pedido;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SaveOrder {
    public static final String DATA_ORDER_LIST_JSON = "order-list.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static boolean saveOrder(Pedido pedido) {
        try {
            File arquivoJson = new File(DATA_ORDER_LIST_JSON);
            List<LinkedHashMap<String, Object>> saboresExistentes = new ArrayList<>();
            if (arquivoJson.exists()) {
                saboresExistentes = objectMapper.readValue(arquivoJson, new TypeReference<>() {});
            }
            LinkedHashMap<String, Object> pedidoAtual = new LinkedHashMap<>();
            pedidoAtual.put("itens", pedido.getItens());
            pedidoAtual.put("valorTotal", pedido.getValorTotal());
            pedidoAtual.put("concluido", pedido.isConcluido());
            saboresExistentes.add(pedidoAtual);
            objectMapper.writeValue(arquivoJson, saboresExistentes);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
