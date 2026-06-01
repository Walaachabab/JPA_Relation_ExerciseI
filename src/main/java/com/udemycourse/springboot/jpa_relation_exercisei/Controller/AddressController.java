package com.udemycourse.springboot.jpa_relation_exercisei.Controller;

import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiResponse;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.AddressDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService;

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addAddress(@PathVariable Integer teacherId,
                                        @RequestBody @Valid AddressDTOIN addressDTOIN) {
        addressService.addAddress(teacherId, addressDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Address added successfully"));
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer teacherId,
                                           @RequestBody @Valid AddressDTOIN addressDTOIN) {
        addressService.updateAddress(teacherId, addressDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated successfully"));
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer teacherId) {
        addressService.deleteAddress(teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted successfully"));
    }
}