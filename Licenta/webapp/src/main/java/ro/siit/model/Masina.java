package ro.siit.model;

public class Masina {
    private String nrInmatriculare;
    private String marca;
    private String anulFabricatiei;
    private String nrInmatriculareRemorca;
    private String itp;
    private String rca;
    private String casco;
    private String rovignieta;

    public Masina(String nrInmatriculare, String marca, String anulFabricatiei, String nrInmatriculareRemorca, String itp, String rca, String casco, String rovignieta) {
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.anulFabricatiei = anulFabricatiei;
        this.nrInmatriculareRemorca = nrInmatriculareRemorca;
        this.itp = itp;
        this.rca = rca;
        this.casco = casco;
        this.rovignieta = rovignieta;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public String getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public String getNrInmatriculareRemorca() {
        return nrInmatriculareRemorca;
    }

    public String getItp() {
        return itp;
    }

    public String getRca() {
        return rca;
    }

    public String getCasco() {
        return casco;
    }

    public String getRovignieta() {
        return rovignieta;
    }
}
