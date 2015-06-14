Given what we've currently learned about defining classes and object instantitation, we're able to represent basic object interactions in the following terms:

- [x] Create an instance of Dog called Sparky
- [x] Create an instance of Person called Steve
- [x] Create an instance of Person called Cindy
- [x] Create an instance of Kennel called kennel
- [x] Steve adopts Sparky
- [x] Sparky now changes ownership to the kennel
- [x] kennel current has no dogs
- [x] Steve decides to give up Sparky
- [x] kennel takes in Sparky
- [x] kennel now has one dog
- [x] Cindy decides to adopt a dog
- [x] Spark changes ownership to Cindy

We can otherwise convey the same information pictorially using a `UML sequence diagram` where object interactions are shown horizontally and time moves forward starting from the top of the diagram working its way downward.
![ dog and kennel sequence diagram ] (img/dogAndKennel-sequence-diagram.png)


#### So what is a UML Sequence diagram you ask?

- [ UML sequence diagram ] ( http://en.wikipedia.org/wiki/Sequence_diagram )

#### Want to see how this sequence diagram was generated? 

Checkout : [ js-sequence-diagrams ] (http://bramp.github.io/js-sequence-diagrams/)

And here is the data that was used to generate the diagram:

```
participant kennel
participant Sparky
participant Steve
participant Cindy
Steve->Sparky: Adopts a dog
kennel->kennel: display Inventory
Note left of kennel: No dogs in kennel
Steve->kennel: Gives up dog
Sparky-->>kennel: Change owner
kennel->kennel: display Inventory
Note left of kennel: Sparky is in the kennel
Cindy->kennel: Adopts a Dog
Sparky-->>Cindy: Change owner
kennel->kennel: display Inventory
Note left of kennel: No dogs in kennel
```
