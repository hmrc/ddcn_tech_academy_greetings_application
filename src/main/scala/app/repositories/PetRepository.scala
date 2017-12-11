package app.repositories

import app.models.{Cat, Dog, Pet}

object PetRepository {

  private var _pets : List[Pet] = Nil

  def all() : List[Pet] = _pets

  def findByName(name : String) : Option[Pet] = _pets.find(p => p.name.equalsIgnoreCase(name))

  def dogs : List[Dog] = {
    _pets.collect { case d : Dog => d }
  }

  def cats : List[Cat] = {
    _pets.flatMap {
      case c @ Cat(_, _) => Some(c)
      case _ => None
    }
  }

  def other : List[Pet] = _pets.filterNot(x => x.isInstanceOf[Cat] || x.isInstanceOf[Dog])

  def add(pet: Pet*) : List[Pet] = {
    _pets = _pets ::: pet.toList
    all()
  }

  def removeByName(name : String) : List[Pet] = _pets.filterNot(p => p.name.equalsIgnoreCase(name))

  def update(original: Pet, modified: Pet) : List[Pet] = {
    _pets = _pets.updated(indexOfPet(original), modified)
    all()
  }

  private def indexOfPet(pet: Pet) = _pets.indexOf(pet)

}
