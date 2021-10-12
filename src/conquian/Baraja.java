/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian;

import conquian.cartas.Carta;
import conquian.cartas.factory.BastosFactory;
import conquian.cartas.factory.CartaFactory;
import conquian.cartas.factory.CopasFactory;
import conquian.cartas.factory.EspadasFactory;
import conquian.cartas.factory.OroFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class Baraja {

    private List<Carta> cartas = new ArrayList<Carta>();
    private Carta enJuego;

    public Baraja() {

        CartaFactory factory;

        //Copas
        factory = new CopasFactory();
        cartas.addAll(factory.crearJuegoCartas());

        //Espadas
        factory = new EspadasFactory();
        cartas.addAll(factory.crearJuegoCartas());

        //Basto
        factory = new BastosFactory();
        cartas.addAll(factory.crearJuegoCartas());

        //Oro
        factory = new OroFactory();
        cartas.addAll(factory.crearJuegoCartas());
    }

    public void revolver() {
        Collections.shuffle(cartas);
    }

    public Carta tomarUna() {
        Carta c = null;
        if (cartas.size() > 0) {
            c = cartas.get(cartas.size() - 1);
            cartas.remove(c);
        }
        enJuego = cartas.get(cartas.size() - 1);
        return c;
    }

    public int cantidadCartas() {
        return cartas.size();
    }

    public Carta getEnJuego() {
        return enJuego;
    }

    @Override
    public String toString() {

        String str = "";

        str += "||----CARTAS[" + cartas.size() + "]----||\n";

        for (Carta c : cartas) {
            str += String.valueOf(c) + "\n";
        }

        str += "En juego: " + enJuego;
        return str;
    }
}
