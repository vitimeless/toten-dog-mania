package com.feevale.tirimania.model.factory;

import com.feevale.tirimania.model.Item;
import com.feevale.tirimania.model.Sabor;

import java.util.List;
import java.util.Vector;

public class AlimentosFactory {

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
                        null
                        , 1.0f)
        ));
    }
}
