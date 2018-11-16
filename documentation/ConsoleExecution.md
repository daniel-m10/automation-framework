# How to execute scenarios by console

1. Open the terminal in your IntelliJ
2. The actual task that execute UI scenarios is "executeUIFeatures". Also inside the command you have to send the environment to use (variable name is "environmentName") and the browser name (variable name is "browser")in upper case: e.g: CHROME, FIREFOX, INTERNET_EXPLORER. So the command would be:
```sh
gradle clean executeUIFeatures -PenvironmentName="QA" -Pbrowser="CHROME"
```
3. If you want to execute just specific scenarios, You can do it by using the scenarios tag and using "cucumberOptions" variable in the command this way:
```sh
gradle clean executeUIFeatures -PenvironmentName="QA" -Pbrowser="CHROME" -PcucumberOptions="--tags @qeauto_2046"
```
The command above will execute all scenarios that have the tag: "@qeauto_2046". It is also possible to send more than one tags at the same time
```sh
gradle clean executeUIFeatures -PenvironmentName="QA" -Pbrowser="CHROME" -PcucumberOptions="--tags @tag1,@tag2,@tag3"
```
