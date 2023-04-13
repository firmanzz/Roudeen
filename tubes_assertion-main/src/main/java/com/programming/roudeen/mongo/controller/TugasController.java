package com.programming.techie.mongo.controller;

import com.programming.techie.mongo.model.Tugas;
import com.programming.techie.mongo.service.TugasService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/tugas")
@RequiredArgsConstructor
public class TugasController {

    private final TugasService tugasService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTugas(@ModelAttribute Tugas tugas) {
        tugasService.addTugas(tugas);
        return "redirect:/tugas";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTugas(@ModelAttribute Tugas tugas) {
        tugasService.updateTugas(tugas);
        return "redirect:/tugas";
    }

    @GetMapping
    public String getAllTugas(Model model) {
        List<Tugas> DataTugas = tugasService.getAllTugas();
        model.addAttribute("DataTugas", DataTugas);
        return "tugas/tables";
    }

    @GetMapping("/{namaTugas}")
    public ResponseEntity getTugasByName(@PathVariable String name) {
        return ResponseEntity.ok(tugasService.getTugas(name));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteTugas(@PathVariable String id) {
        tugasService.deleteTugas(id);
        return "redirect:/tugas";

    }

}
