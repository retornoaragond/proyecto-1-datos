package proyecto1datos;

public class ToHTML {
    /*NOTA IMPORTANTE: generado es el string con las el output que va a ir en el archivo
                        pero se debe guardar hasta que ya haya un ganador para asi ir
                        generandolo conforme se va generando cada ronda
    */
    public ToHTML(String generado) {
        this.generado = generado;
    }

    public void parametros(int usuarios, int maxcart, String tipojuego) {
        //genera los parametros iniciales
    }

    public void ronda(Tombola tombola, Participantes jugadores) {
        //genera los la ronda con la "pila _bolitas" y con cada jugador(llamar al metodo carton que imprima los cartones
    }

    public void carton(Carton c) {
        //genera el carton indicado
    }
    
    public void ganador(int i){
        //genera el ganador y cierra el body
    }
    
    public void toHTML(){
        //crea el archivo le escribe el generardo y lo guarda en la ruta especificada
    }

    public String getGenerado() {
        return generado;
    }

    private final String generado;

}
