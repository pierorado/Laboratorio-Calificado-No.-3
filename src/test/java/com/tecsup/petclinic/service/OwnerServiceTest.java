package com.tecsup.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.Column;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.domain.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OwnerServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(OwnerServiceTest.class);
	
	@Autowired
	private OwnerService ownerService;
	
	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreateOwner() {

		String FIRST_NAME = "Piero";
		String LAST_NAME = "Rado";
		String ADDRESS = "robles 12";
		String CITY = "lima";
		int TELEPHONE = 987525123;
		

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		assertThat(owner.getId()).isNotNull();
		assertEquals(FIRST_NAME, owner.getFirstName());
		assertEquals(LAST_NAME, owner.getLastName());
		assertEquals(ADDRESS, owner.getAddress());
		assertEquals(CITY, owner.getCity());
		assertEquals(TELEPHONE, owner.getTelephone());
		
	}
	
	@Test
	public void testFindOwnerByFirst_name() {

		String FIRST_NAME = "Betty";
		int SIZE_EXPECTED = 2;

		List<Owner> owners =ownerService.findByFirstName(FIRST_NAME);

		assertEquals(SIZE_EXPECTED, owners.size());
	}
	@Test
	public void testfindOwnerByLastName() {

		String LAST_NAME = "Rodriquez";
		int SIZE_EXPECTED = 3;

		List<Owner> owners =ownerService.findByFirstName(LAST_NAME);

		assertEquals(SIZE_EXPECTED, owners.size());
	}
	@Test
	public void testFindOwnerByCity() {

		String CITY = "Windsor";
		int SIZE_EXPECTED = 4;

		List<Owner> owners =ownerService.findByFirstName(CITY);

		assertEquals(SIZE_EXPECTED, owners.size());
	}
	/**
	 * 
	 */
	@Test
	public void testDeleteOwner() {

		String FIRST_NAME = "George";
		String LAST_NAME = "Rado";
		String ADDRESS = "110 W. Liberty St.";
		String CITY = "Madison";
		int TELEPHONE = 6085551;

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS,CITY,TELEPHONE);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			ownerService.findById(owner.getId());
			assertTrue(false);
		} catch (OwnerNotFoundException e) {
			assertTrue(true);
		} 
				

	}
	
}
