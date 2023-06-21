package com.example.Recipe.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "Instruction")
public class Instruction {

    @Id
    @GeneratedValue // auto increment
    private Long id;
    private String step;
    private String instruction;

}
