package com.example.jpapractice.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Guardian {

    private String guardianName;
    private String guardianEmail;
}
