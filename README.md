## Owner

- shreyashahi141189@gmail.com

## Overview
- This project added to automate the scenarios of ToDo Examples Page

## Steps To Run
- Execution starts from SerenityCucumberRunner ->picks up properties from serenity.conf file
  reads tags from features files-> glue-> steps -> page class
- Can update tags for the test case which needs to be executed ex. @test
- Similar tags needs to be added in feature files
- Or the other way is use the tag in feature file directly in SerenityCucumberRunner for execution
- The feature file splits in automation & manual folders
- Scenarios under automation folder are automated (except 2-edit & completeTaskFromList due to click issues)
- Scenarios under  manual folder are different user stories which could be automated later

  
  
  



