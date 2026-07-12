package com.example.GymManagment.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RevenueReportResponse {
    private Long totalMemberships;
    private double averageMonthlyFee, highestMonthlyFee, lowestMonthlyFee, totalMonthlyFee;
}
