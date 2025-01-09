package zim_project.zim_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zim_project.zim_project.model.Locations;
import zim_project.zim_project.repository.LocationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Locations> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Locations> getLocationById(Long id) {
        return locationRepository.findById(id); // פעולה זו תחזיר Optional
    }

    public Locations createLocation(Locations location) {
        return locationRepository.save(location);
    }

    public Locations updateLocation(Long id, Locations location) {
        if (locationRepository.existsById(id)) {
            location.setLocationId(id);
            return locationRepository.save(location);
        }
        return null;
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}