package br.com.mateusgomes.service

import br.com.mateusgomes.data.vo.v1.PersonVO
import br.com.mateusgomes.exception.ResourceNotFoundException
import br.com.mateusgomes.mapper.ModelMapper
import br.com.mateusgomes.model.Person
import br.com.mateusgomes.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO>{
        logger.info("Finding all people!")
        val persons = personRepository.findAll()

        return ModelMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding person $id!")
        val person = personRepository.findById(id)
            .orElseThrow{ ResourceNotFoundException("No record found for this ID!") }

        return ModelMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO): PersonVO{
        logger.info("Creating person ${person.firstName}!")
        val entity:Person = ModelMapper.parseObject(person, Person::class.java)

        return ModelMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun update(newPersonInfo: PersonVO): PersonVO{
        findById(newPersonInfo.idPerson).takeIf {
            logger.info("Updating data from person $newPersonInfo.idPerson!")

            val entity:Person = ModelMapper.parseObject(newPersonInfo, Person::class.java)
            personRepository.save(entity)

            return newPersonInfo
        }
    }

    fun delete(id: Long){
        val person = personRepository.findById(id).orElseThrow{ ResourceNotFoundException("No record found for this ID!") }

        logger.info("Deleting data from person $id!")

        personRepository.delete(person)
    }
}