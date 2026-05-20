package com.udemycourse.springboot.jpa_relation_exercisei.Controllers;

import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiResponse;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Address;
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

    // ADD
    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addAddress(@PathVariable Integer teacherId, @RequestBody @Valid Address address) {
        addressService.addAddress(teacherId, address);
        return ResponseEntity.status(200).body(new ApiResponse("Address added successfully"));
    }

    // UPDATE
    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer teacherId, @RequestBody @Valid Address address) {
        addressService.updateAddress(teacherId, address);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated successfully"));
    }

    // DELETE
    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer teacherId) {
        addressService.deleteAddress(teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted successfully"));
    }
}