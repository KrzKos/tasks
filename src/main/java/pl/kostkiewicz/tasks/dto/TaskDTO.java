package pl.kostkiewicz.tasks.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TaskDTO {

    private Long id;
    private String name;
    private Long userId;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_to_finish")
    private LocalDate dateToFinish;
    @Column(name = "time_to_finish")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime timeToFinish;

}
