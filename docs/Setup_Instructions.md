# Setup Instructions

## JDK Version Used
OpenJDK 21.0.11 (installed via Homebrew on macOS)

## Installation Steps

1. Install Homebrew (if not already installed):
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```

2. Install OpenJDK 21:
   ```bash
   brew install openjdk@21
   ```

3. Add JDK to PATH:
   ```bash
   echo 'export PATH="/opt/homebrew/opt/openjdk@21/bin:$PATH"' >> ~/.zshrc
   source ~/.zshrc
   ```

4. Verify installation:
   ```bash
   java -version
   javac -version
   ```

## Hello World Program

**File:** `src/com/airtribe/learntrack/Main.java`

```java
package com.airtribe.learntrack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, LearnTrack!");
    }
}
```

**Compile and run from project root:**
```bash
javac -d out src/com/airtribe/learntrack/Main.java
java -cp out com.airtribe.learntrack.Main
```

**Output:**
```
Hello, LearnTrack!
```

## How to Compile and Run the Full Project
```bash
find src -name "*.java" -print | xargs javac -d out
java -cp out com.airtribe.learntrack.Main
```
