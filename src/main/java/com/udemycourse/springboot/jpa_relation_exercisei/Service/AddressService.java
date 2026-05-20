package com.udemycourse.springboot.jpa_relation_exercisei.Service;


import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiException;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Address;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Teacher;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.AddressRepository;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    // ADD
    public void addAddress(Integer teacherId, Address address) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        address.setTeacher(teacher);
        addressRepository.save(address);
    }

    // UPDATE
    public void updateAddress(Integer teacherId, Address address) {
        Address oldAddress = addressRepository.findAddressByTeacherId(teacherId);
        if (oldAddress == null) {
            throw new ApiException("Address not found");
        }
        oldAddress.setArea(address.getArea());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setBuildingNumber(address.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

    // DELETE
    public void deleteAddress(Integer teacherId) {
        Address address = addressRepository.findAddressByTeacherId(teacherId);
        if (address == null) {
            throw new ApiException("Address not found");
        }
        addressRepository.delete(address);
    }
}