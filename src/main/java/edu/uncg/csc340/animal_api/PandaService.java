package edu.uncg.csc340.animal_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PandaService {

    @Autowired
    private PandaRepository pandaRepository;
    private Panda updatedPanda;

    public List<Panda> getAllPandas() {

        return pandaRepository.findAll();
    }

    public Panda getPandaById(Long id) {
        return pandaRepository.findById(id).orElse(null);
    }

    public Panda savePanda(Panda panda) {

        return pandaRepository.save(panda);
    }

    public void deletePanda(Long id) {

        pandaRepository.deleteById(id);
    }

    public List<Panda> getPandaByType(String type) {

        return pandaRepository.findByType(type);
    }

    public List<Panda> getPandaByName(String name) {

        return pandaRepository.findByNameContaining(name);
    }

    public void createPanda(Panda panda) {
        pandaRepository.save(panda);
    }


    public void updatePanda(Long id, Panda updatedPanda) {
        Panda panda = getPandaById(id);
        if (panda != null) {
            panda.setName(updatedPanda.getName());
            panda.setType(updatedPanda.getType());
            panda.setDescription(updatedPanda.getDescription());
            pandaRepository.save(panda);
        }
    }


}
