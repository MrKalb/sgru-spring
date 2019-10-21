package br.com.ifrs.SGRU.service;

import br.com.ifrs.SGRU.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

public class BaseService {

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    protected PersonRepository personRepository;


}
