package br.com.mateusgomes.service

import br.com.mateusgomes.exception.ResourceNotFoundException
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

    fun findAll(): List<Person>{
        logger.info("Finding all people!")
        return personRepository.findAll()
    }

    fun findById(id: Long): Person{
        logger.info("Finding person $id!")
        return personRepository.findById(id)
            .orElseThrow{ ResourceNotFoundException("No record found for this ID!") }
    }

    fun create(person: Person): Person{
        return personRepository.save(person)
    }

    fun update(newPersonInfo: Person): Person{
        findById(newPersonInfo.idPerson).takeIf {
            logger.info("Updating data from person $newPersonInfo.idPerson!")

            personRepository.save(newPersonInfo)

            return newPersonInfo
        }
    }

    fun delete(id: Long){
        val person = findById(id)

        logger.info("Deleting data from person $id!")

        personRepository.delete(person)
    }
}