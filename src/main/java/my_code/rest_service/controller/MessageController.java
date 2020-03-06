package my_code.rest_service.controller;

import my_code.rest_service.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("girls")
public class MessageController {
    private Integer count = 4;
    private List<Girl> girls = new ArrayList<Girl>(){{
        add(new Girl("Natasha", "1"));
        add(new Girl("Sveta", "2"));
        add(new Girl("Liza", "3"));
    }};
    @GetMapping
    public List<Girl> list(){
        return girls;
    }
    @GetMapping("{id}")
    public Girl getOne(@PathVariable String id){
        return getGirl(id);
    }

    private Girl getGirl(String id) {
        return girls.stream()
                .filter(girl -> girl.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Girl create(@RequestBody String name){
        Girl girl = new Girl(name, String.valueOf(count++));
        girls.add(girl);

        return girl;
    }

    @PutMapping("{id}")
    public Girl put(@PathVariable String id, @RequestBody String name){
        Girl currentGirl = getGirl(id);
        currentGirl.setName(name);
        return currentGirl;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Girl currentGirl = getGirl(id);
        girls.remove(currentGirl);
    }

}
