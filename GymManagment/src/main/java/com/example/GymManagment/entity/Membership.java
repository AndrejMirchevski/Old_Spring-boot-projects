package com.example.GymManagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "MemberShip")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate, endDate;
    private double monthlyFee;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
