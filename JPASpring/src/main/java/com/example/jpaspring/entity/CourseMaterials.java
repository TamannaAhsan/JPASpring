package com.example.jpaspring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="coursematerials")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  optional = false)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"

    )
    private Course course;

}
