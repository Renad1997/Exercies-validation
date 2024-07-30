package com.example.lap5q2tracker.Controller;

import com.example.lap5q2tracker.Api.ApiResponse;
import com.example.lap5q2tracker.Model.Tracker;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Tracker")
public class TrackerController {

    ArrayList<Tracker> trackers = new ArrayList<Tracker>();

    @GetMapping("/get")
    public ResponseEntity getTrackers() {
        return ResponseEntity.status(200).body(trackers);
    }

    @PostMapping("/add")
    public ResponseEntity addTracker(@RequestBody Tracker tracker, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        trackers.add(tracker);
        return ResponseEntity.status(200).body(new ApiResponse("Tracker Added successfully"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateTracker(@PathVariable int index, @RequestBody Tracker tracker, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        trackers.set(index, tracker);
        return ResponseEntity.status(200).body(new ApiResponse("Tracker Updated Successfully"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteTracker(@PathVariable int index) {
        trackers.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Tracker Deleted Successfully"));
    }

    @PutMapping("/update/status/{index}")
    public ResponseEntity changeStatus(@PathVariable int index) {

        if (index < trackers.size()) {
            if (trackers.get(index).getStatus().equals("Not Started")) {
                trackers.get(index).setStatus("Progres");
                return ResponseEntity.status(200).body(new ApiResponse("Tracker Status Changed Successfully"));
            } else if (trackers.get(index).getStatus().equals("Progres")) {
                trackers.get(index).setStatus("Completed");
                return ResponseEntity.status(200).body(new ApiResponse("Tracker Status Changed Successfully"));
            } else if (trackers.get(index).getStatus().equals("Completed")) {
                trackers.get(index).setStatus("Completed");
                return ResponseEntity.status(200).body(new ApiResponse("Tracker Status Changed Successfully"));
            }
        }
        return ResponseEntity.status(404).body(new ApiResponse("Tracker Status Not Found"));
    }

    @GetMapping("/get1/{title}")
    public ResponseEntity searchTitle(@PathVariable String title) {
        for (Tracker tracker : trackers) {
            if (tracker.getTitle().equalsIgnoreCase(title)) {
                return ResponseEntity.status(200).body(tracker);
            }
        }
        return ResponseEntity.status(404).body(new ApiResponse("Tracker Title Not Found"));
    }

    @GetMapping("/display/{companyName}")
    public ResponseEntity displayTracker(@PathVariable String companyName) {
        ArrayList<Tracker> trackerlist = new ArrayList<Tracker>();
        for (Tracker tracker : trackers) {
            if (tracker.getCompanyName().equalsIgnoreCase(companyName)) {
                trackerlist.add(tracker);
            }
        }
        if (trackerlist.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse("Tracker Company Name Not Found"));
        }
        return ResponseEntity.status(200).body(trackerlist);
    }
}
