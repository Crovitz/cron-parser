# Cron Parser
Cron Parser is a library for parsing and processing cron expressions.

# Run
## Build the application
``./gradlew clean build``

## Run the command
``java -jar build/libs/cron-parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"``

# Interfaces
**CronField** - represents a single field in a cron expression, such as a minutes field or an hours field.

**PrintField** - helper interface for classes that implement field printing in a cron expression.

# TODO
- More unit tests should be done, and an e2e test
- Make the number of columns as a parameter in application.yml
- Think about the possibility of using the strategy pattern
