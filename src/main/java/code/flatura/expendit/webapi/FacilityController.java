package code.flatura.expendit.webapi;

import code.flatura.expendit.model.Facility;
import code.flatura.expendit.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/facilities", produces = MediaType.APPLICATION_JSON_VALUE)
public class FacilityController {
    private FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    public FacilityController() {
    }

    @Autowired
    public void setFacilityService(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping()
    public ResponseEntity<Facility> create(@RequestBody() Facility newFacility) {
        return new ResponseEntity<>(facilityService.create(newFacility), HttpStatus.OK);
    }

    @GetMapping()
    public List<Facility> findAll() {
        return facilityService.getAll();
    }

    @GetMapping("/by")
    public List<Facility> findByName(@RequestParam() String name) {
        return facilityService.getByName(name);
    }

    @GetMapping(value = "/{id}")
    public Optional<Facility> findById(@PathVariable("id") int id) {
        return facilityService.getById(id);
    }


    @PutMapping(value = "/{id}")
    public void save(@PathVariable("id") int id, @RequestBody() Facility editedFacility) {
        facilityService.update(editedFacility, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        facilityService.delete(id);
    }
}
