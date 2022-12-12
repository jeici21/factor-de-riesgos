package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Paciente;
import com.example.demo.repository.PacienteRepository;

@Controller
public class FrontEndController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("paciente", new Paciente());
        return "home";
    }

    @GetMapping("/lista")
    public String mostrar(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "lista";
    }

    @PostMapping("/")
    public String guardar(@ModelAttribute Paciente paciente, RedirectAttributes redirectAttributes) {
        pacienteRepository.save(paciente);
        redirectAttributes.addFlashAttribute("mensaje", "Agregado correctamente").addFlashAttribute("clase", "success");
        return "redirect:/";
    }
}
