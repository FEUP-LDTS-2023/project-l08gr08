## LDTS_<08><08> - <BLOCK DUDE>



In this intellectually stimulating game, assist the character in navigating through five increasingly complex levels. Your task involves strategically moving blocks to construct a path that leads the character to the level's conclusion. Each stage offers a greater challenge, testing your problem-solving skills.



This project was developed by Frederica Pereira (202108167@fe.up.pt),  Eduardo Cunha (202207126@fe.up.pt) and Gonçalo Sampaio (202206636@fe.up.pt) for LDTS 2023/2024

## UML

![blockdude_uml.png](docs%2Fblockdude_uml.png)

## IMPLEMENTED FEATURES

![gameRun.png](docs%2Fimg%2FgameRun.png)



Walking - The game character walks in the direction of the arrow key - left or right.

Changing direction – The game character is able to change his direction – left or right.

Reading Text Files to create levels – the reading of files was done successfully.



 ## PLANNED FEATURES
![MenuAndGame.jpeg](docs%2Fimg%2FMenuAndGame.jpeg)
![level1.jpeg](docs%2Fimg%2Flevel1.jpeg)


Picking up a block - The game character will pick up a block when the “down” arrow key is pressed.

Dropping a block - The game character will drop a block when the “down” arrow key is pressed.

Enemies - different non playable characters that provide some adversity to the player.

Using a power – the player is able to use a power that will let him break a Block in front of him.

Changing Textures – the user is able to change the appearence of the videogame including the characters that he uses;





## DESIGN



Problem in context:



Designing the game such that the edges define the playing area, and synchronizing the character's movement with the emergence of the game's scenery. The character should always be centered in the window when possible.



The Pattern:



We have adopted the State pattern, which serves as a guide for our program to determine the current game state and how to respond to various inputs. While we haven't completed the State implementation, we are confident that we can address the issue by integrating the state management into the level design within the game window.



Implementation:



The following figure shows how the pattern’s roles were mapped to the application classes.






These classes can be found in the following files:



-[Application](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Application.java



- [Block](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Block.java)



- [Element](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Element.java)



- [Enemy](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Enemy.java)



- [Game](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Game.java)



- [Item](ncreasedGravityState](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Item.java)



-[KeyStroke](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/KeyStroke.java)



-[Level](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Level.java)



-[Player](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Player.java)



-[Position](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Position.java)



-[Wall](https://github.com/FEUP-LDTS-2023/project-l08gr08/blob/master/src/main/java/Wall.java)





Consequences:



The use of the State Pattern in the current design allows the following benefits:



- The program knows the current part of the game.

- Behavior Control: The value of the state variable influences the behavior of the object or system. Different states may trigger different actions, methods, or logic to be executed in response to inputs, events, or conditions.

- State Transitions: State variables define the allowed transitions between states. They determine when and how the system or object can change from one state to another. Transitions may be triggered by specific events, conditions, or actions. (ex: levels, menu, options).



## KNOWN CODE SMELLS



> The movement of the player is not completely defined yet, it only changes its position ignoring the existence of blocks. We don’t have functions that check if the movement is valid and we still need to create functions for picking up a Block, activating the Power or breaking a Block for example;



> The class Level, should be an Abstract Class, and the creation of Level1 -> Level5 should extend that Class, reading different files;



> The Drawings of the Elements of the game should be squares instead of rectangles and should show a texture instead of just a Character with a background color (example ‘>’ should show us a pixel art of the block-dude). The background of each level should also show us an image of a pixel art;





## TESTING



https://github.com/FEUP-LDTS-2023/project-l08gr08/tree/master/src/test/java


![tests.png](docs%2Fimg%2Ftests.png)


## SELF-EVALUATION



While we were together, we jointly arrived at the game concept and discussed various implementation hypotheses for the game. Subsequently, we each completed different parts of the work. Frederica was responsible for creating the text, while Gonçalo and Eduardo were in charge of completing the application and testing, respectively.



We all contrbuted equally to the submission of the project.  