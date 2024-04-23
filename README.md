# Shop Framework

University Semester Project. The goal was to showcase how to model a server sided shop implementation
that works independently of the user's interface, leveraging Spring Boot.
Spring provides generic api-endpoints that occur in a daily business and abstracts it to the simplest level.
This project was followed by a 30-page research paper, which is not included.

Final Grade: 1.3

# Installation Instructions

This is only a concept implementation and should not be used in a real world application!
That being said, I am providing instruction on how to run the project using IntelliJ Idea, Eclipse and as a Standalone
application.

Java 17 Is required

## IntelliJ Idea

This project should run out of the box using IntelliJ

## Eclipse

The project uses Lombok, which is not available in Eclipse by default.
The code will show errors, but it is still executable!
To get code support, follow these instructions:

1. Go to the folder ./boot/lombok
2. Run ./lombok-1.18.30.jar
3. If the current IDE is not automatically detected, select it under "Specify location..."
4. Click on "Install/Update"
5. Exit the installer
6. Restart Eclipse
7. Select the client and server modules in the Package Explorer
8. Right-click on the modules
9. Click on "Java Compiler" in the left bar
10. Click on Annotation Processing
11. Enable Annotation Processing

## Standalone

1. Go to the folder ./boot
2. Start ./start-server.jar
3. Start ./start-client.jar
