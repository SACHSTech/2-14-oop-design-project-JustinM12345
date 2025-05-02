[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LXtbW2-T)
# ICS4U OOP Design Project

See instructions [here](INSTRUCTIONS.md) for details.

*INSERT UML CLASS DIAGRAM HERE*  

# Swimmer Mangement System / Swim Meet Manager 

## Summary

This project is a Swimmer Management System designed to track swimmers, their swim events, and their swimming history. 

The program calculates a swimmer's fastest swims, their potential to go professional, and organizes swimmers by events and times.

## Current Features
- Manage swimmers and their personal details (name, birth year, country, etc.).
- Track swimmers' fastest swims for various events.
- Sort swimmers' swim history from fastest to slowest.
- Create fully proper and detailed heatsheets given a list of swimmers
- Determine if a swimmer has the potential to go professional based on their best swim times and age.
- Currently fully implements swim events 100m and 200m freestyle

## Classes

### Person

### Swimmer

### Swim

### Event

### SwimEvent (Enums)

### SwimFileReader

### TimeConverter

## Main
Now putting it all together, the main.java file contains a display of all the program's features. In the order of things it outputs...

## Conclusion

## Credits
Developed by Justin Mui :)

## Future Ideas
- Update classes and methods for events beyond 100m and 200m freestyle
- Implement benchmarks for more events
- Create a club feature, so swimmers can be categorized as part of a club
- Implement lane organization for fastest to slowest (eg fastest swimmers in lanes 4 and 5) + limit heat size and have 8 swimmers per heat, etc