package app.repositories

import app.models.Pet

object PetRepository {

  private var _pets : List[Pet] = Nil

  def all() : List[Pet] = _pets

  def findByName(name : String) : Option[Pet] = None

  def dogs : List[Pet] = _pets

  def cats : List[Pet] = _pets

  def other : List[Pet] = _pets
  
  def add(pet: Pet*) : List[Pet] = _pets

  def removeByName(name : String) : List[Pet] = _pets

  def update(pet : Pet) : List[Pet] = _pets

}
