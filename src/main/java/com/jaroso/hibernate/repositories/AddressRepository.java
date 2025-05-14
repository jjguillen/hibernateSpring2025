package com.jaroso.hibernate.repositories;

import com.jaroso.hibernate.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAddressByCity(String city);
}
