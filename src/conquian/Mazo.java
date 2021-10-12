/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian;

import conquian.cartas.Carta;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author Miguel
 */
public class Mazo {

    public static final int MAX_CARTAS = 8;

    private List<Carta> cartas = new ArrayList<>();

    public Mazo(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Carta getCarta(int index) {
        if (index < cartas.size()) {
            return cartas.get(index);
        }
        return null;
    }

    public void cambiarCarta(Carta original, Carta nueva) {

        if (original != null && nueva != null) {

            int indxOriginal = cartas.indexOf(original);

            if (indxOriginal >= 0 && indxOriginal < cartas.size()) {
                cartas.set(indxOriginal, nueva);
            }
        }
    }

    public void tirar(Carta c) {
        if (cartas.contains(c)) {
            cartas.remove(c);
        }
    }

    @Override
    public String toString() {
        String str = "|=======MAZO[" + cartas.size() + "]========|\n";

        for (Carta c : cartas) {
            str += cartas.indexOf(c) + ") " + String.valueOf(c) + "\n";
        }
        return str;
    }
}
