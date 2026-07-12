package com.example.GymManagment.service;

import com.example.GymManagment.entity.FitnessProgram;
import com.example.GymManagment.exception.ResourceNotFoundException;
import com.example.GymManagment.repository.FitnessProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FitnessProgramService {
    private final FitnessProgramRepository fitnessProgramRepository;

    public List<FitnessProgram> getAllFitnessPrograms() {
        return fitnessProgramRepository.findAll();
    }

    public FitnessProgram getFitnessProgramById(Long id) {
        return fitnessProgramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("program by id" + id + " is not present"));
    }

    public FitnessProgram createFitnessProgram(FitnessProgram program) {
        if (program.getCapacity() <= 0) {
            throw new IllegalStateException("capacity must be more then 0 people");
        }

        if (program.getDuration() <= 0) {
            throw new IllegalStateException("duration must be more then 0 weeks");
        }

        return fitnessProgramRepository.save(program);
    }

    public FitnessProgram updateFitnessProgram(FitnessProgram program, Long fitnessProgramId) {
        FitnessProgram fitnessProgram = getFitnessProgramById(fitnessProgramId);

        fitnessProgram.setDescription(fitnessProgram.getDescription());
        fitnessProgram.setName(fitnessProgram.getName());
        fitnessProgram.setCapacity(fitnessProgram.getCapacity());
        fitnessProgram.setDuration(fitnessProgram.getDuration());

        return fitnessProgramRepository.save(fitnessProgram);
    }

    public void deleteFitnessProgram(Long id) {
        fitnessProgramRepository.deleteById(id);
    }

    public int getEnrollmentCount(Long programId){
        FitnessProgram program = getFitnessProgramById(programId);

        return program.getMembers().size();
    }


}

