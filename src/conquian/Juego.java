/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian;

import conquian.jugadores.PackTres;
import conquian.cartas.Carta;
import conquian.jugadores.Jugador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class Juego {

    Baraja baraja = new Baraja();

    Jugador jug1, jug2;

    //Jugador en turno
    Jugador enTurno;

    //Carta en muestra
    Carta enMuestra;

    public void iniciar() {
        baraja.revolver();
        repartir();
        intercambio();
        iniciaJuego();
    }

    public void repartir() {

        List<Carta> tmpCartas1 = new ArrayList<>();
        List<Carta> tmpCartas2 = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            tmpCartas1.add(baraja.tomarUna());
            tmpCartas2.add(baraja.tomarUna());
        }

        Mazo m1 = new Mazo(tmpCartas1);
        Mazo m2 = new Mazo(tmpCartas2);

        jug1 = new Jugador(m1, "Jugador 1");
        jug2 = new Jugador(m2, "Jugador 2");

        enTurno = jug1;

        /*
        System.out.println(jug1);
        System.out.println(jug2);*/
    }

    public void intercambio() {
        Carta cartaJug1;
        Carta cartaJug2;

        System.out.println("INTERCAMBIO DE CARTAS");

        cartaJug1 = pedirCarta();
        cambiarTurno();
        cartaJug2 = pedirCarta();

        System.out.println("CARTA JUG 1: " + cartaJug1);
        System.out.println("CARTA JUG 2: " + cartaJug2);

        //Intercambio
        jug1.getMazo().cambiarCarta(cartaJug1, cartaJug2);
        jug2.getMazo().cambiarCarta(cartaJug2, cartaJug1);
    }

    ///////////////
    public Carta pedirCarta() {

        Mazo m = enTurno.getMazo();

        System.out.println("[" + enTurno.getNombre() + "] - Elija una carta: ");
        System.out.println(m);

        //a
        int entrada = -1;
        Scanner in = new Scanner(System.in);
        do {
            try {
                entrada = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
            }
        } while (entrada < 0 || entrada >= 8);

        //
        return m.getCarta(entrada);
    }

    public void cambiarTurno() {

        if (enTurno == jug1) {
            enTurno = jug2;
        } else {
            enTurno = jug1;
        }
    }

    ////BARAJA
    boolean tomoDeBaraja = false;
    //////

    public void iniciaJuego() {
        Jugador ganador = null;

        if (enMuestra == null) {
            enMuestra = baraja.tomarUna();
        }

        while (ganador == null || baraja.cantidadCartas() > 0) {

            System.out.println(baraja);
            System.out.println(jug1);
            System.out.println(jug2);

            //Cambio turno
            cambiarTurno();

            System.out.println("\n\nEN TURNO:::: " + enTurno.getNombre());

            //Reinicia
            tomoDeBaraja = false;
            //Carta en muestra
            mostrarCartas();
        }
    }

    public void mostrarCartas() {

        System.out.println("\n\nEN TURNO:::: " + enTurno.getNombre());
        System.out.println("La carta en juego es: " + enMuestra);
        System.out.println("1) No me sirve");
        System.out.println("2) Armar triada");

        //ENTRADA CARTA
        int entrada = 0;
        Scanner in = new Scanner(System.in);
        do {
            try {
                entrada = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
            }
        } while (entrada <= 0 && entrada > 2);
        //////

        if (entrada == 2) {
            if (armaTriada()) {
                //Saca la carta para muestra
                Carta cartaMuestra = pedirCarta();
                enMuestra = cartaMuestra;
                enTurno.getMazo().tirar(cartaMuestra);
            } else {
                System.out.println("\nLAS 3 NO SON VALIDAS\n");
                mostrarCartas();
            }

        } else if (!tomoDeBaraja) {
            enMuestra = baraja.tomarUna();
            tomoDeBaraja = true;
            mostrarCartas();
        }
    }

    ////Arma triada y valida
    public boolean armaTriada() {

        //Toma cartas para triada
        Carta c1 = enMuestra;
        System.out.println("Seleccione la 2da carta");
        Carta c2 = pedirCarta();
        System.out.println("Seleccione la 3ra carta");
        Carta c3 = pedirCarta();

        PackTres pack = new PackTres(c1, c2, c3);
        if (pack.validar()) {
            //Desecha cartas
            enTurno.getMazo().tirar(c2);
            enTurno.getMazo().tirar(c3);
        }

        return pack.validar();

    }
}
