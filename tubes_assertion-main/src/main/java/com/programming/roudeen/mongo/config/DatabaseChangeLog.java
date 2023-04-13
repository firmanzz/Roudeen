package com.programming.techie.mongo.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.programming.techie.mongo.model.Tugas;
import com.programming.techie.mongo.model.CategoryTugas;
import com.programming.techie.mongo.repository.TugasRepository;

import java.util.ArrayList;
import java.util.List;

import static com.programming.techie.mongo.model.CategoryTugas.*;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDatabase", author = "Sai")
    public void seedDatabase(TugasRepository lensaRepository) {
        List<Tugas> TugasList = new ArrayList<>();
        TugasList.add(createNewTugas("Mater", Belum_Selesai, "11/12/2202"));

        lensaRepository.insert(TugasList);
    }

    private Tugas createNewTugas(String nama, CategoryTugas status, String tenggat) {
        Tugas lensa = new Tugas();

        lensa.setNamaTugas(nama);
        lensa.setStatusTugas(status);
        lensa.setTenggat(tenggat);

        return lensa;
    }
}
