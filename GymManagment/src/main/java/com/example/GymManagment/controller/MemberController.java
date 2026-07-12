package com.example.GymManagment.controller;

import com.example.GymManagment.DTO.CreateMemberRequest;
import com.example.GymManagment.entity.Member;
import com.example.GymManagment.entity.Membership;
import com.example.GymManagment.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member createMember(@Valid @RequestBody CreateMemberRequest request){
        return memberService.createMember(request);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member){
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

    @PostMapping("/{memberId}/programs/{programId}")
    public Member enrollMemberToProgram(@PathVariable Long memberId, @PathVariable Long programId){
        return memberService.enrollMemberToFitnessProgram(memberId, programId);
    }

    @DeleteMapping("/{memberId}/programs/{programId}")
    public void deleteMemberFromProgram(@PathVariable Long memberId, @PathVariable Long programId){
        memberService.removeMemberFromProgram(memberId, programId);
    }

    @GetMapping("/{id}/memberships")
    public List<Membership> getMemberMemberships(@PathVariable Long id){
        return memberService.getMemberMemberShips(id).getMemberships();
    }
}
