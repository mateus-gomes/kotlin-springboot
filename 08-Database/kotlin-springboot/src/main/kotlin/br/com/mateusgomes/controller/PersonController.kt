package br.com.mateusgomes.controller

import br.com.mateusgomes.model.Person
import br.com.mateusgomes.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping
    fun findAll(): List<Person> {
        return personService.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun findById(
        @PathVariable(value = "id") id: Long
    ): Person {
        return personService.findById(id)
    }

    @PostMapping
    fun create(
        @RequestBody person: Person
    ): Person {
        return personService.create(person)
    }

    @PutMapping
    fun update(
        @RequestBody person: Person
    ): Person {
        return personService.update(person)
    }

    @DeleteMapping(value = ["/{id}"])
    fun delete(
        @PathVariable(value = "id") id: Long
    ): ResponseEntity<*> {
        personService.delete(id)

        return ResponseEntity.noContent().build<Any>()
    }
}