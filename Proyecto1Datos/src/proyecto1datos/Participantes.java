/*
    Integrantes:
        Esteban Espinoza Fallas 402290345
        Alejandro Navarro Valverde 116070118
*/

package proyecto1datos;

import java.util.ArrayList;
import java.util.Random;

public class Participantes {

    public Participantes(int c, int nc) {
        this.players = generaJ(c, nc);
    }

    public final ArrayList<Jugador> generaJ(int c, int nc) {
        ArrayList<Jugador> play = new ArrayList<>();
        Random rand = new Random();
        int n;
        for (int i = 0; i < c; i++) {
            n = rand.nextInt(nc) + 1;
            ArrayList<Carton> cartones = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cartones.add(new Carton());
            }
            play.add(new Jugador(cartones, i+1));
            System.out.println(play.toString());
        }
        return play;
    }

    public ArrayList<Jugador> getPlayers() {
        return players;
    }

    private final ArrayList<Jugador> players;
}
