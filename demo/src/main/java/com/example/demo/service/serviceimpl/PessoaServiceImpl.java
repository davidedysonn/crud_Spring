package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import com.example.demo.service.dto.PessoaAtualizarDto;
import com.example.demo.service.dto.PessoaDto;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
/*
	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	*/

	private Pessoa convertToEntity(PessoaDto pessoaDto) {
		Pessoa pessoaToEntity = new Pessoa();
		pessoaToEntity.setId(pessoaDto.getId());
		pessoaToEntity.setName(pessoaDto.getName());

		return pessoaToEntity;
	}

	private PessoaDto convertToDTO(Pessoa pessoa) {
		PessoaDto pessoaToDto = new PessoaDto();
		pessoaToDto.setId(pessoa.getId());
		pessoaToDto.setName(pessoa.getName());

		return pessoaToDto;
	}

	@Override
	public PessoaDto salvarPessoa(PessoaDto pessoaDto) {
		Pessoa pessoa = convertToEntity(pessoaDto);
		Pessoa respostaPessoa = pessoaRepository.save(pessoa);
		PessoaDto respostaPessoaDto = convertToDTO(respostaPessoa);

		return respostaPessoaDto;
	}

	@Override
	public PessoaDto buscarPessoaPeloNome(String nome) {

		Optional<Pessoa> respostaPessoa = pessoaRepository.findByName(nome);
		PessoaDto pessoaDto = convertToDTO(respostaPessoa.get());

		return pessoaDto;
	}

	@Override
	public PessoaDto buscarPessoaPeloId(Long id) {

		Optional<Pessoa> respostaPessoa = pessoaRepository.findById(id);
		PessoaDto pessoaDto = convertToDTO(respostaPessoa.get());

		return pessoaDto;
	}

	@Override
	public PessoaDto deletarPessoaPeloId(Long id) {
		Optional<Pessoa> respostaPessoa = pessoaRepository.findById(id);
		// PessoaDto deletePessoaPorid = pessoaRepository.deleteById(id);
		return null;
	}

	@Override
	public void deletarUmaPessoa(Long id) {
		pessoaRepository.deleteById(id);
		
	}
	
	@Override
	public PessoaDto atualizarPessoaPeloNome(Long id, PessoaAtualizarDto pessoaAtualizarDto) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			pessoa.get().setName(pessoaAtualizarDto.getName());
			Pessoa pessoaAtualizada = pessoaRepository.save(pessoa.get());
			PessoaDto pessoaAtualizadaDto = convertToDTO(pessoaAtualizada);
			return pessoaAtualizadaDto;
		}
		else {
			return null;
		}

	}

	 @Override
	public void salvarListagemPessoa(List<PessoaDto> pessoaDto) {
		  List<Pessoa> pessoas = new ArrayList<>();
		
		  for (PessoaDto dto : pessoaDto) {
		        Pessoa pessoa = convertToEntity(dto);
		        pessoas.add(pessoa);
		    }
		  pessoaRepository.saveAll(pessoas);
		
	}
	 
	
}
	
	

