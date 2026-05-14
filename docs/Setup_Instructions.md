# Setup Instructions

## JDK Version

OpenJDK 21.0.11 installed via Homebrew on macOS.

```bash
brew install openjdk@21
echo 'export PATH="/opt/homebrew/opt/openjdk@21/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

Verify:
```bash
java -version
javac -version
```

## Hello World

```java
package com.airtribe.learntrack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, LearnTrack!");
    }
}
```

```bash
javac -d out src/com/airtribe/learntrack/Main.java
java -cp out com.airtribe.learntrack.Main
# Output: Hello, LearnTrack!
```
