/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian.jugadores;

import conquian.cartas.Carta;

/**
 *
 * @author Miguel
 */
public class PackTres {

    private Carta carta1;
    private Carta carta2;
    private Carta carta3;

    public PackTres(Carta c1, Carta c2, Carta c3) {
        this.carta1 = c1;
        this.carta2 = c2;
        this.carta3 = c3;
    }

    public boolean validar() {

        //Ordena por numero las cartas
        ordenarNumero();

        //Primeramente se verifica que existan las 3 cartas
        if (carta1 != null && carta2 != null && carta1 != null) {

            //Las 3 cartas tienen el mismo valor, entonces es valido
            if (carta1.getValorReal()== carta2.getValorReal() && carta2.getValorReal() == carta1.getValorReal()) {
                if ((carta1.getTipo() != carta2.getTipo()) && (carta1.getTipo() != carta3.getTipo()) && (carta2.getTipo() != carta3.getTipo())) {
                    return true;
                }
            }

            //Se verifica que sean 3 cartas en escalera del mismo tipo
            int menor = carta1.getValorReal();
            if (carta2.getValorReal() == (menor + 1) && carta3.getValorReal() == (menor + 2)) {
                if (carta1.getTipo() == carta2.getTipo() && carta2.getTipo() == carta3.getTipo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ordenarNumero() {

        Carta tmpCarta; //Se encarga de mantener la carta mientras cambia de posicion

        if (carta1.getValorReal() > carta3.getValorReal()) {
            tmpCarta = carta1;
            carta1 = carta3;
            carta3 = tmpCarta;
        }
        if (carta1.getValorReal() > carta2.getValorReal()) {
            tmpCarta = carta1;
            carta1 = carta2;
            carta2 = tmpCarta;
        }
        if (carta2.getValorReal() > carta3.getValorReal()) {
            tmpCarta = carta2;
            carta2 = carta3;
            carta3 = tmpCarta;
        }
    }

    @Override
    public String toString() {
        String str = "TRES CARTAS\n";
        str += carta1 + "\n" + carta2 + "\n" + carta3 + "\n";
        return str;
    }
}
