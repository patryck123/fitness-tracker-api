package com.patryck.fitness.repository;
import com.patryck.fitness.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUserId(String userId);
    List<Workout> findByUserIdAndType(String userId, WorkoutType type);
    List<Workout> findByUserIdAndWorkoutDateBetween(String userId, LocalDate from, LocalDate to);
    @Query("SELECT COALESCE(SUM(w.caloriesBurned),0) FROM Workout w WHERE w.userId=:uid AND w.workoutDate BETWEEN :from AND :to")
    Integer totalCalories(@Param("uid") String uid, @Param("from") LocalDate from, @Param("to") LocalDate to);
}
