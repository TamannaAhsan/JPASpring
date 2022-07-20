package com.example.jpaspring.repository;

import com.example.jpaspring.entity.CourseMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialsRepo extends JpaRepository<CourseMaterials, Integer> {
}
