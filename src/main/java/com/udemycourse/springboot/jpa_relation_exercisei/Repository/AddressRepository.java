package com.udemycourse.springboot.jpa_relation_exercisei.Repository;


import com.udemycourse.springboot.jpa_relation_exercisei.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressByTeacherId(Integer teacherId);
}
