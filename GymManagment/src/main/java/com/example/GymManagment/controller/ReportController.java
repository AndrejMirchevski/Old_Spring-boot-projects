package com.example.GymManagment.controller;

import com.example.GymManagment.DTO.ProgramStatisticsResponse;
import com.example.GymManagment.DTO.RevenueReportResponse;
import com.example.GymManagment.entity.Member;
import com.example.GymManagment.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor

public class ReportController {
    private final ReportService reportService;

    @GetMapping("/top-member")
    public Member getTopMember(){
        return reportService.getTopMember();
    }

    @GetMapping("/membership-revenue")
    public RevenueReportResponse getMembershipRevenue(){
        return reportService.getMembershipRevenue();
    }

    @GetMapping("/program-statistics")
    public ProgramStatisticsResponse getProgramStatistics(){
        return reportService.getProgramStatistics();
    }
}
