# JVM Basics

## JDK, JRE, and JVM — What's the Difference?

**JVM (Java Virtual Machine)** is the engine that actually runs Java programs. It reads `.class` files (bytecode) and executes them on whatever operating system it's running on. You never interact with the JVM directly — it runs silently in the background whenever you run a Java program.

**JRE (Java Runtime Environment)** is the JVM plus the standard Java libraries (like `java.util`, `java.lang`). If you only want to *run* an already-compiled Java program, the JRE is enough. End users who just run Java applications typically have the JRE installed.

**JDK (Java Development Kit)** is the JRE plus the compiler (`javac`) and other developer tools. If you're writing and compiling Java code, you need the JDK. It contains everything: the compiler, the runtime, and the libraries.

In short: JDK ⊇ JRE ⊇ JVM.

## What is Bytecode?

When you write Java code in a `.java` file and compile it with `javac`, the compiler does not produce native machine code for your specific CPU. Instead, it produces **bytecode** — a set of instructions stored in `.class` files that no real CPU natively understands.

The JVM acts as an interpreter between the bytecode and your machine. When you run `java MyProgram`, the JVM reads the `.class` file and translates the bytecode into the actual machine instructions your CPU can execute.

## Write Once, Run Anywhere

Because Java compiles to bytecode (not machine code), the same `.class` file can run on any machine that has a JVM installed — Windows, macOS, Linux, or any other platform. You compile your code once, and the JVM on each platform handles the rest.

This is what "write once, run anywhere" means: as a developer, you write and compile your Java code on one machine, and it runs identically on every other machine with a JVM, without recompiling.
