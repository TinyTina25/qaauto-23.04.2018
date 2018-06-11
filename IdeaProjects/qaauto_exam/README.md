###Project info
Project created for running  test which check google.com search page
# ENVIRONMENT INSTALLATION
## JDK INSTALLATION
1. Go by link [http://www.oracle.com/technetwork/java/javase/downloads/](http://www.oracle.com/technetwork/java/javase/downloads/)
2. Click on JDK latest version download button
3. Launch downloaded .exe file
4. While installation don't change any default options and click "Next" button on every step
5. On Last step click on 'Finish' button

## IntelliJ IDEA INSTALLATION
1. Go by link [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
2. Choose your OS
3. Click on DOWNLOAD button under Community version
4. Launch downloaded .exe file
5. While installation don't change any default options and click "Next" button on every step
6. On Last step click on 'Finish' button


## MOZILLA BROWSER INSTALLATION
1. Go by link [https://www.mozilla.org/ru/firefox/new/](https://www.mozilla.org/ru/firefox/new/) and download latest version of Mozilla browser
2. Launch downloaded .exe file and install Mozilla

## PROJECT CREATION
1. Launch IntelliJ IDEA
2. Open File dropdown menu -> Choose New -> Project...
3. In New Project pop-up window choose Java in list
4. At Ptoject SDK click New button and input path to your Java JDK for example `C:\Program Files\Java\jdk-10.0.1`
5. Choose Maven in list
6. At Ptoject SDK click New button and input path to your Java JDK for example `C:\Program Files\Java\jdk-10.0.1`
7. Click Next button
8. Fill GroupId and ArtefactId fields. Both names should be the same
9. Don't change version field
10. Click Next
11. Click Finish

### Selenium dependency creation
1. Go by link [https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
2. Click on latest version
3. Choose Maven tab
4. Click on text field
5. Open your project in IntelliJ IDEA -> pom.xml -> Paste code between tags `<dependencies> </dependencies>`

### Geckodriver installation
1. Go by link https://github.com/mozilla/geckodriver/releases
2. Choose and download archive with the latest version of geckodriver
3. Open archive and copy geckodriver.exe file
4. Go to C:\Windows\System32 and paste geckodriver.exe file

#### Project structure
Page package contains pages with described methods to use in the tests
Test package contains test, to verify Google search