# Elon Musk Chat Bot
## Updates For The Individual Project
Since Assignment 3 I have added new features and also enhanced some quality of life features to our chatbot. 
Additions include:
- We added the ability to use the Wolfram Alpha API so we can make queries to get a answer when our bot does not have an appropriate response.
- We added the ability to use the Google Translate API so the bot can understand multiple languages and respond back in the appropriate language.

---------------------------------------

## Purpose
- The purpose of this project was for COSC 310 "Software Engineering".
- We created a chatbot that can answer some questions about Elon Musk and other topics.
- We used a chain of if else statements that when a word is recognized from a sentence it will get the appropriate response from a 2D array.

---------------------------------------

## Compile And Run
- To be able to run our code you will need to download the stanford core nlp toolkit and put it in the class path of the project. We had to do this because of limiting space on github.
- The same goes for Junit testing
- You also have to include these jars to get the Wolfram API functioning: WolframAlpha-1.1.jar, commons-codec-1.3.jar, httpclient-4.0.1.jar, httpcore-4.0.1.jar, commons-logging.jar.
- You will require the Google cloud library so you can run the google translate API.
- To compile and run this code clone the repository then you will have a jar file that you can run to open up our application.
- It will require the API keys, which can be given upon request. 

---------------------------------------

## Contributors
- Emiel van der Poel
- Nathan Pelmore
- Garrett Cook
- Benjamin Keeley
- Taylor Regier

---------------------------------------
---------------------------------------
## Code Documentation (Part of Assignment 2)
![image4](https://user-images.githubusercontent.com/75397522/111886188-a06db000-8989-11eb-8a34-b567d3314c41.png)

***Figure 1:*** Main class:

The only purpose of the main class is to instantiate a new Window, which is our chatbot and its functionality.

![image8](https://user-images.githubusercontent.com/75397522/111886198-acf20880-8989-11eb-9156-c3cea4bb7f9c.png)

***Figure 2:*** Importing required packages and creating a graphical user interface (gui):

The purpose of this section of code is to import the required packages to make our gui and its desired settings.

![image3](https://user-images.githubusercontent.com/75397522/111886200-b3808000-8989-11eb-873b-617e488297ee.png)


***Figure 3:*** 2d array of responses:

The purpose of this code is to have a 2d array that acts as a cache to our responses. We will access the specific element in this array by looking at the words sent by the user. 

![image2](https://user-images.githubusercontent.com/75397522/111886205-b7140700-8989-11eb-9d4b-ed6a54d3ca63.png)


***Figure 4:*** Constructor for our Window class:

The purpose of this constructor is to set all parameters of our graphical user interface(gui). We sat its name, size, how it closes, an icon image, set a gif in the gui, set background color, set font, and set desired areas of our gui to function as text areas.

![image6](https://user-images.githubusercontent.com/75397522/111886211-bc715180-8989-11eb-8abe-d2d2f358cfe2.png)


***Figure 5:*** keyPressed method:

The purpose of this method is to look for keys being entered by the user. If the user presses the enter key to submit their question the input text area will deactivate so the user cannot enter any more information. It will then take the input message and send that message to the addText function, which will add it to the main text area where the conversation will occur. We will that detect if the message contained a ???????, which then will set a question boolean value to true. If the message sent contains any punctuation the code will replace the punctuation with a space. We then trim the message from the whitespaces at the end and at the beginning. We then make the message lowercase so the case does not affect the outcome. Then send our message and our question boolean to the response method.

![image5](https://user-images.githubusercontent.com/75397522/111886214-c09d6f00-8989-11eb-9692-b70878ea5f9e.png)


***Figure 6:*** keyReleased method:

The purpose of this method is to make the input text area editable again once the enter key was released.

![image7](https://user-images.githubusercontent.com/75397522/111886216-c4c98c80-8989-11eb-8357-26c604e4ceb1.png)


***Figure 7:*** addText method:

The purpose of this method is to take a string and add it to the main conversation text area.

![image1](https://user-images.githubusercontent.com/75397522/111886224-cabf6d80-8989-11eb-9f32-232f33ab6317.png)


***Figure 8:*** response method:

The main purpose of this method is to split the message string into an array of its individual words. It will then check the words contained in this array to grab the correct bot response from the response 2d array shown above. Then we check if the question boolean value was true and we generate a random number to check if it equals a specified number and if both cases are true our bot will tell the user that their question was a good question. If the user sent ???q??? we sent a message saying that the chat has ended.

---------------------------------------
# Implementations (Part of Assignment 3)
---------------------------------------

## Named Entity Recognition (*Stanford toolkit*)
---------------------------------------

We implemented Named Entity Recognition so our chat bot would recognize if we are using a name of someone, which he would then remember and could reply using that name. Or you could give him a list of places and he would be able to recognize them. You can see this from the examples below.

![namedEntities](https://user-images.githubusercontent.com/75397522/111888896-03694200-899e-11eb-9e77-4725305d9f89.PNG)


***Figure 9:*** Named Entities Example:

If you introduce yourself with your name and your name is a recognized entity. Elon will say you have a nice name. Grimes response is now triggered if the entity grimes is detected along with others ie Tesla. On the right recognized entities are listed

![places](https://user-images.githubusercontent.com/75397522/111888928-37dcfe00-899e-11eb-9ecc-5623d7bed507.PNG)

***Figure 10:*** Places Visited Example:

You can ask elon where he has been, listing places. Elon will randomly select a recognized entity and then give a general response about it.

---------------------------------------

## Coreference Resolution (*Stanford toolkit*)
---------------------------------------

We implemented Coreference resolutiong so we are able to say a name like "Jeff Bezos" then we can later on in another sentece refer to him as a he and our bot will understand it. This limits redundency in our conversation with our bot.

![image](https://user-images.githubusercontent.com/75397522/112570314-0baced00-8da3-11eb-85fa-f0891707a98e.png)

***Figure 11:*** Sample Chat Output with multiple questions

![image](https://user-images.githubusercontent.com/75397522/112570386-2f703300-8da3-11eb-9ae5-d0540cd914eb.png)

***Figure 12:*** Sample Chat Output with a Name Then Referencing by He/She/Him/Her

---------------------------------------

## Sentiment analysis tools (*Stanford toolkit*)
---------------------------------------
We used Sentiment analysis to see how the user was feeling. Depending on if the user was positive or negative the bot would respond with something referring to his positivity or negativity then he would send the appropriate response from our responses.

![310](https://user-images.githubusercontent.com/75397522/112517084-26f10b80-8d55-11eb-9bae-15dbd5d3ce4d.PNG)

***Figrue 13:*** Sample conversation 

From this sample conversation you can see that Elon detected that the sentence was positive and he gave a response referencing that, then he sent the appropriate response. Below that you can see that the console shows that the sentence was positive, what it sent a variable to, and the sentence it was testing.

---------------------------------------

## Sockets
---------------------------------------
To engage a socket conversation you must type in SocketSTUFF (case sensitive) to prep the bot to receive a connection

![image](https://user-images.githubusercontent.com/75397522/112515502-8cdc9380-8d53-11eb-9f3e-9c495dd69b8e.png)

***Figure 14:*** Sample of Receiving a Connection

![image](https://user-images.githubusercontent.com/75397522/112515676-b5fd2400-8d53-11eb-842c-a849f48aafe2.png)

***Figure 15:*** Sample output of a socket conversation

Client can converse with Elon normally, typing input in the console and receiving Elonbots output. Press q to close communications

![image](https://user-images.githubusercontent.com/75397522/112515840-e1800e80-8d53-11eb-8a5b-1085ac26f9e3.png)

***Figure 16:*** Client Side Socket Code

![image](https://user-images.githubusercontent.com/75397522/112515860-e80e8600-8d53-11eb-98b9-01b70a5f2d8f.png)

***Figure 17:*** Server Side Socket Code

---------------------------------------

# Individual Project

---------------------------------------

## Wolfram Alpha API

---------------------------------------

To help our bot so it is able to respond when he does not know the appropriate subject matter we used the Wolfram Alpha API to query and get a result to our question.

![310](https://user-images.githubusercontent.com/75397522/113605923-2c274380-95fc-11eb-8f1d-4ecef7b0dd48.PNG)

***Figure 18:*** Sample chat output for Wolfram Alpha API

From this image we are able to see that we can still get a normal response when you ask our bot something he already understands. Then when you ask something out of our bots scope it will send a query to the API and print the result. If the API does not have a result it will print the normal default responses we implemented for default cases.

![310Wolf](https://user-images.githubusercontent.com/75397522/114328267-e7fedc00-9af0-11eb-8c40-66b511d7e9f5.PNG)

***Figure 19:*** Class made for the Wolfram Alpha API

---------------------------------------

## Google Translate API

---------------------------------------

To have our bot understand many languages and send responses in these languages I implemented Google Translates API.

![310](https://user-images.githubusercontent.com/75397522/114328128-79ba1980-9af0-11eb-9210-1028b3023699.PNG)

***Figure 18:*** Sample chat output for Google Translate API

From this image we are able to see that we can have a normal conversation in English than at any point switch to a different language and our bot will respond with the appropriate response in that language. As well if the subject matter is outside the scope of our bot it can still make queries to our Wolfram Alpha API and returns its result in the appropriate language. 

![310Goog](https://user-images.githubusercontent.com/75397522/114328276-ee8d5380-9af0-11eb-8d68-dc6b16455be5.PNG)

***Figure 19:*** Class made for the Google Translate API

