package code.flatura.expendit.service;

import code.flatura.expendit.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
