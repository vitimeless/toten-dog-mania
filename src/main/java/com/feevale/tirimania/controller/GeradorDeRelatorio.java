package com.feevale.tirimania.controller;

import com.feevale.tirimania.model.Pedido;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import static com.feevale.tirimania.controller.GerarNotaFiscal.EXTENISION_FILE;

public class GeradorDeRelatorio {

    public static final String RELATORIOS_PATH = "files/relatorio";

    public void gerarRelatorio(List<Pedido> pedidos) {
        LocalDateTime date = LocalDateTime.now();
        String dateFormat = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String dateToFile = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        StringBuilder sb = new StringBuilder();
        int larguraMaxItem = pedidos.stream()
                .mapToInt(item ->
                        item.getItens().stream()
                                .mapToInt(item2 -> (item2.getNome() + " " + item2.getSaborSelecionado()).length())
                                .max()
                                .orElse(50)
                )
                .max()
                .orElse(50);
        int larguraMaxValor = 50;
        String formatoLinha = "%-" + larguraMaxItem + "s          %-" + larguraMaxValor + ".2f%n";
        String formatoLinhaString = "%-" + larguraMaxItem + "s          %-" + larguraMaxValor + "s%n";
        sb.append("==================== RELATÓRIO GERAL ====================\n");
        sb.append("--------------------  DOG MANIA  --------------------\n");
        sb.append("---------------- ").append(dateFormat).append(" -----------------\n");


        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            sb.append("=================== Pedido #" + i + " =====================\n");
            sb.append(String.format(formatoLinhaString, "Item:", "Valor:"));
            pedido.getItens().forEach(item -> sb.append(String.format(formatoLinha, item.getNome() + " " + item.getSaborSelecionado(), item.getPreco())));
            sb.append(String.format(formatoLinha, "Total:", pedido.getValorTotal()));
        }
        sb.append("=====================================================\n");


        String fileName = RELATORIOS_PATH + dateToFile + EXTENISION_FILE;
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
