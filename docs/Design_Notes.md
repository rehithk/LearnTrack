# Design Notes

## Why ArrayList instead of Array

Arrays in Java have a fixed size — you have to decide upfront how many elements they can hold. In a student management system, we don't know in advance how many students or courses will be added, so a fixed-size array would either waste memory or run out of space.

`ArrayList` is dynamic — it grows automatically as we add elements. It also provides built-in methods like `add()`, `get()`, and `size()` which make working with collections much simpler. For these reasons, `ArrayList` is the right choice whenever the number of items is not known ahead of time.

## Where Static Members Are Used and Why

Static members are used in `IdGenerator` (`util/IdGenerator.java`):

```java
private static int studentIdCounter = 0;
private static int courseIdCounter = 0;
private static int enrollmentIdCounter = 0;
```

These counters are `static` because they need to be shared across the entire program — not tied to any specific object. Every time a new student is created, `getNextStudentId()` is called and returns a unique, incrementing ID. If these were instance variables, each `IdGenerator` object would have its own counter starting from 0, which would produce duplicate IDs.

Static is the right choice here because the ID counter is a property of the system, not of any individual object.

## Where Inheritance Is Used and What Was Gained

Inheritance is used in the entity layer:

- `Person` is the base class with common fields: `id`, `firstName`, `lastName`, `email`
- `Student extends Person` — adds `batch` and `active`
- `Trainer extends Person` — adds `expertise`

**What we gained:**

1. **No duplication** — `id`, `firstName`, `lastName`, and `email` are defined once in `Person`. Without inheritance, we'd have to copy those fields and their getters/setters into both `Student` and `Trainer`.

2. **Polymorphism** — Both `Student` and `Trainer` override `getDisplayName()` from `Person`, returning a different format. This means we can call `getDisplayName()` on any `Person` reference and get the correct output for the actual type.

3. **Extensibility** — If we add more person types in the future (e.g., `Admin`), they can extend `Person` and immediately inherit all common behavior.
