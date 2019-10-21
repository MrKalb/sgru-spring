package br.com.ifrs.SGRU.service;


import br.com.ifrs.SGRU.dto.PersonDTO;
import br.com.ifrs.SGRU.entities.PersonEntity;
import br.com.ifrs.SGRU.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @MockBean
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    public void createPersonTest(){
        PersonDTO personDTO = new PersonDTO();
        personService.createPerson(personDTO);
        Mockito.verify(personRepository).save(Mockito.any());
    }
}
