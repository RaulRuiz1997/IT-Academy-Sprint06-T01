package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.dto;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.domain.Sucursal;

import java.util.List;

public class SucursalDTO extends Sucursal {

    private String tipusSucursal;
    private List<String> països;

    public SucursalDTO(String nomSucursal, String paisSucursal, String tipusSucursal, List<String> països) {
        super(nomSucursal, paisSucursal);
        this.tipusSucursal = tipusSucursal;
        this.països = països;
    }

    public SucursalDTO() {
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    public List<String> getPaïsos() {
        return països;
    }

    public void setPaïsos(List<String> països) {
        this.països = països;
    }

    @Override
    public String toString() {
        return "SucursalDTO{" +
                "tipusSucursal='" + tipusSucursal + '\'' +
                ", països=" + països +
                '}';
    }

}
