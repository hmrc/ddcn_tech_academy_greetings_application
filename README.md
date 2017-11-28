# 2- Greetings

- [x] Implement remote git and hookup locally and push
- [ ] Raise first PR
- [x] Implement function
- [ ] Implement trait and language switcher
- [ ] Switch on input from terminal


## Aims
This session will introduce us to the world of Scala and basic programming! You will come across basic data types, functions, variables and values.
We're going to create an application that will take input from the command line and say Hello! back

By the end of the session you will be able to:
* Implement and compile a Main class
* Implement conditional expressions (**if** statements)
* Define values
* Define variables
* Implement functions
* Implement a Basic Class
* Read input from command line
* Output to command line

Throughout this lesson, you can refer to the following helpful cheatsheet which is a nice guide to support you on terms and syntax:
[Scalacheat | Scala Documentation](https://docs.scala-lang.org/cheatsheets/)

## Prerequisites
You have configured your development machine as per:
[Laptop Configuration Ubuntu](https://confluence.tools.tax.service.gov.uk/display/DTRG/02+Laptop+Configuration+%3A+Ubuntu)

## Lesson steps

###  Creating an SBT project
![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-14%2015.49.44.png)
**Create New Project**

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-14%2015.48.32.png)
**Select Scala > SBT**

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-15%2015.16.31.png)

**Naming project and configuring project location**

Wait for IntelliJ to compile your project! This will download the necessary libraries and files it requires. This may take a little while...


### Let's create our first program!

#### Creating a new package
1. Create a new package inside our `src/main/scala` directory called `app`

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-15%2014.40.44.png)

3. Create a new `object` called GreeterApplication inside of this new package

 ![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-14%2015.59.28.png)

#### Creating a new object
![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-15%2015.18.36.png)


2. Make `GreeterApplication` extend `App` 

```scala
package app

object GreeterApplication extends App {

}
```

4. Implement `println("Hello!")` inside of the two curly braces `{ }`

```scala
package app

object GreeterApplication extends App {
  println(s"Hello !")
}
```

5. Run your program!

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-15%2015.19.42.png)

8. You ~should~ see the following output 

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-14%2016.03.27.png)


#### Let's get our code into version control / git

Navigate to your project on the command line. Then execute the follow command `git init`.
This will create a new GitHub repository locally for you ready for you to commit your first changes.
We're going to want to create a `branch` to commit our code onto so that we *don't commit straight to master.*

**Further reading**
[Git - Basic Branching and Merging](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)

Run the follow command `git checkout -b initial-setup`
This is now ready for us to start creating some code.

> How do we get this code onto github.com?   
> We will get to that later! For now, we're going to be developing locally and commit code as we go.  

**Further reading**
[Why Git | Atlassian Git Tutorial](https://www.atlassian.com/git/tutorials/why-git)

Now we're going to create out first commit.
Run the following commands `git add --all` `git commit -m "ENTER YOUR MESSAGE HERE"`

Replace *ENTER YOUR MESSAGE HERE* with a meaningful git commit message such as:

`git commit -m "Add project files and dependencies and implements a Scala App"`

::**Tip:** How to write a good commit message:: [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/)


#### Let's make it say our name

We're going to make the App take our name as an input argument from the *terminal.app* eventually and then make this output for example `Hello Adam!`

In order to achieve this, we're going to implement our first variable.

> Variables are used to store information to be referenced and manipulated in a computer program. They also provide a way of labelling data with a descriptive name, so our programs can be understood more clearly by the reader and ourselves. It is helpful to think of variables as containers that hold information. Their sole purpose is to label and store data in memory. This data can then be used throughout your program.  

Modify your `GreeterApplication` to include a `val name` above our `println` statement.

```scala
object GreeterApplication extends App {
  val name = "Adam"
  println(s"Hello !")
}
```

Modify our `println` statement to output your name.

```scala
object GreeterApplication extends App {
  val name = "Adam"
  println(s"Hello $name!")
}
```

Re-run your application, you should now see that this says your name. Awesome!

::**Tip:** we've chosen to use a val as it is immutable, this means that once we have set the value to *name*, it cannot be changed/mutated::


#### Implementing our first function

We're going to move part of our code into a *pure* function, there are many reasons why we use functions in programming, some of these are:

* Reusability / DRY (Don't repeat yourself)
* Abstraction / encapsulation
* Scoping

::**Tip**: What is DRY?::
> A basic strategy for reducing complexity to manageable units is to divide a system into pieces.  

You will use a lot of *functions* / class *members* in object-orientated programming!

**Further reading**
[3 Key Software Principles You Must Understand](https://code.tutsplus.com/tutorials/3-key-software-principles-you-must-understand--net-25161)
[Functional Programming: Pure Functions — SitePoint](https://www.sitepoint.com/functional-programming-pure-functions/)
[object-oriented programming Tutorials by Envato Tuts+](https://code.tutsplus.com/tutorials/search/object-oriented+programming)

Let's implement our first function

```scala
package app

object GreeterApplication extends App {

  def greet(name : String) : Unit = println(s"Hello $name")

  val name = "Adam"
  greet(name)
}
```

Run your program again and you should see the same result to the console.

To recap, we declare our function by using the keyword `def` followed by the name of the function `greet`. We've then declared our function arguments inside the `()` parenthesis. Our first argument we want to take in we've named `name`, and it's type is a `String`.  `name` is an immutable `val` as we haven't declared which `variable` it is in the signature. 
We could have declared this as `(var name: String)` if we wanted to be able to *mutate* their name within the function.
The functions *return type* has been declared as `Unit`. `Unit` in Scala indicates that we are going to get no value returned from the function.

**Why do you think our function has a return type of Unit?**

#### Let's make it take our name as an input from the terminal.app

In order to do this, we going to have to some how take input from the console / command line, and use this value within our function to output `"Hello Adam"`.

To achieve this, we're going to use a `class` that is available within Scala `io` package. This class is called `StdIn` *Standard Input*.

> Short for input/output (pronounced "eye-oh"). The term I/O is used to describe any program, operation or device that transfers data to or from a computer and to or from a peripheral device.  

Let's change our implementation to be as follows:

```scala
package app

import scala.io.StdIn

object GreeterApplication extends App {

  def greet(name : String) : Unit = println(s"Hello $name")

  val name = () => StdIn.readLine("What is your name? ")

  greet(name())
}
```

We have imported the `StdIn` library from Scala using `import scala.io.StdIn`, this allows our application to use functionality that is published by another language / developer. We aren't concerned what the implementation of `StdIn.readLine()` is, only that is reads input from the command line for us. This is one of the benefits of `abstraction` as mentioned above.

::**Tip**: You can import the library by starting to type StdIn and pressing your Alt + Return/Enter key inside of IntelliJ IDEA::

We have changed our `val name = "Adam"` to become an expression, this expression is an *anonymous* function  which when called reads from the console once the user enters a value into the prompt.

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-16%2011.48.17.png)

When you hit return, this will invoke the `readLine()` function and return the value entered into the immutable variable `name`.

We then pass this into our greet function as `greet(name())`. 
Have you noticed we are now calling name with a  set of parenthesis `()`?
This is because we have declared `name` to be an *anonymous* function and we store it's return value into a variable named `name`.

::**Tip**: Our application will evaluate the value of our variable name when we call name(), rather than determining the value straight away when the application starts like before. We cannot evaluate the value in name straight away, as we require input from another source first.::

We could have implemented another `def` to name our *anonymous* function something meaningful such as `def getName() = ...`. However, Scala provides the ability to have *anonymous* functions with nice syntactic sugar with the `=>` syntax.

::**Tip**: You will come across this syntactic sugar a lot in Scala!::

**Further reading**
[A Tour of Scala: Anonymous Function Syntax | The Scala Programming Language](http://www.scala-lang.org/old/node/133)

#### Let's get this code into our repository on github.com

We will want to create a new repository on github.com. You can do this by visiting github.com, logging in, and creating a *New repository* using the + icon next to your profile icon.

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-16%2013.02.12.png)

You will want to create a repository using settings similar to the following:

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-16%2013.03.57.png)

Take note of the *Add .gitignore: Scala* option and the license.

Once you have created the repository, you will want to get the SSH URL from the GitHub repository you have just created. This can be found here:

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-16%2013.05.09.png)

Copy the value to your clipboard, *Ctrl + C* or *Click copy to clipboard*.

We are now ready to add this remote to our local git repository that you created earlier by performing `git init`.
At the *root* of your local git repository you will want to run the following command `git remote add origin git@github.com:adamconder/Greeter.git` You will want to remove the value after *origin* with the value on your clipboard.

You can verify this worked by running `git remote -v` which should give you the following on your terminal.app:

![](2-%20Greetings/2-%20Greetings/Screenshot%202017-11-16%2013.09.02.png)

Now that we have pointed our local git repository to our remote, we can commit our code again and push this up!

Are you still on that branch? If not, create a new branch locally by doing `git checkout -b greeter`. This will create a new branch and you can check if you have any outstanding changes by doing `git status`. This will show if you have any untracked/ uncommitted code.

We can then commit out code with `git add --all` and then `git commit -m "Add greeter class and abstract into a greet function`.
We're now ready to push our changes. We can do this by running `git push -u origin greeter`. 

This will push your changes to github.com, you can now view your branch on github.com with all of your changes.
We *could* now raise a Pull Request to get these changes into the *master* branch but we will do that a little bit later.

::**Tip**: You should commit little and often!::

> Developers who work for long periods -- and by long I mean more than a day -- without checking anything into source control are setting themselves up for some serious integration headaches down the line.  

**Further reading**
[Check In Early, Check In Often](https://blog.codinghorror.com/check-in-early-check-in-often/)

#### Let's introduce our first conditional expression

Now we are going to introduce our first condition expression, the simplest form of this in Scala and most programming languages is a `if (then) {} else {}`. This is known as an *if* statement.

Adapt out code to be like this:

```scala
package app

import scala.io.StdIn

object GreeterApplication extends App {

  def greet(name : String) : Unit = {
    if (name.toLowerCase.contains("adam")) {
      println(s"You don't get a hello!")
    } else {
      println(s"Hello $name")
    }
  }

  val name = () => StdIn.readLine("What is your name? ")

  greet(name())
}

```

Inside of our `greet` function we have introduced an *if statement* which checks if the name provided contains the *String* **Adam**. If it does, we are then going to print out *You don't get a hello!*, otherwise, it prints `Hello $name`.

Why do you think we have called `toLowerCase()` on our name String? What happens if you enter `Adam test` as the name on the console?

Now, commit your code again with a meaningful commit message.

#### Introduction to classes / objects

> Go and grab a cup of tea ☕️!  

In object-orientated programming, a class is a *blueprint* / *template* in order to create objects. It allows you to model your *domain* i.e. Person(s) in a real-world context. 

Classes can have *properties*, these are variables that are *scoped* to  that Class you're creating. An example of this could be a *Person class* could have a  *name* property. 
Classes can also contain *methods*, this is another term of referring to functions that belong to a class.
On the other hand, an *object* is an **instance** of our *Class* which has real values instead of variables.

> A class is a blueprint for objects. Once you define a class, you can create objects from the class blueprint with the keyword new. Through the object you can use all functionalities of the defined class.  

**Let's look at some real code as an example!**
Above our Object `GreeterApplication` below our `import scala.io.StdIn` we can add the following:

```scala
class Person(name : String) {
	def speak() : String = {
     if (name.toLowerCase.contains("adam")) {
       s"You don't get a hello!"
     } else {
       s"Hello $name"
     }
   }
 }
```

Here we are creating a *Person* class which contains a *method* named `speak()` which when called is going to return a String of "Hello $name". As you will noticed our *Person* class has a *constructor*, denoted by the `()` parenthesis which accepts one argument of `name : String`. This is also known as a *property* as we discussed earlier.

You can now remove your `greet()` function as we have *refactored* this into the Person class. We can now also evaluate our `name` variable as soon as the application starts as we want to pass this value as an argument to our Person constructor.

```scala
val name = StdIn.readLine("What is your name? ")
```

Now that we have a  Person class, we are going to want to *instantiate* (create an instance) of our blueprint into a concrete object.
You could achieve this by using the `new` keyboard.

```scala
val person = new Person(name)
```

After we have instantiated our Person class, we can call the `speak()` method and make it return our String which will say *Hello Adam.*
This can be done by adding `println(person.speak())` **after** you have instantiated the Person class with the *new* keyword.

This is what your code should look like so far:

```scala
package app

import scala.io.StdIn

class Person(name : String) {
    def speak() : String = {
      if (name.toLowerCase.contains("adam")) {
        s"You don't get a hello!"
      } else {
        s"Hello $name"
     }
  }
}

object GreeterApplication extends App {
  val name = StdIn.readLine("What is your name? ")
  val person = new Person(name)
  println(person.speak())
}
```

~Phew!~ We have just implemented our first ever Class, which has a method. You've *got this*  Object-oriented programming thing (OOP)! 

**Further reading**
[Scala Classes & Objects](https://www.tutorialspoint.com/scala/scala_classes_objects.htm)

#### Let's refactor our StdIn.readLine()

We're going to refactor our `StdIn.readLine()` implementation inline with object-orientated paradigms for X reasons:

* To ensure we encapsulate external libraries, as to remove the complexity of third party libraries from our code
* To abstract our implementation so that it is reusable

We can do this by implementing a *Singleton* Class in Scala denoted by the `Object` keyword.

Also known as the Single pattern:
> This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.  

**Further reading**
[Design Patterns Singleton Pattern](https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm)

We are going to implement the following *Singleton* Class above our `class Person()`:

```scala
object Prompt {
  def ask(message: String) = StdIn.readLine(message)
}
```

As you can see, by encapsulating the third party library `StdIn` within our Singleton class, we remove the complexity of the API that is provided by Scala, *yes, in this case the implementation is rather simple! It won't always be.*

We can then refactor our call to `StdIn` inside of our `GreeterApplication` to now become:

```scala
object GreeterApplication extends App {
  val name = Prompt.ask("What is your name? ")
  val person = new Person(name)
  println(person.speak())
}
```

Now, run your code again and you should see the same result.
🕑 Now is a good time to commit our code!

#### Let's add another Data Type to our Person class

We're now going to introduce a new Data Type to our Person class, let's collect the person's age!

Change your Person Class constructor to have the following:

```scala
class Person(name : String, age : Int) { ... }
```

This will now require two arguments to be supplied to the constructor when we instantiate this class.

There are further Data Types that can be used, an example of these are `Boolean`, `Double`, `Float` etc.

**Further reading**
[Scala Data Types](https://www.tutorialspoint.com/scala/scala_data_types.htm)

Now that we require the Persons age, we're going to have to ask this in a prompt. Change your implantation of your `App` to be the following:

```scala
object GreeterApplication extends App {
  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("How old are you? ")

  val person = new Person(name, age.toInt)
  println(person.speak())
}
```

This will now ask the user for their age straight after they have provided their name, we then use this value when we instantiate our Person class `new Person(name, age.toInt)`. As you notice we are changing the type of our `age` immutable variable to be of type `Int`.

::**Note**: Take a look at the implementation of toInt() by holding Ctrl and clicking toInt. This will open the Scala docs for you. Do you notice it will throw an Exception? Why do you think this is?::

We can now also refactor our `speak()` method to be the following:

```scala
  def speak() : String = {
    if (name.toLowerCase.contains("adam")) {
      s"You don't get a hello!"
    } else {
      s"Hello $name, you are $age years old"
    }
  }
```

Re-run your application and try entering the following values for their age:

* 1
* 20
* X

Did you notice what happened? There were two issues:

* 1 outputs the following string '1 years old' this should be singular not plural. i.e. 'year' old
* An exception is thrown when we enter X years old

For input *X*, you will see an exception similar to the following:

```bash
Exception in thread "main" java.lang.NumberFormatException: For input string: "x"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)

...
```

We will resolve this later on so that it doesn't throw the exception, we will validate the input from the console.

Let's fix the *bug* 🐞 that we have where it outputs `you are 1 years old` so that it says `you are 1 year old`.

The simplest solution we can implement it to introduce a private method called `years()` inside of our `Person` class.

`private def years : String = if(age > 1) "years" else "year"`

We can then refactor our `speak()` method to call `years()` within our string.
Attempt this yourself, if not your tutor will be able to support.

**Further reading**

We have used the *private* keyword to denote that this class method can only be accessed within the *scope* of the class. We cannot call the method directly on our object/instance of `Person`. 
This is known as access modifiers:
[Scala Access Modifiers](https://www.tutorialspoint.com/scala/scala_access_modifiers.htm)

- [x] Collect age from prompt
- [x] Store Int
- [ ] Validate age above 0
- [x] Print out the users age
- [x] Single or plural 'year(s)' old
- [ ] Validate input from console

☕️ Commit your code and take a break.

#### Add BankAccount to Person class

In this section we're going to introduce another property to our Person class, we're going to make our Person class have a `BankAccount` which will hold their current balance, allow them to withdraw and deposit depending on the type of their account.

This section is going to introduce:

1. Inheritance
2. Polymorphism

**Further reading**
[Java Polymorphism](https://www.tutorialspoint.com/java/java_polymorphism.htm)
[Java Inheritance](https://www.tutorialspoint.com/java/java_inheritance.htm)

To start off we're going to want to introduce an *abstract class BankAccount* which is what we're going to use to store the users *balance* and *account number*.

Our *abstract class BankAccount* with have two methods, `def withdraw(amount: Double)` and `def deposit(amount: Double)`  both with a return time of our own *custom* type alias `Balance`.

> A class which contains the abstract keyword in its declaration is known as abstract class.  
> Abstract classes may or may not contain abstract methods, i.e., methods without body.  
> If a class is declared abstract, it cannot be instantiated.  
> To use an abstract class, you have to inherit it from another class, provide implementations to the abstract methods in it.  

In order to instantiate an abstract class *using the new keyword*, we must *extend* from this class and create a new Subclass which will implement the abstract methods provided.

The example below shows how to declare and abstract class. It also demonstrates Type aliases within Scala which allows us to *rename* a Type to a more meaningful/verbose alias.

**Further reading**
[Scala type examples (type aliases and type members) | alvinalexander.com](https://alvinalexander.com/scala/scala-type-examples-type-aliases-members)
[Java Abstraction - Abstract class](https://www.tutorialspoint.com/java/java_abstraction.htm)

Let's implement the following:

```scala
object AccountTypes {
  type AccountNumber = String
  type Balance = Double
}

abstract class BankAccount(accountNumber : AccountTypes.AccountNumber,
                           balance: AccountTypes.Balance) {
  def withdraw(amount : Double) : AccountTypes.Balance
  def deposit(amount : Double) : AccountTypes.Balance
}
```

By using the `abstract` keyword before our `class BankAccount` we have explicitly stated that `BankAccount` must be extended by a subclass. This subclass, for instance `SavingsAccount` will implement the `withdraw()` and `deposit()` methods.

**What happens if you try to instantiate an abstract class?**

We're now going to implement our first *subclass*. We will create a class named `SavingsAccount` that will **extend** off BankAccount and provide the implementations for `withdraw()` and `deposit()`.

```scala
final class SavingsAccount(accountNumber: AccountNumber,
                           balance: Balance) extends BankAccount(accountNumber, balance) {
  override def withdraw(amount: Balance): Balance = {
    0.00
  }
  override def deposit(amount: Balance): Balance = {
    0.00
  }
}
```

As you can see in the code snippet above, we have implemented a `final class SavingsAccount()` which *inherits* from `BankAccount` and provides the implementation for `BankAccount`. `SavingsAccount` is known as a *subclass* and this pattern in object-orientated programming is  known as **inheritance**.

Did you notice the `final` keyword? Similar to the `private` keyword we used earlier, this is an access modifier as discussed before, however, it now means that we cannot **extend** from SavingsAccount, for example, we can't have `final class TaxEvadingSavingsAccount() extends SavingsAccount()` as we have declared `SavingsAccount` as **final**.

**Further reading**
* [Scala Access Modifiers](https://www.tutorialspoint.com/scala/scala_access_modifiers.htm)

::**Tip**: Access modifiers are commonly used, if we were developing a library for another application, we may not want them to modify our implementation. For example, if we were PayPal we wouldn't want any old person changing how we change a CreditCard!::

~Task~
Now, I would also like you to implement a `final class CashISAAccount`  which **inherits** from `BankAccount` and provides the implementation to the `deposit()` and `withdraw()` methods. 

##### Let's implement the logic for our SavingsAccount and CashISAAccount

::**Tip**: I would always recommend following a Test-driven development approach when building your applications! We will cover this topic in depth later::
[Test Driven Development (TDD): Example Walkthrough | Technology Conversations](https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/)




- [ ] Bank account class
- [ ] Savings subclass (allows withdraws)
- [ ] ISA subclass (doesn't allow withdraws)
- [ ] Both accounts allow a deposit, ISA has a limit (polymorphism)



~~There are two ways to pass arguments into functions, *call by name*, *call by value*.~~

## Recap

## Resources
* [Scala Variables](https://www.tutorialspoint.com/scala/scala_variables.htm)
* [What is a variable in computer programming?](https://launchschool.com/books/ruby/read/variables)
* [Git - Basic Branching and Merging](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)
* [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/)
* [3 Key Software Principles You Must Understand](https://code.tutsplus.com/tutorials/3-key-software-principles-you-must-understand--net-25161)
* [Functional Programming: Pure Functions — SitePoint](https://www.sitepoint.com/functional-programming-pure-functions/)
* [object-oriented programming Tutorials by Envato Tuts+](https://code.tutsplus.com/tutorials/search/object-oriented+programming)
* [Scalacheat | Scala Documentation](https://docs.scala-lang.org/cheatsheets/)
* [Check In Early, Check In Often](https://blog.codinghorror.com/check-in-early-check-in-often/)
* [Scala Classes & Objects](https://www.tutorialspoint.com/scala/scala_classes_objects.htm)
* [Design Patterns Singleton Pattern](https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm)
* [Scala Data Types](https://www.tutorialspoint.com/scala/scala_data_types.htm)
* [Scala Access Modifiers](https://www.tutorialspoint.com/scala/scala_access_modifiers.htm)
* [Java Polymorphism](https://www.tutorialspoint.com/java/java_polymorphism.htm)
* [Java Inheritance](https://www.tutorialspoint.com/java/java_inheritance.htm)
* [Scala type examples (type aliases and type members) | alvinalexander.com](https://alvinalexander.com/scala/scala-type-examples-type-aliases-members)
* [Java Abstraction - Abstract class](https://www.tutorialspoint.com/java/java_abstraction.htm)
* [Test Driven Development (TDD): Example Walkthrough | Technology Conversations](https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/)
