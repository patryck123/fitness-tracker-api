package com.patryck.fitness.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity @Table(name = "workouts") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Workout {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String userId;
    @Column(nullable = false) private String name;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private WorkoutType type;
    @Column(nullable = false) private Integer durationMinutes;
    private Integer caloriesBurned;
    private LocalDate workoutDate;
    private String notes;
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.EAGER) private List<Exercise> exercises;
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); if (workoutDate == null) workoutDate = LocalDate.now(); }
}
