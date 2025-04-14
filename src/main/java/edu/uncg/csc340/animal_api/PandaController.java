package edu.uncg.csc340.animal_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/pandas")
public class PandaController {

    @Autowired
    private PandaService pandaService;

    @GetMapping("/all")
    public String getAllPandas(Model model) {
        model.addAttribute("pandaList", pandaService.getAllPandas());
        return "panda-list";
    }

    @GetMapping("/{id}")
    public String getPandaById(@PathVariable Long id, Model model) {
        model.addAttribute("panda", pandaService.getPandaById(id));
        return "panda-details";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("panda", new Panda());
        return "panda-create";
    }

    @PostMapping("/new")
    public String createPanda(@ModelAttribute Panda panda) {
        pandaService.createPanda(panda);
        return "redirect:/pandas";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("panda", pandaService.getPandaById(id));
        return "panda-update";
    }

    @PostMapping("/update")
    public String updatePanda(@ModelAttribute Panda panda) {
        pandaService.updatePanda(panda.getId(), panda);
        return "redirect:/pandas";
    }

    @GetMapping("/delete/{id}")
    public String deletePanda(@PathVariable Long id) {
        pandaService.deletePanda(id);
        return "redirect:/pandas";
    }


}
