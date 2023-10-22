package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    // http://localhost:9000/sucursal/add
    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> afegir(@RequestBody SucursalDTO sucursal) {
        return sucursalService.afegir(sucursal);
    }

    // http://localhost:9000/sucursal/update
    @PutMapping("/update")
    public ResponseEntity<SucursalDTO> modificar(@RequestBody SucursalDTO sucursal) {
        return sucursalService.modificar(sucursal);
    }

    // http://localhost:9000/sucursal/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SucursalDTO> eliminar(@PathVariable Integer id) {
        return sucursalService.eliminar(id);
    }

    // http://localhost:9000/sucursal/getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> trobarPerId(@PathVariable Integer id) {
        return sucursalService.trobarPerId(id);
    }

    // http://localhost:9000/sucursal/getAll
    @GetMapping("/getAll")
    public List<Sucursal> trobarTots() {
        return sucursalService.trobarTots();
    }

}
