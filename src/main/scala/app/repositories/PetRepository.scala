package app.repositories

import app.models.{Cat, Dog, Pet}

object PetRepository {

  private var _pets : List[Pet] = Nil

  def all() : List[Pet] = _pets

  def findByName(name : String) : Option[Pet] = _pets.find(p => p.name == name)

  def dogs : List[Pet] = _pets

  def cats : List[Cat] = {
    _pets.flatMap {
      case c @ Cat(_, _) => Some(c)
      case _ => None
    }
  }

  def other : List[Pet] = _pets

  def add(pet: Pet*) : List[Pet] = {
    _pets = _pets ::: pet.toList
    all()
  }

  def removeByName(name : String) : List[Pet] = _pets.filterNot(p => p.name.equalsIgnoreCase(name))

  def update(pet : Pet) : List[Pet] = _pets.updated(_pets.indexOf(pet), pet)


}
