package com.programming.techie.mongo.service;

import com.programming.techie.mongo.model.Tugas;
import com.programming.techie.mongo.repository.TugasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TugasService {

    private final TugasRepository tugasRepository;

    public void addTugas(Tugas tugas) {
        tugasRepository.insert(tugas);
    }

    public void updateTugas(Tugas tugas) {
        Tugas savedtugas = tugasRepository.findById(tugas.getId()).orElseThrow(
                () -> new RuntimeException(String.format("Cannot Find tugas by ID %s", tugas.getId())));
        savedtugas.setNamaTugas(tugas.getNamaTugas());
        savedtugas.setStatusTugas(tugas.getStatusTugas());
        savedtugas.setTenggat(tugas.getTenggat());

        tugasRepository.save(tugas);
    }

    public Tugas getTugas(String name) {
        return tugasRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find tugas by Name - %s", name)));
    }

    public List<Tugas> getAllTugas() {
        return tugasRepository.findAll();
    }

    public void deleteTugas(String id) {
        tugasRepository.deleteById(id);
    }
}
