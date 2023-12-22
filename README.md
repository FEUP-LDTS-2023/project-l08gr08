## LDTS_<08><08> - <BLOCK DUDE>



In this intellectually stimulating game, assist the character in navigating through five increasingly complex levels. Your task involves strategically moving blocks to construct a path that leads the character to the level's conclusion. Each stage offers a greater challenge, testing your problem-solving skills.



This project was developed by Frederica Pereira (202108167@fe.up.pt),  Eduardo Cunha (202207126@fe.up.pt) and Gonçalo Sampaio (202206636@fe.up.pt) for LDTS 2023/2024

## UML

![blockdude_uml.png](docs%2Fblockdude_uml.png)

![Captura de ecrã de 2023-12-22 19-19-18.png](docs%2Fimg%2FCaptura%20de%20ecr%C3%A3%20de%202023-12-22%2019-19-18.png)
## PLAYING THE GAME

A short gameplay demonstrating all the features:

![video.gif](docs%2Fimg%2Fvideo.gif)
## IMPLEMENTED FEATURES
A Menu - you have access to all the levels and game controls:

![gameRun.png](docs%2Fimg%2FmenuInicial.png)

These are the controls that can be accessed through the initial menu.

![controls.png](docs%2Fimg%2Fcontrols.png)

Walking - The game character walks in the direction of the arrow key - left or right.

Changing direction – The game character is able to change his direction – left or right.

Reading Text Files to create levels – the reading of files was done successfully.

Level 1:

![nivel1.png](docs%2Fimg%2Fnivel1.png)

![level1.png](docs%2Fimg%2Flevel1.png)

Level 2:

![nivel2.png](docs%2Fimg%2Fnivel2.png)

![level2.png](docs%2Fimg%2Flevel2.png)

Level 3:

![nivel3.png](docs%2Fimg%2Fnivel3.png)

![level3.png](docs%2Fimg%2Flevel3.png)

Picking up a block - The game character will pick up a block when the “down” arrow key is pressed.
Dropping a block - The game character will drop a block when the “down” arrow key is pressed.


![holdingBlock.png](docs%2Fimg%2FholdingBlock.png)

Enemies - different non playable characters that provide some adversity to the player.

![enemy.png](docs%2Fimg%2Fenemy.png)

Using a power – the player is able to use a power that will let him break a Block in front of him.

![powerON.png](docs%2Fimg%2FpowerON.png)


Stage - Initially, the player is on stage 1. As they collect items, they can activate the power, and the stage increases by 1.
Note that in the following image, the player picked up two items, so he is now on stage 3.

![stage3.png](docs%2Fimg%2Fstage3.png)

Lives - the player has 3 lives per game. If he presses reset ("R"), one life will be deducted. The same happens if he is killed by an enemy.
In the following image, the player has only one life.

![lives.png](docs%2Fimg%2Flives.png)

If he loses, he comes to this menu.

![lose.png](docs%2Fimg%2Flose.png)

If he wins, he comes to this menu.

![win.png](docs%2Fimg%2Fwin.png)



## DESIGN

State Pattern:

In the current design allows the following benefits:



- The program knows the current part of the game.

- Behavior Control: The value of the state variable influences the behavior of the object or system. Different states may trigger different actions, methods, or logic to be executed in response to inputs, events, or conditions.

- State Transitions: State variables define the allowed transitions between states. They determine when and how the system or object can change from one state to another. Transitions may be triggered by specific events, conditions, or actions. (ex: levels, menu, options).

Factory Method Pattern:

In the current design, the Factory Method pattern offers several advantages:

- Flexibility and Extensibility:
By employing a Factory Method, even implicitly, the design gains the flexibility to alter the types of objects created without necessitating changes to its core logic. This enhances extensibility and simplifies maintenance.

- Code Reusability:
The Factory Method pattern fosters code reusability. If the logic for object creation is required elsewhere in the application, it can be easily reused without duplicating code.



## CODE SMELLS

>One of the problems we've spotted is that when we provide levels with resolutions larger than what we initially set, like the assumed 13x44, it affects the level drawing. In simpler terms, the drawing gets compromised because we didn't consider where to draw things when adjusting the level to fit the screen size.

>Lack of comments: it might be challenging for someone else to understand the purpose and functionality of various parts of the code.

>Long Methods: We have some methods that are a bit lengthy, which compromises readability.

## PITEST REPORT

![pitest.png](docs%2Fimg%2Fpitest.png)
## SELF-EVALUATION
- Eduardo - 40%

- Frederica - 20%

- Gonçalo - 40%

