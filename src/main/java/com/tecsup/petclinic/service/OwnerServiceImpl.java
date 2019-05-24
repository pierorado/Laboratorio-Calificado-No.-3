package com.tecsup.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.domain.OwnerRepository;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.domain.Owner;;

public class OwnerServiceImpl implements OwnerService {
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);
	
	@Autowired
	OwnerRepository ownerRepository;
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public void delete(Long id) throws OwnerNotFoundException {
		Owner  owner = findById(id);
		ownerRepository.delete(owner);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Owner findById(long id) throws OwnerNotFoundException {

		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return owner.get();
	}

	/**
	 * 
	 * @param last_name
	 * @return
	 */
	@Override
	public List<Owner> findByLastName(String lastName) {

		List<Owner> owners = ownerRepository.findByLastName(lastName);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	/**
	 * 
	 * @param first_name
	 * @return
	 */
	@Override
	public List<Owner> findByFirstName(String firstName) {

		List<Owner> owners = ownerRepository.findByFirstName(firstName);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	/**
	 * 
	 * @param address
	 * @return
	 */
	@Override
	public List<Owner> findByAddress(String address) {

		List<Owner> owners = ownerRepository.findByAddress(address);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	
	/**
	 * 
	 * @param city
	 * @return
	 */
	@Override
	public List<Owner> findByCity(String city) {

		List<Owner> owners = ownerRepository.findByCity(city);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	

	/**
	 * 
	 * @param telephone
	 * @return
	 */
	@Override
	public List<Owner> findByTelephone(int telephone) {

		List<Owner> owners = ownerRepository.findByTelephone(telephone);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Owner> findAll() {
		
		// TODO Auto-generated 
		return ownerRepository.findAll();
	
	}
	
}
