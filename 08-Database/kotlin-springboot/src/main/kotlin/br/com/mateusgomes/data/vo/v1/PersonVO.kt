package br.com.mateusgomes.data.vo.v1

data class PersonVO(
    var idPerson: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
)