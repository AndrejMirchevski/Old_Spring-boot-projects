package com.example.GymManagment.controller;

import com.example.GymManagment.entity.Membership;
import com.example.GymManagment.service.MemberService;
import com.example.GymManagment.service.MemberShipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberships")
@RequiredArgsConstructor

public class MembershipController {
    private final MemberShipService memberShipService;

    @GetMapping
    public List<Membership> getAllMemberships() {
        return memberShipService.getAllMemberships();
    }

    @GetMapping("/{id}")
    public Membership getMembershipById(@PathVariable Long id) {
        return memberShipService.getMembershipById(id);
    }

    @PostMapping("member/{memberId}")
    public Membership createMembership(@PathVariable Long memberId, @Valid @RequestBody Membership membership){
        return memberShipService.createMembership(memberId, membership);
    }

    @PutMapping("/{id}")
    public Membership updateMembership(@PathVariable Long id, @Valid @RequestBody Membership membership){
        return memberShipService.updateMembership(id, membership);
    }

    @DeleteMapping("/{id}")
    public void deleteMembership(@PathVariable Long id){
        memberShipService.deleteMemberShip(id);
    }

    @GetMapping("/expired")
    public List<Membership> expiredMemberships(){
        return memberShipService.getExpiredMemberships();
    }
}
