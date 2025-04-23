[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LXtbW2-T)
# ICS4U OOP Design Project

See instructions [here](INSTRUCTIONS.md) for details.

*INSERT UML CLASS DIAGRAM HERE*  

## Summary
*Write a brief summary that describes the real-world system you are modelling in your design.*

Swim Meet Manager

SwimEvents
- Possible enum for the swimming events to make things easier
- 50, 100, 200, 400, 800, 1500 freestyle
- 50, 100, 200 backstroke
- 50, 100, 200 breaststroke
- 50, 100, 200 butterfly
- 100, 200, 400 individual medley

Person
- General info about person
- Gender, age, height, name, nationality

eventTime
- eventTime(String stroke, Int distance, String time)
- Maybe use enums for all the different types of events

SwimmerInfo
- Collection of a swimmer's best times in each event
- Store the info as eventTime objects

Swimmer
- General info about swimmer, inherits from person
- Favourite stroke, enrolled events, favourite event, favourite distance, swimmerInfo
- Has unique methods for the meet
- IsSwimmingFavourite event
- IsSwimmingFavourite stroke
- Is swimming back to back events

SwimMeetInformation
- General info setting up the swim meet
- Meet name, competition date, 
- Contains collection swimmerList
- Needs to have an event lineup 
- Maybe create a method that can create the heat sheets for each event
    - Have name of event, then list all swimmers sorted by speed, swimming that event

SwimmerList
- A collection of the swimmers at the competition
- get total number of swimmers
- get total number of swimmers in each event
- get values for number of swimmers of each age, etc


Focus on a single individual event for now
- Each swimmer can have a list of times for that event, the object will have a method to search for their best time, maybe list their times from best to worst/recent to oldest
- Event will generate heat sheet with their best times on the side
- Swimmers will have their favourite swim listed
- Be able to see how many swimmers are swimming their favourite event