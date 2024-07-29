package com.example.lap5q2tracker.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tracker {

    @NotNull(message = "ID should be Not Null!")
    @Size(min = 3, max = 10 , message = "ID Size should be between 3 - 10")
    private int id;

    @NotNull(message = "Title should be Not Null!")
    @Size(min = 9 , max = 12)
    private String title;

    @NotNull(message = "Description should be Not Null!")
    @Size(min = 10 , max = 20)
    private String description;

   @NotNull(message = "Status should be Not Null!")
   @Pattern(regexp="^(Not Started|Progress|Completed)$",message = "")
    private String status;


   @NotNull(message = "CompanyName should be Not Null!")
   @Size(min = 7 , max = 10)
    private String companyName;

}
