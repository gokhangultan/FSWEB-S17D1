package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    public AnimalController() {
        animals = new HashMap<>();
    }

    @GetMapping("")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable int id){
        return animals.get(id);
    }
    @PostMapping("")
    public Animal addNewAnimal(@RequestBody Animal animal){

        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        animals.remove(id, animals.get(id));
    }
}
