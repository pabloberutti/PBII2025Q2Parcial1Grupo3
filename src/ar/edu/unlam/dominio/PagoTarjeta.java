package ar.edu.unlam.dominio;

public class PagoTarjeta implements Promocion {

    private Double recargo;

    public PagoTarjeta(Double recargo) {
        this.recargo = recargo;
    }

    @Override
    public Double aplicar(Double precio) {
        return precio * (1 - recargo / 100);
    }
}
