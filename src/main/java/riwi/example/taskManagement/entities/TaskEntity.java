package riwi.example.taskManagement.entities;


import jakarta.persistence.*; // Asegúrate de usar jakarta.persistence
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255, nullable = true)
    private String description;

    @Column( nullable = true, updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate creationDate;

    @Column( nullable = true, updatable = false)
    private LocalTime creationTime;

    @Column(length = 50, nullable = false)
    private String status;
}
