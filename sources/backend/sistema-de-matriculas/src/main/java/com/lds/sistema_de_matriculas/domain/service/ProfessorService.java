package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.ProfessorDTO;
import com.lds.sistema_de_matriculas.application.mapper.ProfessorMapper;
import com.lds.sistema_de_matriculas.domain.model.Address;
import com.lds.sistema_de_matriculas.domain.model.Professor;
import com.lds.sistema_de_matriculas.domain.repository.AddressRepository;
import com.lds.sistema_de_matriculas.domain.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final AddressRepository addressRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, AddressRepository addressRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.addressRepository = addressRepository;
        this.professorMapper = professorMapper;
    }

    public Professor createProfessor(ProfessorDTO professorDTO) {
        Address address = addressRepository.findById(professorDTO.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found with ID: " + professorDTO.getAddressId()));

        Professor professor = professorMapper.toProfessor(professorDTO);
        professor.setAddress(address);
        return professorRepository.save(professor);
    }

    public Professor getProfessorById(String id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with ID: " + id));
    }

    public Professor updateProfessor(String id, ProfessorDTO professorDTO) {
        Professor existingProfessor = getProfessorById(id);
        professorMapper.updateProfessorFromDTO(professorDTO, existingProfessor);

        if (professorDTO.getAddressId() != null) {
            Address address = addressRepository.findById(professorDTO.getAddressId())
                    .orElseThrow(() -> new RuntimeException("Address not found with ID: " + professorDTO.getAddressId()));
            existingProfessor.setAddress(address);
        }

        return professorRepository.save(existingProfessor);
    }

    public void deleteProfessor(String id) {
        professorRepository.deleteById(id);
    }

    public Iterable<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
}