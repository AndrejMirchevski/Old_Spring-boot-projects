package com.example.GymManagment.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class MemberResponse {
    private Long id;
    private String fullName;
    private String email;
    private boolean active;
    private List<String> enrolledPrograms;
}
