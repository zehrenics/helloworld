package de.oette.lecture.A01.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/todo")
public class ToDoAppController {

    private Map<Integer, String> todos = new HashMap<>();

    @PostMapping
    public Integer add(@RequestParam(value = "todo") String todo) {
        Integer newPosition = todos.entrySet().stream()
                .map(Map.Entry::getKey).reduce(Integer::max)
                .orElse(0) + 1;

        todos.put(newPosition, todo);
        return newPosition;
    }

    //default Value
    //required muss da sein

    @GetMapping
    public String list() {
        return todos.entrySet().stream()
                .map(x -> String.format("[%s %s]", x.getKey(), x.getValue()))
                .collect(Collectors.joining());

    }

    @DeleteMapping
    public void delete(int position) {
        todos.remove(position);
    }

    @PutMapping
    public  void update(Integer position, String todo) {
        todos.put(position, todo);
    }
}
