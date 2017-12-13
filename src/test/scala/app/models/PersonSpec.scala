package app.models

import org.scalatest.WordSpec

class PersonSpec extends WordSpec {

  "Person" when {
    "speak is called" should {
      "return 'You don't get a hello!' when name is 'adam'" in {
        val person = new Person("adam", 10)
        assert(person.speak().equals("You don't get a hello!"))
      }
    }
  }

}

