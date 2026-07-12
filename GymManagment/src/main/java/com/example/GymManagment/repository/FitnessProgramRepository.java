package com.example.GymManagment.repository;

import com.example.GymManagment.entity.FitnessProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessProgramRepository extends JpaRepository<FitnessProgram, Long> {
}
