package com.example.lap5q3event.Controller;
import com.example.lap5q3event.Api.ApiResponse;
import com.example.lap5q3event.Model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Event")
public class EventController {

    ArrayList<Event> events = new ArrayList<Event>();

@GetMapping("/get")
    public ResponseEntity getEvents() {
    return ResponseEntity.status(200).body(events);
}
@PostMapping("/add")
    public ResponseEntity addEvent(@RequestBody Event event , Errors errors) {
    if(errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    events.add(event);
    return ResponseEntity.status (200).body(new ApiResponse("Event Added Successfully"));
}
@PutMapping("/update/{index}")
    public ResponseEntity updateEvent(@PathVariable int index, @RequestBody Event event ,Errors errors) {
    if(errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    events.set(index, event);
    return ResponseEntity.status (200).body(new ApiResponse("Event Updated Successfully"));
}
@DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEvent(@PathVariable int index) {
    events.remove(index);
    return ResponseEntity.status(200).body(new ApiResponse("Event Deleted Successfully")) ;
}

@PutMapping("/capacity/{id}/{index}")
    public ResponseEntity changeCapacity(@PathVariable int id ,@PathVariable int capacity) {

   for(Event e : events) {
       if(e.getId() == id) {
           if (capacity>25)
           e.setCapacity(capacity);
           return ResponseEntity.status(200).body(new ApiResponse("Event Capacity Changed Successfully"));
       }else
           return ResponseEntity.status(400).body(new ApiResponse("Event Capacity Not Changed Successfully"));
   }
    return ResponseEntity.status(400).body(new ApiResponse("Event Capacity Not Found "));
    }
 @GetMapping("/get/search/{id}")
 public ResponseEntity searchEventById(@PathVariable int id,@RequestBody Event event) {
    for(Event e : events) {
        if(e.getId() == id) {
            return ResponseEntity.status(200).body(e);
        }
    }
   return ResponseEntity.status(404).body(new ApiResponse("Event Not Found"));
 }
}



