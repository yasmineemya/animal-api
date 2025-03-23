package edu.uncg.csc340.animal_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PandaService {

    @Autowired
    PandaRepository pandaRepository;

    public List<Panda> getAllPandas() {
        return pandaRepository.findAll();
    }

    public Optional<Panda> getPandaById(int id) {
        return pandaRepository.findById(id);
    }

    public Panda savePanda(Panda panda) {
        return pandaRepository.save(panda);
    }

    public void deletePanda(int id) {
        pandaRepository.deleteById(id);
    }

    public List<Panda> getPandasByType(String type) {
        return pandaRepository.findByType(type);
    }

    public List<Panda> getPandasByName(String name) {
        return pandaRepository.findByNameContaining(name);
    }
}
