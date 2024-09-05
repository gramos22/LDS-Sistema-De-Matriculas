package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.AddressDTO;
import com.lds.sistema_de_matriculas.application.mapper.AddressMapper;
import com.lds.sistema_de_matriculas.domain.model.Address;
import com.lds.sistema_de_matriculas.domain.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address createAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toAddress(addressDTO);
        return addressRepository.save(address);
    }

    public Address getAddressById(String id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
    }

    public Address updateAddress(String id, AddressDTO addressDTO) {
        Address existingAddress = getAddressById(id);
        addressMapper.updateAddressFromDTO(addressDTO, existingAddress);
        return addressRepository.save(existingAddress);
    }

    public void deleteAddress(String id) {
        addressRepository.deleteById(id);
    }
}