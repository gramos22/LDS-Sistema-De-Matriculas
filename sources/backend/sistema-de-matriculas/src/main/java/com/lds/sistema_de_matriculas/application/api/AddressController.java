package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.application.dto.AddressDTO;
import com.lds.sistema_de_matriculas.domain.model.Address;
import com.lds.sistema_de_matriculas.domain.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@Valid @RequestBody AddressDTO addressDTO) {
        Address address = addressService.createAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable String id) {
        Address address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable String id, @Valid @RequestBody AddressDTO addressDTO) {
        Address address = addressService.updateAddress(id, addressDTO);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}