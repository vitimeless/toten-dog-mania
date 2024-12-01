package com.feevale.tirimania.controller;

import com.feevale.tirimania.model.Pedido;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerarNotaFiscal {

    public static final String EXTENISION_FILE = ".txt";
    public static final String FILES_NOTA_FISCAL = "files/nota-fiscal-";

    public static void gerarNotaFiscal(Pedido pedido) {
        LocalDateTime date = LocalDateTime.now();
        String dateFormat = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String dateToFile = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        StringBuilder sb = new StringBuilder();
        int larguraMaxItem = pedido.getItens().stream()
                .mapToInt(item -> (item.getNome() + " " + item.getSaborSelecionado()).length())
                .max()
                .orElse(50);
        int larguraMaxValor = 50;
        String formatoLinha = "%-" + larguraMaxItem + "s          %-" + larguraMaxValor + ".2f%n";
        String formatoLinhaString = "%-" + larguraMaxItem + "s          %-" + larguraMaxValor + "s%n";
        sb.append("==================== NOTA FISCAL ====================\n");
        sb.append("--------------------  DOG MANIA  --------------------\n");
        sb.append("---------------- ").append(dateFormat).append(" -----------------\n");
        sb.append(String.format(formatoLinhaString, "Item:", "Valor:"));

        pedido.getItens().forEach(item -> sb.append(String.format(formatoLinha, item.getNome() + " " + item.getSaborSelecionado(), item.getPreco())));
        sb.append("------------------------------------------------------\n");
        sb.append(String.format(formatoLinha, "Total:", pedido.getValorTotal()));
        sb.append("=====================================================\n");

        String fileName = FILES_NOTA_FISCAL + dateToFile + EXTENISION_FILE;
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
