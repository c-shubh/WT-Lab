// Prototypical Inheritance ----------------------------------------------------

// Animal Constructor Function
function Animal(name) {
  this.name = name;
}

// Animal Prototype
Animal.prototype.makeSound = () => console.log("Generic animal sound");

// Dog Constructor Function
function Dog(name, breed) {
  Animal.call(this, name);
  this.breed = breed;
}

// Inheriting from Animal
Dog.prototype = Object.create(Animal.prototype);
Dog.prototype.constructor = Dog;

// Overriding the makeSound method for Dog
Dog.prototype.makeSound = () => console.log("Woof! Woof!");

// Closure ---------------------------------------------------------------------
function demoClosure(animal) {
  // Capture animal parameter
  return () => animal.makeSound();
}

// Callback --------------------------------------------------------------------
function performAction(animal, cb) {
  console.log(`Performing action with ${animal.name}`);
  cb();
}

// Promises --------------------------------------------------------------------
function performAsyncAction(animal) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log(`Async action performed with ${animal.name}`);
      resolve();
    }, 1000);
  });
}

// Async/Await------------------------------------------------------------------
async function performAsyncActionWithAwait(animal) {
  console.log(`Starting async action with ${animal.name}`);
  await performAsyncAction(animal);
  console.log(`Async action completed with ${animal.name}`);
}

// Demonstration ---------------------------------------------------------------

// Creating a Dog Instance
const myDog = new Dog("Buddy", "Golden Retriever");

// Demo closure
demoClosure(myDog)();

// Using Callback
const cb = () => myDog.makeSound();
performAction(myDog, cb);

// Using Promises
performAsyncAction(myDog).then(() => {
  console.log("Promise resolved!");
});

// Using Async/Await
performAsyncActionWithAwait(myDog).then(() => {
  console.log("Async/Await function completed!");
});
