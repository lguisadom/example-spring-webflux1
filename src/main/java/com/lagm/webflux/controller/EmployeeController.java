package com.lagm.webflux.controller;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lagm.webflux.modelo.Employee;
import com.lagm.webflux.service.IEmployeeService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final IEmployeeService employeeService;

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Flux<Employee> findAll() {
		return this.employeeService.findAll();
	}

	@GetMapping("/{employeeId}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> findById(@PathVariable("employeeId") String id) {
		return this.employeeService.findById(id);
	}

	@GetMapping("/dni/{employeeDni}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> findByDni(@PathVariable("employeeDni") String dni) {
		return this.employeeService.findById(dni);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Employee> save(@RequestBody Employee employee) {
		return this.employeeService.save(employee);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> update(@RequestBody Employee employee, @PathVariable String id) {
		employee.setId(new ObjectId(id));
		return this.employeeService.update(employee, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable String id) {
		return this.employeeService.deleteById(id);
	}
}
