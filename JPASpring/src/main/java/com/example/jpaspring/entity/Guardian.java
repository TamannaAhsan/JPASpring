package com.example.jpaspring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardia_mobile")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),

})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
