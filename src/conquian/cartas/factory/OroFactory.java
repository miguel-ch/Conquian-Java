/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian.cartas.factory;

import conquian.cartas.Carta;
import conquian.cartas.CartaOro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class OroFactory implements CartaFactory {

    @Override
    public List<Carta> crearJuegoCartas() {

        List<Carta> juegoCartas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            juegoCartas.add(new CartaOro(i));
        }
        return juegoCartas;
    }
}
