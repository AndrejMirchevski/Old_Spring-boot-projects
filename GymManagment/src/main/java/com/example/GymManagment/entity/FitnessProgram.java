package com.example.GymManagment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FitnessProgram")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FitnessProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name of the fitness program can not be left empty")
    @Column(nullable = false)
    private String name;

    private String description;

    @Positive(message = "Duration can not be negative")
    private int duration;

    @Positive(message = "capacity can not be negative")
    private int capacity;

    @ManyToMany(mappedBy = "fitnessPrograms")
    private List<Member> members = new ArrayList<>();
}
