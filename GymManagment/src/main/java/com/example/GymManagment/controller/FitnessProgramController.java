package com.example.GymManagment.controller;

import com.example.GymManagment.entity.FitnessProgram;
import com.example.GymManagment.service.FitnessProgramService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programs")
@RequiredArgsConstructor
public class FitnessProgramController {
    private final FitnessProgramService fitnessProgramService;

    @GetMapping
    public List<FitnessProgram> getPrograms(){
        return fitnessProgramService.getAllFitnessPrograms();
    }

    @GetMapping("/{id}")
    public FitnessProgram getFitnessProgramById(@PathVariable Long id){
        return fitnessProgramService.getFitnessProgramById(id);
    }

    @PostMapping
    public FitnessProgram postProgram(@Valid @RequestBody FitnessProgram program){
        return fitnessProgramService.createFitnessProgram(program);
    }

    @PutMapping("/{id}")
    public FitnessProgram updateProgram(@PathVariable Long id, @Valid @RequestBody FitnessProgram program){
        return fitnessProgramService.updateFitnessProgram(program, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProgram(@PathVariable Long id){
        fitnessProgramService.deleteFitnessProgram(id);
    }

    @GetMapping("/{id}/enrollment-count")
    public int getEnrollmentCount(@PathVariable Long id){
        return fitnessProgramService.getEnrollmentCount(id);
    }
}
