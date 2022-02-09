# Selenium-with-Tessaract-OCR

This template will help you to test the content of an image(basically, text in the image) using a combination of selenium and tesseract. So that, we can verify the content present in the image and make image testing a part of our selenium test automation script.


## Steps for Execution.

1. Clone the repository 

`git clone https://github.com/knoldus/Selenium-with-Tessaract-OCR.git`

2. Move into the directory and exeute this command with appropriate inputs for Web Driver and it's location.

`export DRIVER=<Your Driver name goes here, execute this command without '<>'>`
`export DRIVER_PATH=<Your Driver path goes here, execute this command without '<>'>`

3. To run the tests:

`mvn clean -Dtest=ImageTesting test`

Note:- For Linux users, it is recommended to have tesseracr OCR installed on your local machine. Please execute the command mentioned below to install it.

`sudo apt-get install tesseract-ocr`


## Technologies used

**Programming Language** - JAVA

**Build tool** - Maven

**Automation tool** - Selenium

**IDE** - Intellij

**Image Recognition** - Tesseract OCR

**Logger** - log4j



For a better understading and for some more insights, please refer to this blog
https://blog.knoldus.com/selenium-with-tesseract-image-testing/
