package com.tecsup.petclinic.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	// Fetch owner by firstName
	List<Owner> findByFirstName(String firstName);
	// Fetch owner by address
	List<Owner> findByAddress(String address);
	// Fetch owner by lastName
	List<Owner> findByLastName(String lastName);
	// Fetch owner by city
	List<Owner> findByCity(String city);
	// Fetch owner by telephone
	List<Owner> findByTelephone(int telephone);
	
	
}
