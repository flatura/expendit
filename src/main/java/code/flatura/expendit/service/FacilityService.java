package code.flatura.expendit.service;

import code.flatura.expendit.model.Facility;
import code.flatura.expendit.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {

    private FacilityRepository facilityRepository;

    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public FacilityService() {
    }

    @Autowired
    public void setFacilityRepository(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
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


    //TODO find all consumables in the facility and change their room
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }
}
