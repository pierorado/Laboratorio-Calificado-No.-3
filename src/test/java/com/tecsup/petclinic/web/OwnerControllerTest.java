package com.tecsup.petclinic.web;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OwnerControllerTest {
	 private static final ObjectMapper om = new ObjectMapper();
	 @Autowired
		private MockMvc mockMvc;
	 /**
		 * 
		 * @throws Exception
		 */
		@Test
		public void testGetOwners() throws Exception {

		
			int ID_FIRST_RECORD = 1;

			this.mockMvc.perform(get("/owners"))
						.andExpect(status().isOk())
						.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON_UTF8))
					// .andExpect(jsonPath("$", hasSize(NRO_RECORD)))
						.andExpect(jsonPath("$[0].id", is(ID_FIRST_RECORD)));

		}

		/**
		 * 
		 * @throws Exception
		 */
		@Test
		public void testFindPetOK() throws Exception {

			String FIRSTNAME_PET = "George";
			String LASTNAME_PET = "Franklin";
			String ADDRESS_PET = "110 W. Liberty St.";
			String CITY_PET = "Madison";
			int TELEPHONE = 608555102;

	

			mockMvc.perform(get("/owners/1"))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					//.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.id", is(1)))
					.andExpect(jsonPath("$.first_name", is(FIRSTNAME_PET)))
					.andExpect(jsonPath("$.last_name", is(LASTNAME_PET)))
					.andExpect(jsonPath("$.address", is(ADDRESS_PET)))
					.andExpect(jsonPath("$.city", is(CITY_PET)))
					.andExpect(jsonPath("$.telephone", is(TELEPHONE)));
	
					//.andExpect(jsonPath("$.birthDate", is(new SimpleDateFormat("yyyy-MM-dd").format(DATE))));


		}

		/**
		 * 
		 * @throws Exception
		 */
		@Test
		public void testFindPetKO() throws Exception {

			mockMvc.perform(get("/owners/666"))
					.andExpect(status().isNotFound());

		}

		

	
}
