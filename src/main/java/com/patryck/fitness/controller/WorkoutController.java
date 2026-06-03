package com.patryck.fitness.controller;
import com.patryck.fitness.entity.*;
import com.patryck.fitness.repository.WorkoutRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@RestController @RequestMapping("/api/workouts") @RequiredArgsConstructor
@Tag(name = "Fitness Tracker", description = "Rastreamento de treinos e exercícios")
public class WorkoutController {
    private final WorkoutRepository repo;
    @PostMapping public ResponseEntity<Workout> create(@RequestBody Workout w) { return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(w)); }
    @GetMapping("/user/{userId}") public ResponseEntity<List<Workout>> byUser(@PathVariable String userId) { return ResponseEntity.ok(repo.findByUserId(userId)); }
    @GetMapping("/user/{userId}/type/{type}") public ResponseEntity<List<Workout>> byType(@PathVariable String userId, @PathVariable WorkoutType type) { return ResponseEntity.ok(repo.findByUserIdAndType(userId, type)); }
    @GetMapping("/user/{userId}/period") @Operation(summary = "Treinos por período")
    public ResponseEntity<List<Workout>> byPeriod(@PathVariable String userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return ResponseEntity.ok(repo.findByUserIdAndWorkoutDateBetween(userId, from, to));
    }
    @GetMapping("/user/{userId}/calories") @Operation(summary = "Total de calorias queimadas no período")
    public ResponseEntity<Map<String, Integer>> calories(@PathVariable String userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return ResponseEntity.ok(Map.of("totalCaloriesBurned", repo.totalCalories(userId, from, to)));
    }
    @GetMapping("/{id}") public ResponseEntity<Workout> findById(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
