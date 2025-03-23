package edu.uncg.csc340.animal_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pandas")
public class PandaController {

    @Autowired
    PandaService pandaService;

    @GetMapping
    public List<Panda> getAllPandas() {
        return pandaService.getAllPandas();
    }

    @GetMapping("/{id}")
    public Optional<Panda> getPandaById(@PathVariable int id) {
        return pandaService.getPandaById(id);
    }

    @PostMapping
    public Panda savePanda(@RequestBody Panda panda) {
        return pandaService.savePanda(panda);
    }

    @PutMapping
    public Panda updatePanda(@RequestBody Panda panda) {
        return pandaService.savePanda(panda);
    }

    @DeleteMapping("/{id}")
    public void deletePanda(@PathVariable int id) {
        pandaService.deletePanda(id);
    }

    @GetMapping("/type/{type}")
    public List<Panda> getPandasByType(@PathVariable String type) {
        return pandaService.getPandasByType(type);
    }

    @GetMapping("/search")
    public List<Panda> searchByName(@RequestParam String name) {
        return pandaService.getPandasByName(name);
    }
}
