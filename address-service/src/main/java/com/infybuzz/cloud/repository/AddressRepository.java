package com.infybuzz.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infybuzz.cloud.entity.Address;



@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
