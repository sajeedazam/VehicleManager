# License Plate Manager

***What will the application do?***
- This application allows you to add a vehicle's license plate.
- Lets you provide a unique detail (comment, model, colour, commercial or private) about the vehicle that's license
  plate has been added.
- All the added license plates can be displayed.
- The license plate's corresponding detail can be viewed.

***Who will use it?***

The use for this application is not specific to one person as this has a huge domain. It may even be used by everyone.

- *Pedestrians:* They can use it to keep track of vehicles that cause them inconvenience on the road. This could be in 
form of loud noises, poor driving or bad behaviour of the owner. These can be recorded in the comments/complaints 
section. Pedestrians can use the information and report to the local police if they wish.

- *Land/Property Owners:* In residential areas where there also offices, vehicles related to the offices tend to park 
near or around private properties whether they be there for a short time or not. These vehicles can block the entrances 
to their houses too. Land/Property Owners can use this application and report to the residential council if they wish.

- *Company Owners:* A large company owner may have a lot of vehicles to keep track of. They may use this application to 
keep track of all their vehicles and may use the comment(s) to clarify what that vehicle is to be used for and who is in 
charge of it.

- *Everyday Drivers:* Similar to pedestrians, frequent drivers can take notes of vehicles that are causing trouble to 
them on the road (if they are not maintaining road regulations, speeding, risky driving, etc). Parking manners are also 
inclusive such as parking incorrectly or parking in handicapped zones. They can also forward and report their notes to 
the local police if they wish.

- *All-Encompassing use:* Vehicle owners may keep track of their own vehicle(s). They can use this application as a 
means to remember their license plate(s). This application can also be used to cross-check if they are getting into the 
right car if it happens they parked it in a busy mall parking lot where there are a lot more similar cars parked
around it. The features included in the application is a bit more user-friendly than just writing the license plate 
number on their Notes application. Other than all these, this application is still relevant to any other use that may 
benefit the user.
 
 *Note: Use of the word **Vehicles** implies that the user can set the type of vehicle so that it shows whether the 
 vehicle is of type truck / sedan / bike. The domain of vehicles excludes public transportations such as buses and taxis 
 unless the user finds a use of it in any other way. Furthermore, this application does not do a check on the license 
 plate number as this is for global use, in other words, different countries have different kinds of license plate with 
 varied use of digits, letters (including different language's letters) or even words. Hence, the license plate will be
 stored as a string.* 
 
 ***Why is this the project of interest?***
 
 Traffic, road safety or road vehicles in general are becoming a huge issue as time is passing by. Although this 
 application would not alter that a lot, but it still may cause a positive impact of sorts if anything. However, this
 application may always be used regardless; for practical use too.
  
## User Stories (Phase 1)

- As a user, I want to be able to add as many license plates as I want.
- As a user, I want to be able to declare what colour and type (bike / sedan / truck) of vehicle it is as a unique
 detail.
- As a user, I want to be able to add the model of the vehicle. (Toyota, Nissan, etc.) as a unique detail.
- As a user, I want to be able to declare whether the vehicle is of private or commercial use as a unique detail.
- As a user, I want to be able to add comments/complaints about the vehicle as a unique detail.
- As a user, I want to be able to view my license plate's corresponding information.
- As a user, I want to be able to view all my added license plates.
- As a user, I want to be able to close the application after I am done.

## User Stories (Phase 2)

- As a user, I want to be able to save all my added license plates.
- As a user, I want to be able to load all my added license plates.

## User Stories (Phase 3)

- As a user, I want to be able to see how many plates I have *currently* added. (only for GUI)

## Phase 4: Task 2 and 3

- Made LicensePlateList class robust by adding an exception and testing it according to task 2.
- For the UML, all the associations for each class is as follows:
- VehicleAttributes: This class does not have any object(s) of any class but implements the Writeable interface.
- LicensePlateList: This class has a List of VehicleAttributes and implements the Writeable interface. It may be argued 
that VehicleAttributes should have been initialized as an object, but it is made as a list so that the user is able to 
add multiple comments if they want to (which adheres to the design). Hence, a list is used so that the user may still 
have that option but this user story is not explicit.
- AllPlates: This class has a list of LicensePlateList so that it can be used to display all the license plates. It also
implements the Writeable interface.
- JsonReader: This class does not use any model class.
- JsonWriter: This class does not use any model class.
- Writeable: This is an interface that does not have any other objects or implementations.
- LicensePlateManager: This is in the ui class, so it makes use of all the model classes.
- Swing: Same as the LicensePlateManager it uses all the model classes. As the GUI uses a pop up window that displays 
all the plates and attributes it calls the ShowPlateGui class zero or multiple times therefore it has an association 
with the ShowPlateGUI class.
- ShowPlateGUI: This class does not call any object(s) that are not from the Java library.
- ***Any changes that could be made:*** The Swing class could extend the LicensePlateManager so that it could make use of 
its fields as both classes have almost the same classes initialized as objects.