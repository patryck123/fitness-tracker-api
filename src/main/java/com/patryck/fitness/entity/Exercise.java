package com.patryck.fitness.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "exercises") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Exercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "workout_id") private Workout workout;
    @Column(nullable = false) private String name;
    private Integer sets;
    private Integer reps;
    private Double weight;
    private Integer durationSeconds;
    private String muscleGroup;
}
