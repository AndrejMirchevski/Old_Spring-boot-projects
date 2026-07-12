package com.example.GymManagment.repository;

import com.example.GymManagment.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MemberShipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findByEndDateBefore(LocalDate date);
}
