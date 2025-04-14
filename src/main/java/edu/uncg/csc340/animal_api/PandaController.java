package edu.uncg.csc340.animal_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pandas")
public class PandaController {

    @Autowired
    PandaService pandaService;

    @GetMapping("/all")
    public String getAllPandas(Model model) {
        model.addAttribute("pandaList", pandaService.getAllPandas());
        return "panda-list";
    }

    @GetMapping("/{id}")
    public String getPandaById(@PathVariable int id, Model model) {
        model.addAttribute("panda", pandaService.getPandaById(id).orElse(null));
        return "panda-details";
    }

    @GetMapping("/new-form")
    public String createPandaForm(Model model) {
        model.addAttribute("panda", new Panda());
        return "panda-create";
    }

    @PostMapping("/new")
    public String savePanda(@ModelAttribute Panda panda) {
        System.out.println("🧾 RECEIVED PANDA FROM FORM: " + panda);
        pandaService.savePanda(panda);
        return "redirect:/pandas/all";
    }

    @GetMapping("/update-form/{id}")
    public String updatePandaForm(@PathVariable int id, Model model) {
        model.addAttribute("panda", pandaService.getPandaById(id).orElse(null));
        return "panda-update";
    }

    @PostMapping("/update")
    public String updatePanda(@ModelAttribute Panda panda) {
        pandaService.savePanda(panda);  // same as update
        return "redirect:/pandas/" + panda.getId();
    }

    @GetMapping("/delete/{id}")
    public String deletePanda(@PathVariable int id) {
        pandaService.deletePanda(id);
        return "redirect:/pandas/all";
    }

    //Extra Credit
    @GetMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        model.addAttribute("pandaList", pandaService.getPandasByName(name));
        return "panda-list";
    }
}