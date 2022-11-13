public class TipoSituacaoMesa {
   private String livre;
    private String ocupada;
    private String reservada;

    public TipoSituacaoMesa(final String livre,
                            final String ocupada,
                            final String reservada) {
        this.livre = livre;
        this.ocupada = ocupada;
        this.reservada = reservada;
    }

    public String getLivre() {
        return livre;
    }

    public void setLivre(String livre) {
        this.livre = livre;
    }

    public String getOcupada() {
        return ocupada;
    }

    public void setOcupada(String ocupada) {
        this.ocupada = ocupada;
    }

    public String getReservada() {
        return reservada;
    }

    public void setReservada(String reservada) {
        this.reservada = reservada;
    }
}
