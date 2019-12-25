package code.flatura.expendit.service;

import code.flatura.expendit.model.Facility;
import code.flatura.expendit.model.Room;
import code.flatura.expendit.repository.ConsumableRepository;
import code.flatura.expendit.repository.FacilityRepository;
import code.flatura.expendit.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacilityService {

    private FacilityRepository facilityRepository;

    @Autowired
    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public FacilityService() {
    }

    public Facility create(Facility newFacility) {
        return facilityRepository.save(newFacility);
    }

    public List<Facility> getAll() {
        return facilityRepository.findAll();
    }

    public Optional<Facility> getById(int id) {
        return facilityRepository.findById(id);
    }

    public void update(Facility editedFacility, int id) {
        if (editedFacility.getId() == null || facilityRepository.existsById(id))
        {
            facilityRepository.save(editedFacility);
        }
    }

    public void delete(int id) {
        facilityRepository.deleteById(id);
    }
}
