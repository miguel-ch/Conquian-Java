/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian.cartas;

/**
 *
 * @author Miguel
 */
public abstract class Carta {

    private int valor;
    private String tipo;

    public Carta(int valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor() {

        /*
        Los numeros 8 y 9 no existen en conquian
        Por lo que al llamar uno mayor a 8 
        Se sumaran 2 para suplir estos espacios en la baraja real
         */
        if (valor >= 8) {
            return valor + 2;
        }
        return valor;
    }

    public int getValorReal() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return getValor() + " - " + tipo + " (" + getValorReal() + ")";
    }
}
