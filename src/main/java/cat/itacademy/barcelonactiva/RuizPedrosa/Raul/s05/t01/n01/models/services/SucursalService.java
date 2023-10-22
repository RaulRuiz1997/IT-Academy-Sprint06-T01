package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.services;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;
    public ResponseEntity<SucursalDTO> afegir(SucursalDTO sucursal) {
        return new ResponseEntity<>(sucursalRepository.save(sucursal), HttpStatus.OK);
    }

    public ResponseEntity<SucursalDTO> modificar(SucursalDTO sucursal) {

        Sucursal sucursalBBDD = sucursalRepository.findById(sucursal.getPk_SucursalID()).get();
        SucursalDTO sucursalDTOModificada = new SucursalDTO();

        if (sucursalBBDD.getNomSucursal() != null || !sucursalBBDD.getNomSucursal().isEmpty()) {
            sucursalDTOModificada.setNomSucursal(sucursal.getNomSucursal());
        }

        if (sucursalBBDD.getPaisSucursal() != null || !sucursalBBDD.getPaisSucursal().isEmpty()) {
            sucursalDTOModificada.setPaisSucursal(sucursal.getPaisSucursal());
        }

        return new ResponseEntity<>(sucursalRepository.save(sucursalDTOModificada), HttpStatus.OK);

    }

    public ResponseEntity<SucursalDTO> eliminar(Integer id) {

        Sucursal sucursalBorrada = null;

        if (sucursalRepository.findById(id).isPresent()) {
            sucursalBorrada = sucursalRepository.findById(id).get();
        }

        sucursalRepository.deleteById(id);

        return new ResponseEntity<>((SucursalDTO) sucursalBorrada, HttpStatus.OK);
    }

    public ResponseEntity<SucursalDTO> trobarPerId(Integer id) {

        if (sucursalRepository.findById(id).isPresent()) {

            return new ResponseEntity<>((SucursalDTO) sucursalRepository.findById(id).get(), HttpStatus.OK);

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID no trobat");

        }

    }

    public List<Sucursal> trobarTots() {
        return sucursalRepository.findAll();
    }
}
