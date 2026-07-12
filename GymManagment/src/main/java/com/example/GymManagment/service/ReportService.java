package com.example.GymManagment.service;

import com.example.GymManagment.DTO.ProgramStatisticsResponse;
import com.example.GymManagment.DTO.RevenueReportResponse;
import com.example.GymManagment.entity.FitnessProgram;
import com.example.GymManagment.entity.Member;
import com.example.GymManagment.entity.Membership;
import com.example.GymManagment.repository.FitnessProgramRepository;
import com.example.GymManagment.repository.MemberRepository;
import com.example.GymManagment.repository.MemberShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final MemberRepository memberRepository;
    private final MemberShipRepository memberShipRepository;
    private final FitnessProgramRepository fitnessProgramRepository;

    public Member getTopMember(){
        return memberRepository.findAll().stream().max((member1, member2) -> Integer.compare(member1.getFitnessPrograms().size(), member2.getFitnessPrograms().size())).orElse(null);
    }

    public RevenueReportResponse getMembershipRevenue(){
        List<Membership> memberships = memberShipRepository.findAll();

        RevenueReportResponse response = new RevenueReportResponse();

        response.setTotalMemberships( (long) memberships.size());

        response.setAverageMonthlyFee(memberships.stream().mapToDouble(Membership::getMonthlyFee).average().orElse(0));

        response.setHighestMonthlyFee(memberships.stream().mapToDouble(Membership::getMonthlyFee).max().orElse(0));

        response.setLowestMonthlyFee(memberships.stream().mapToDouble(Membership::getMonthlyFee).min().orElse(0));

        response.setTotalMonthlyFee(memberships.stream().mapToDouble(Membership::getMonthlyFee).sum());

        return response;
    }

    public ProgramStatisticsResponse getProgramStatistics() {


        List<FitnessProgram> programs =
                fitnessProgramRepository.findAll();


        ProgramStatisticsResponse response =
                new ProgramStatisticsResponse();



        response.setTotalPrograms(
                programs.size()
        );



        response.setTotalEnrollments(
                programs.stream()
                        .mapToInt(program ->
                                program.getMembers().size())
                        .sum()
        );



        response.setAverageEnrollment(
                programs.stream()
                        .collect(
                                Collectors.averagingInt(
                                        program ->
                                                program.getMembers().size()
                                )
                        )
        );



        FitnessProgram mostPopular =
                programs.stream()
                        .max((program1, program2) ->
                                Integer.compare(
                                        program1.getMembers().size(),
                                        program2.getMembers().size()
                                ))
                        .orElse(null);



        if(mostPopular != null){

            response.setMostPopularProgram(
                    mostPopular.getName()
            );
        }


        return response;
    }
}
