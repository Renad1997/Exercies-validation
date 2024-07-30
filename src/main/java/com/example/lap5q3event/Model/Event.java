package com.example.lap5q3event.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Event {

@NotNull(message = "ID should be Not Null!")
@Size(min = 3, max = 10 , message = "ID Size should be between 3 - 10")
private int id;

@NotEmpty(message = "Description should be Not Empty!")
@Size(min = 10 , max = 20)
private String description;

@NotNull(message = "ID should be Not Null!")
@PositiveOrZero(message = "capacity should be a number")
@Pattern(regexp = "(/^(?!(?:0|0\\.0|0\\.00)$)[+]?\\d+(\\.\\d|\\.\\d[0-9])?$/)",message = "")
private int capacity;


@JsonFormat(pattern ="(yyyy-MM-dd)")
private LocalDateTime startDate;


@JsonFormat(pattern ="(yyyy-MM-dd)")
private LocalDateTime endDate;


}
