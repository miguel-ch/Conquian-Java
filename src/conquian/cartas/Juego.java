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
public class Juego {
    
    private Juego() {
    }
    
    public static Juego getInstance() {
        return JuegoHolder.INSTANCE;
    }
    
    private static class JuegoHolder {
        private static final Juego INSTANCE = new Juego();
    }
}
