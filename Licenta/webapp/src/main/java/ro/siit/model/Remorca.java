package ro.siit.model;

public class Remorca {
    private String idRemorca;
    private Integer anulFabricatiei;
    private String itp;

    public Remorca(String idRemorca, Integer anulFabricatiei, String itp) {
        this.idRemorca = idRemorca;
        this.anulFabricatiei = anulFabricatiei;
        this.itp = itp;
    }

    public String getIdRemorca() {
        return idRemorca;
    }

    public Integer getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public String getItp() {
        return itp;
    }
}
