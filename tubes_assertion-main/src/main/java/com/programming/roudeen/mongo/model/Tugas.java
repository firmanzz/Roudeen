package com.programming.techie.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("DaftarTugas")
public class Tugas {
    @Id
  private String id;
  @Field("namaTugas")
  private String namaTugas;
  @Field("statusTugas")
  private CategoryTugas statusTugas;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private String tenggat;
  private boolean published;
}
