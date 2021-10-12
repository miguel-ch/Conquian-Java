/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conquian.cartas.factory;

import conquian.cartas.Carta;
import java.util.List;

/**
 *
 * @author Miguel
 */
public interface CartaFactory {
    public List<Carta> crearJuegoCartas();
}
