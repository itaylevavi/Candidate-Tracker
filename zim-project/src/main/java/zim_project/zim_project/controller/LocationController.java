package zim_project.zim_project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import zim_project.zim_project.model.Locations;
import zim_project.zim_project.service.LocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Get all locations
    @GetMapping
    public List<Locations> getAllLocations() {
        return locationService.getAllLocations();
    }

    // Get a specific location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Locations> getLocationById(@PathVariable Long id) {
        Optional<Locations> location = locationService.getLocationById(id);
        return location.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    // Update an existing location
    @PutMapping("/{id}")
    public ResponseEntity<Locations> updateLocation(@PathVariable Long id, @RequestBody Locations location) {
        Locations updatedLocation = locationService.updateLocation(id, location);
        if (updatedLocation != null) {
            return ResponseEntity.ok(updatedLocation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    }
