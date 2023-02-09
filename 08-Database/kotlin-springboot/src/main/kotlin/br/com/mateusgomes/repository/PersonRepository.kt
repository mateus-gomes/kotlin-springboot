package br.com.mateusgomes.repository

import br.com.mateusgomes.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Long?>{
}