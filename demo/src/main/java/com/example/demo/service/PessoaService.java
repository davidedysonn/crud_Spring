package com.example.demo.service;

import java.util.List;

import com.example.demo.service.dto.PessoaAtualizarDto;
import com.example.demo.service.dto.PessoaDto;

public interface PessoaService {

	PessoaDto salvarPessoa(PessoaDto pessoaDto);
		
	PessoaDto buscarPessoaPeloNome(String nome);
	
	PessoaDto buscarPessoaPeloId(Long id);
	
	PessoaDto deletarPessoaPeloId(Long id);
	
	PessoaDto atualizarPessoaPeloNome(Long id, PessoaAtualizarDto pessoaAtualizarDto);
	
	void deletarUmaPessoa (Long id);
	
	void salvarListagemPessoa(List<PessoaDto> pessoaDto);
	
	
	
	
}
