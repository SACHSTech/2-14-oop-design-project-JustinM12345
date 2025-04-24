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

Focus on a single individual event for now
- Each swimmer can have a list of times for that event, the object will have a method to search for their best time, maybe list their times from best to worst/recent to oldest
- Event will generate heat sheet with their best times on the side
- Swimmers will have their favourite swim listed
- Be able to see how many swimmers are swimming their favourite event

Person
- Has general info about the person
- Name, age, gender, height, nationality

swimInfo
- swimInfo(SwimmerID, eventName, date swam, time)
- getters for each

swimTimes
- collection of swimInfos for a swimmer
- getFastestTime, swimmer can have multiple times for same event, get fastest time
- getSwimsForEvent, get the swims for a specific event
- getAllSwims, lists every swim the swimmer ever swam

clubInfo
- swimmers are part of a club
- 

Swimmer
- Inherits from person object
- swimmerID, What club they are from, favourite event
- getAgeGroup
    - 10 and under, 11-12, 13-14, 15-16, 17-18, 18+
- IsSwimmingFavourite
- Swimmer will have a collection of swimTimes

Event
- Name of the event (100 freestyle)
- Has a collection of swimmers that are going to swim that event
- Produce psych sheets, lists swimmers from fastest to slowest with their best times listed on the side
- How many swimmers are swimming their favourite swim
- How many swimmers are enrolled
- Have a way to sort by senior and junior swimmers?


