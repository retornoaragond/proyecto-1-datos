/*
    Integrantes:
        Esteban Espinoza Fallas 402290345
        Alejandro Navarro Valverde 116070118
*/

package proyecto1datos;

public class Juego {

    public Juego(int maxcart, int cantjug) {
        this.maxcart = maxcart;
        this.cantjug = cantjug;
        this.tombola = new Tombola();
        this.players = new Participantes(cantjug, maxcart);
    }

    public void jugar(String game) {
        ToHTML html = new ToHTML();
        html.parametros(cantjug, maxcart, game);
        int numero ; 
        int round = 0;
        while (!isWinner) {
            round++;
            numero = tombola.getbolita();
            System.out.printf("Numero de la tombola: %d\n",numero);
            for (Jugador j : players.getPlayers()) {
                for (Carton c : j.getCartones()) {
                    if (c.isIn(numero)) {
                        c.cambiaX(numero);
                    }
                    tipojuego(game, c, j.getNumero());
                }
                System.out.println(j.toString());
            }
            html.ronda(round,tombola, players);  
        }
        html.ganador(winner);
        System.out.println("ganador fue:"+winner);
        html.end();
        html.toHTML();
    }

    public void tipojuego(String game, Carton c, int n) {
        switch (game) {
            case "(1)Linea Completa":
                checkLinea(c, n);
                break;
            case "(2)Diagonal":
                checkDiag(c, n);
                break;
            case "(3)'C'":
                CheckC(c, n);
                break;
            case "(4)'X'":
                CheckX(c, n);
                break;
            case "(5)'U'":
                CheckU(c, n);
                break;
            case "(6)'O'":
                CheckO(c, n);
                break;
            case "(7)BINGO":
                CheckBINGO(c, n);
                break;
        }
    }

    public void checkLinea(Carton c, int n) {
        for (int k = 0; k < 5; k++) {
            if (Vertical(k, c)) {
                if (!isWinner) {
                    isWinner = true;
                    if (winner == -1) {
                        winner = n;
                    }
                    break;
                }
            }
            if (Horizontal(k, c)) {
                if (!isWinner) {
                    isWinner = true;
                    if (winner == -1) {
                        winner = n;
                    }
                    break;
                }
            }
        }
    }

    public boolean Vertical(int i, Carton c) {
        for (int k = 0; k < 5; k++) {
            if (!c.getCarton().get(i).get(k).equals("X")) {
                return false;
            }
        }
        return true;
    }

    public boolean VerticalRec(int i, int k, Carton c) {
        if (c.getCarton().get(i).get(k) == null) {
            return true;
        } else if (!c.getCarton().get(i).get(k).equals("X")) {
            return false;
        }
        return true && VerticalRec(i, k++, c);
    }

    public boolean Horizontal(int j, Carton c) {
        for (int k = 0; k < 5; k++) {
            if (!c.getCarton().get(k).get(j).equals("X")) {
                return false;
            }
        }
        return true;
    }

    public void checkDiag(Carton c, int n) {
        if (diagonalR(c)) {
            if (!isWinner) {
                isWinner = true;
                if (winner == -1) {
                    winner = n;
                }
            }
        }
        if (diagonalL(c)) {
            if (!isWinner) {
                isWinner = true;
                if (winner == -1) {
                    winner = n;
                }
            }
        }
    }

    public boolean diagonalR(Carton c) {
        for (int k = 0; k < 5; k++) {
            if (!c.getCarton().get(k).get(k).equals("X")) {
                return false;
            }
        }
        return true;
    }

    public boolean diagonalL(Carton c) {
        for (int k = 4, j = 0; k >= 0 && j < 5; k--, j++) {
            if (!c.getCarton().get(j).get(k).equals("X")) {
                return false;
            }
        }
        return true;
    }

    public void CheckC(Carton c, int n) {
        if (Vertical(0, c) && Horizontal(0, c) && Horizontal(4, c)) {
            if (!isWinner) {
                isWinner = true;
                if (winner == -1) {
                    winner = n;
                }
            }
        }
    }

    public void CheckX(Carton c, int n) {
        if (diagonalL(c) && diagonalR(c)) {
            if (!isWinner) {
                isWinner = true;
                if (winner == -1) {
                    winner = n;
                }
            }
        }
    }

    public void CheckU(Carton c, int n) {
        if (Vertical(0, c) && Vertical(4, c) && Horizontal(4, c)) {
            if (!isWinner) {
                isWinner = true;
                if (winner == -1) {
                    winner = n;
                }
            }
        }
    }

    public void CheckO(Carton c, int n) {
        if (Vertical(0, c) && Vertical(4, c) && Horizontal(4, c)
                && Horizontal(0, c)) {
            if (!isWinner) {
                isWinner = true;
                if (winner == -1) {
                    winner = n;
                }
            }
        }
    }

    public void CheckBINGO(Carton c, int n) {
        if (comprueba(c)) {
            if (!isWinner) {
                isWinner = true;
                if (winner == -1) {
                    winner = n;
                }
            }
        }
    }

    public boolean comprueba(Carton c) {
        for (int i = 0; i < 5; i++) {
            if (Vertical(i, c) != true) {
                return false;
            }
        }
        return true;
    }

    private int winner = -1;
    private boolean isWinner;
    private final int maxcart;
    private final int cantjug;
    private final Tombola tombola;
    private final Participantes players;
}
