package br.com.matrixenergia.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrixenergia.model.Logs;
import br.com.matrixenergia.repository.LogsRepository;

@RestController
@RequestMapping("/logs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LogsController {
	
	@Autowired
	private LogsRepository logsRepository;
	
	@GetMapping("/todosresultados")
	public ResponseEntity<List<Logs>>GetAll(){
		return ResponseEntity.ok(logsRepository.findAll());
	}
	
	@GetMapping("/data-between/{start}/{end}")
	public ResponseEntity<List<Logs>>findByData(@RequestParam("start") Date start,@RequestParam("end") Date end){
		return ResponseEntity.ok(logsRepository.findByDataGreaterThanEqualAndDataLessThanEqual(start, end));
	}
	@GetMapping("/ip/{ip}/data/{start}/{end}")
	public ResponseEntity<List<Logs>>findByDataAndIP(@RequestParam("ip") String ip,@RequestParam("start") Date start,@RequestParam("end") Date end){
		return ResponseEntity.ok(logsRepository.findByIpAndDataGreaterThanEqualAndDataLessThanEqual(ip, start, end));
	}
	
	@GetMapping("/ip/{ip}")
	public ResponseEntity<List<Logs>>getByIp(@PathVariable String ip){
		return ResponseEntity.ok(logsRepository.findAllByIp(ip));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Logs>postLog(@RequestBody Logs logs){
		return ResponseEntity.status(HttpStatus.CREATED).body(logsRepository.save(logs));
	}
	
	@DeleteMapping("/{id}")
	public void deleteLog(@PathVariable long id) {
		
		logsRepository.deleteById(id);
	
	}
}
