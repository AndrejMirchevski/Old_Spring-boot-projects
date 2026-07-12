package com.example.GymManagment.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProgramStatisticsResponse {
    private long totalPrograms;

    private long totalEnrollments;

    private double averageEnrollment;

    private String mostPopularProgram;
}
