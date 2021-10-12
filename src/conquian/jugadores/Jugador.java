/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian.jugadores;

import conquian.Mazo;
import conquian.cartas.Carta;

/**
 *
 * @author Miguel
 */
public class Jugador {

    private Mazo mazo;
    private String nombre;

    public Jugador(Mazo m, String nombre) {
        this.mazo = m;
        this.nombre = nombre;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        String str = "**********" + nombre + "**********\n";
        str += mazo;

        return str;
    }
}
