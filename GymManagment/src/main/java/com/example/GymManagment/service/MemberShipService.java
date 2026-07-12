package com.example.GymManagment.service;

import com.example.GymManagment.entity.Member;
import com.example.GymManagment.entity.Membership;
import com.example.GymManagment.exception.ResourceNotFoundException;
import com.example.GymManagment.repository.MemberRepository;
import com.example.GymManagment.repository.MemberShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberShipService {
    private final MemberShipRepository memberShipRepository;
    private final MemberRepository memberRepository;

    public List<Membership> getAllMemberships(){
        return memberShipRepository.findAll();
    }

    public Membership getMembershipById(Long id){
        return memberShipRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("missing membership by id " + id));
    }

    public Membership createMembership(Long memberId, Membership membership){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member not found"));

        validateMembership(membership);

        membership.setMember(member);

        return memberShipRepository.save(membership);
    }

    public Membership updateMembership(Long membershipId, Membership updatedMembership){
        Membership membership = getMembershipById(membershipId);

        validateMembership(updatedMembership);

        membership.setStartDate(updatedMembership.getStartDate());
        membership.setEndDate(updatedMembership.getEndDate());
        membership.setMonthlyFee(updatedMembership.getMonthlyFee());

        return memberShipRepository.save(membership);
    }

    public void deleteMemberShip(Long id){
        memberShipRepository.deleteById(id);
    }

    public List<Membership> getExpiredMemberships(){
        return memberShipRepository.findByEndDateBefore(LocalDate.now());
    }



    private void validateMembership(Membership membership) {


        if(membership.getMonthlyFee() <= 0) {

            throw new IllegalStateException(
                    "Monthly fee must be positive");
        }


        if(!membership.getEndDate()
                .isAfter(membership.getStartDate())) {

            throw new IllegalStateException(
                    "End date must be after start date");
        }
    }
}
