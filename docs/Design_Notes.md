# Design Notes

## Why ArrayList

Arrays need a fixed size upfront which doesn't work here since I don't know how many students or courses will be added. ArrayList grows on its own so it made more sense.

## Static members

Used static in IdGenerator for the ID counters. Made them static so there's one shared counter across the whole program. If it wasn't static each object would start from 0 again and IDs would repeat.

## Inheritance

Person is the base class with common fields like id, firstName, lastName and email. Student and Trainer both extend it so I didn't have to repeat those fields in both classes. Also overrode getDisplayName() in both to return different output which is polymorphism.
