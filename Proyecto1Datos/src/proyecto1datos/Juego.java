package proyecto1datos;

public class Juego {

    public Juego(int maxcart, int cantjug) {
        this.maxcart = maxcart;
        this.cantjug = cantjug;
        this.tombola = new Tombola();
        this.players = new Participantes(cantjug, maxcart);
    }

    public void jugar(String game) {
        ToHTML html = new ToHTML("");
        html.parametros(cantjug, maxcart, game);
        int numero = tombola.getbolita();
        while (isWinner) {
            for (Jugador j : players.getPlayers()) {
                for (Carton c : j.getCartones()) {
                    if (c.isIn(numero)) {
                        c.cambiaX(numero);
                    }
                }
            }
            html.ronda(tombola, players);

        }
        html.ganador(winner);
        html.toHTML();
    }

    public void tipojuego(String game) {
        switch (game) {
            case "(1)Linea Completa":
                break;
            case "(2)Diagonal":
                break;
            case "(3)'C'":
                break;
            case "(4)'X'":
                break;
            case "(5)'U'":
                break;
            case "(7)'O'":
                break;
            case "(8)BINGO":
                break;
        }
    }

    private int winner;
    private boolean isWinner;
    private final int maxcart;
    private final int cantjug;
    private final Tombola tombola;
    private final Participantes players;
}
