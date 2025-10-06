package ar.edu.unlam.dominio;

public class PagoEfectivo implements Promocion {

    private Double recargo;

    public PagoEfectivo(Double recargo) {
        this.recargo = recargo;
    }

    @Override
    public Double aplicar(Double precio) {
        return precio * (1 - recargo / 100);
    }
}
