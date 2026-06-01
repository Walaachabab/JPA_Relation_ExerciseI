package com.udemycourse.springboot.jpa_relation_exercisei.Service;


import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiException;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.AddressDTOIN;
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


    // ADD AddressDTOIN
    public void addAddress(Integer teacherId, AddressDTOIN addressDTOIN) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Address address = new Address();
        address.setArea(addressDTOIN.getArea());
        address.setStreet(addressDTOIN.getStreet());
        address.setBuildingNumber(addressDTOIN.getBuildingNumber());
        address.setTeacher(teacher);
        addressRepository.save(address);
    }

    // UPDATE
    public void updateAddress(Integer teacherId, AddressDTOIN addressDTOIN) {
        Address address = addressRepository.findAddressByTeacherId(teacherId);
        if (address == null) {
            throw new ApiException("Address not found");
        }
        address.setArea(addressDTOIN.getArea());
        address.setStreet(addressDTOIN.getStreet());
        address.setBuildingNumber(addressDTOIN.getBuildingNumber());
        addressRepository.save(address);
    }

    // DELETE
    public void deleteAddress(Integer teacherId) {
        Address address = addressRepository.findAddressByTeacherId(teacherId);
        if (address == null) {
            throw new ApiException("Address not found");
        }

        Teacher teacher = address.getTeacher();
        teacher.setAddress(null);
        teacherRepository.save(teacher); // نفصلهم بالحذف عشان يتم حذف العنوان من الTeacher
                                         // في حالة حذف العنوان

        addressRepository.delete(address);
    }
}