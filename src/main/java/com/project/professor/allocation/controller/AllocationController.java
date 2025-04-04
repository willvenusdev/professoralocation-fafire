package com.project.professor.allocation.controller;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.service.AllocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService){
        super();
        this.allocationService = allocationService;
    }

    @   Operation(summary = "Find all allocations")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Allocation>> findAll(){
        List<Allocation> allocations = allocationService.findAll();
        return new ResponseEntity<>(allocations, HttpStatus.OK);
    }

    @Operation(summary = "Find an allocation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allocation> findById(@PathVariable(name = "id") Long id){
        Allocation allocation = allocationService.findById(id);
        return new ResponseEntity<>(allocation, HttpStatus.OK);
    }

    @Operation(summary = "Find allocations by professor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
    })
    @GetMapping(path = "/professor/{professor_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Allocation>> findByProfessor(@PathVariable(name = "professor_id") Long professor_id){
        List<Allocation> allocations = allocationService.findByProfessor(professor_id);
        return new ResponseEntity<>(allocations, HttpStatus.OK);
    }

    @Operation(summary = "Find allocations by course")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
    })
    @GetMapping(path = "/course/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Allocation>> findByCourse(@PathVariable(name = "course_id") Long course_id){
        List<Allocation> allocations = allocationService.findByCourse(course_id);
        return new ResponseEntity<>(allocations, HttpStatus.OK);
    }

    @Operation(summary = "Save an allocation")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Allocation> save(@RequestBody Allocation allocation){
        try{
            allocationService.save(allocation);
            return new ResponseEntity<>(allocation, HttpStatus.CREATED);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    @Operation(summary = "Update an allocation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    @PutMapping(path = "{id}")
    public ResponseEntity<Allocation> update(@PathVariable(name = "id") Long id,
                                           @RequestBody Allocation allocation){
        allocation.setId(id);
        try{
            allocation = allocationService.update(allocation);
            if (allocation == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else{
                return new ResponseEntity<>(allocation, HttpStatus.OK);
            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    @Operation(summary = "Delete all allocations")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
        allocationService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete an allocation")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id){
        allocationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
