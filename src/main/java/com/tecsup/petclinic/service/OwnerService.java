package com.tecsup.petclinic.service;

import java.util.List;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;


public interface OwnerService {
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);
	
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner owner);

	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	void delete(Long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param first_name
	 * @return
	 */
	List<Owner> findByLastName(String lastName);

	/**
	 * 
	 * @param last_name
	 * @return
	 */
	List<Owner> findByFirstName(String firstName);
	/**
	 * 
	 * @param address
	 * @return
	 */
	List<Owner> findByAddress(String address);
	/**
	 * 
	 * @param last_name
	 * @return
	 */
	List<Owner> findByCity(String city);
	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	List<Owner> findByTelephone(int telephone);

	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();

	



	

	

	
	
}
