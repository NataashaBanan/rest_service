package my_code.rest_service.controller;

import my_code.rest_service.exceptions.NotFoundException;
import my_code.rest_service.interfaces.GirlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("girls")
public class MessageController {
    @Autowired
    private GirlRepo girlRepo;

    @GetMapping
    public List<Girl> list(){
        Iterable<Girl> girls = girlRepo.findAll();
        List<Girl> list = new ArrayList<>();
        for (Girl girl : girls) {
            list.add(girl);
        }
        return list;
    }

    @GetMapping("{id}")
    public String getOne (@PathVariable String id){
        return getGirl(id).toString();
    }

    private Girl getGirl(String id) {
        return girlRepo.findById(Integer.parseInt(id)).orElseThrow(NotFoundException::new);
    }

    @PostMapping("{name}")
    public String create(@PathVariable String name){
        Girl girl = new Girl(name);
        girlRepo.save(girl);
        return girl.toString() + " saved";
    }

    @PutMapping("{id}")
    public String put(@PathVariable String id, @PathParam("{name}") String name){
        Girl currentGirl = getGirl(id);
        currentGirl.setName(name);
        girlRepo.save(currentGirl);
        return currentGirl.toString() + " put";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable String id){
        Girl currentGirl = getGirl(id);
        girlRepo.delete(currentGirl);
        return (currentGirl.toString() + " killed");
    }

}
