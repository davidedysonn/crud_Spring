package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PessoaService;
import com.example.demo.service.dto.PessoaAtualizarDto;
import com.example.demo.service.dto.PessoaDto;

@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	/*
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	*/
	@GetMapping("/teste")
	@ResponseBody
	public String teste (@RequestParam Long id){
		return "ID: " + id;
	}

	@PostMapping("/salvarPessoa")
	public PessoaDto salvarPessoa(@RequestBody PessoaDto pessoaDto) {
		PessoaDto pessoaResposta = pessoaService.salvarPessoa(pessoaDto); 
		return pessoaResposta;
	}
	
	@GetMapping("/buscarPessoaNome")
	public PessoaDto buscarPessoaPorNome (@RequestParam String name) {
		PessoaDto pessoaResposta = pessoaService.buscarPessoaPeloNome(name);
		return pessoaResposta;		
		
	}
	
	@GetMapping("/buscarPessoaId")
	public PessoaDto buscarPessoaPorId (@RequestParam Long id) {
		PessoaDto pessoaResposta = pessoaService.buscarPessoaPeloId(id);
		return pessoaResposta;
	}
	
	
	@DeleteMapping("/deletarPessoaPorId")
	public ResponseEntity<String> deletarPessoaPorId(@RequestParam Long id){
		
		pessoaService.deletarUmaPessoa(id);
		return ResponseEntity.ok("Pessoa Deletada");
	}
	
	@PutMapping("/atualizarNome/{id}")
	public ResponseEntity<PessoaDto> atualizarNome(@PathVariable Long id, @RequestBody PessoaAtualizarDto pessoaAtualizarDto){
	
		PessoaDto pessoaAtual = pessoaService.atualizarPessoaPeloNome(id, pessoaAtualizarDto);
		return ResponseEntity.ok(pessoaAtual);
		
	}
	
	@PostMapping("/adcPessoasList")
	public void adcPessoasList (@RequestBody List<PessoaDto> pessoaDto){
		pessoaService.salvarListagemPessoa(pessoaDto);
		
		
	}
	
	
	


	
	
	

}
