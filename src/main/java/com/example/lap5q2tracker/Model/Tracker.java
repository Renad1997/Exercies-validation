package com.example.lap5q2tracker.Model;

import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Title should be Not Empty!")
    @Size(min = 9 , max = 12)
    private String title;

    @NotEmpty(message = "Description should be Not Empty!")
    @Size(min = 10 , max = 20)
    private String description;

   @NotEmpty(message = "Status should be Not Empty!")
   @Pattern(regexp="^(Not Started|Progress|Completed)$",message = "")
    private String status;


   @NotEmpty(message = "CompanyName should be Not Empty!")
   @Size(min = 7 , max = 10)
    private String companyName;

}
