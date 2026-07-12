package com.example.GymManagment.service;

import com.example.GymManagment.DTO.CreateMemberRequest;
import com.example.GymManagment.entity.FitnessProgram;
import com.example.GymManagment.entity.Member;
import com.example.GymManagment.exception.ResourceNotFoundException;
import com.example.GymManagment.repository.FitnessProgramRepository;
import com.example.GymManagment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final FitnessProgramRepository fitnessProgramRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member by id" + id + " is not found"));
    }

    public Member createMember(CreateMemberRequest request){
        if(memberRepository.findByEmail(request.getEmail()).isPresent()){
            throw new IllegalStateException("Email already exists");
        }

        Member member = new Member();
        member.setFirstName(request.getFirstName());
        member.setLastName(request.getFirstName());
        member.setEmail(request.getEmail());
        member.setActive(member.isActive());

        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember){
        Member member = getMemberById(id);

        member.setFirstName(updatedMember.getFirstName());
        member.setLastName(updatedMember.getLastName());
        member.setEmail(updatedMember.getEmail());
        member.setActive(updatedMember.isActive());

        return memberRepository.save(member);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

    public Member enrollMemberToFitnessProgram(Long memberId, Long fitnessProgramId){
        Member member = getMemberById(memberId);
        if(!member.isActive()){
            throw  new IllegalStateException("Inactive members can not enroll in programs");
        }

        FitnessProgram fitnessProgram = fitnessProgramRepository.findById(fitnessProgramId).orElseThrow(() -> new ResourceNotFoundException("Program by id" + fitnessProgramId + " is not found"));

        if(fitnessProgram.getMembers().size() >= fitnessProgram.getCapacity()){
            throw new IllegalStateException("capacity is already at max, can not add");
        }

        member.getFitnessPrograms().add(fitnessProgram);

        return memberRepository.save(member);
    }

    public Member removeMemberFromProgram(Long memberId, Long fitnessProgramId){
        Member member = getMemberById(memberId);

        member.getFitnessPrograms().removeIf(program -> program.getId().equals(fitnessProgramId));

        return memberRepository.save(member);
    }

    public Member getMemberMemberShips(Long memberId){
        Member member = getMemberById(memberId);

        return (Member) member.getMemberships();
    }
}
