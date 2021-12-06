package technobel.gedev.utyapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.forms.StudentForm;
import technobel.gedev.utyapp.services.spec.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.getOne(id));
    }

    //    GET http://localhost:8080/students
    //    GET http://localhost:8080/students/
    //    GET http://localhost:8080/students/all
    //    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<StudentDTO>> getAll(){
        List<StudentDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add")
    public StudentDTO insert(@Valid @RequestBody StudentForm form){

//        for (String key : headers.keySet()) {
//            System.out.println( headers.get(key) );
//        }

        return service.insert(form);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable("id") Long id) {
        StudentDTO dto = service.delete(id);

        return ResponseEntity.ok(dto);
    }
}
