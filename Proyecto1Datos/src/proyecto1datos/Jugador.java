package proyecto1datos;

import java.util.ArrayList;

public class Jugador {

    public Jugador(ArrayList<Carton> c, int n) {
        this.cartones = c;
        this.numero = n;
    }

    public ArrayList<Carton> getCartones() {
        return cartones;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Jugador #" + numero + "\nCartones ={\n" + cartones.toString() + "}\n";
//        return "Jugador{\n" + "cartones=" + cartones.toString() + ", #" + numero + "}\n";
    }

    private final ArrayList<Carton> cartones;
    private final int numero;
}
