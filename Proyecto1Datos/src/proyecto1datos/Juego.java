package proyecto1datos;

public class Juego {

    public Juego(int cantjug, int maxcart) {
        this.tombola = new Tombola();
        this.players = new Participantes(cantjug, maxcart);
    }
    
    
    private final Tombola tombola;
    private final Participantes players;
}
