package com.feevale.tirimania.model.gerador;

import com.feevale.tirimania.model.Item;
import com.feevale.tirimania.model.Sabor;

import java.util.List;
import java.util.Vector;

public class GeradorDeTiposDePedidos {

    public static Vector<Item> getAlimentos() {
        return new Vector<>(List.of(
                new Item("Pastel",
                        List.of(
                                new Sabor("Carne"),
                                new Sabor("Queijo"),
                                new Sabor("Brocolis"),
                                new Sabor("Frango")
                        )
                        , 9.0f),
                new Item("Sanduiche",
                        List.of(
                                new Sabor("Carne"),
                                new Sabor("Queijo"),
                                new Sabor("Frango")
                        )
                        , 7.0f),
                new Item("Enroladinho de Salsicha",
                        List.of()
                        , 1.0f),
                new Item("Pão de queijo",
                        List.of()
                        , 3.0f),
                new Item("Pizza",
                        List.of(
                                new Sabor("Carne"),
                                new Sabor("Queijo"),
                                new Sabor("Brocolis"),
                                new Sabor("Frango"),
                                new Sabor("Calabresa")
                        )
                        , 12.0f),
                new Item("Empada",
                        List.of(
                                new Sabor("Carne de panela"),
                                new Sabor("Frango")
                        )
                        , 10.0f),
                new Item("Hamburguer",
                        List.of()
                        , 7.0f)
        ));
    }
}
