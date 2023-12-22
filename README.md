## LDTS_<08><08> - <BLOCK DUDE>



In this intellectually stimulating game, assist the character in navigating through five increasingly complex levels. Your task involves strategically moving blocks to construct a path that leads the character to the level's conclusion. Each stage offers a greater challenge, testing your problem-solving skills.



This project was developed by Frederica Pereira (202108167@fe.up.pt),  Eduardo Cunha (202207126@fe.up.pt) and Gonçalo Sampaio (202206636@fe.up.pt) for LDTS 2023/2024

## UML

![blockdude_uml.png](docs%2Fblockdude_uml.png)
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

## TEST COVERAGE
![Captura de ecrã de 2023-12-21 22-06-13.png](docs%2Fimg%2FCaptura%20de%20ecr%C3%A3%20de%202023-12-21%2022-06-13.png)


![Captura de ecrã de 2023-12-21 22-06-35.png](docs%2Fimg%2FCaptura%20de%20ecr%C3%A3%20de%202023-12-21%2022-06-35.png)


![Captura de ecrã de 2023-12-21 22-07-01.png](docs%2Fimg%2FCaptura%20de%20ecr%C3%A3%20de%202023-12-21%2022-07-01.png)


![Captura de ecrã de 2023-12-21 22-07-16.png](docs%2Fimg%2FCaptura%20de%20ecr%C3%A3%20de%202023-12-21%2022-07-16.png)


![Captura de ecrã de 2023-12-21 22-07-40.png](docs%2Fimg%2FCaptura%20de%20ecr%C3%A3%20de%202023-12-21%2022-07-40.png)


![Captura de ecrã de 2023-12-21 22-21-22.png](docs%2Fimg%2FCaptura%20de%20ecr%C3%A3%20de%202023-12-21%2022-21-22.png)


## PITEST REPORT
-MUTATORS
org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
> Generated 50 Killed 13 (26%)
KILLED 13 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 36

org.pitest.mutationtest.engine.gregor.mutators.returns.PrimitiveReturnsMutator
> Generated 18 Killed 9 (50%)
KILLED 9 SURVIVED 3 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 6

org.pitest.mutationtest.engine.gregor.mutators.IncrementsMutator
> Generated 1 Killed 0 (0%)
KILLED 0 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 1

org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator
> Generated 250 Killed 62 (25%)
KILLED 62 SURVIVED 19 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 169

org.pitest.mutationtest.engine.gregor.mutators.returns.BooleanTrueReturnValsMutator
> Generated 27 Killed 9 (33%)
KILLED 8 SURVIVED 4 TIMED_OUT 1 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 14

org.pitest.mutationtest.engine.gregor.mutators.returns.NullReturnValsMutator
> Generated 40 Killed 10 (25%)
KILLED 10 SURVIVED 9 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 21

org.pitest.mutationtest.engine.gregor.mutators.MathMutator
> Generated 64 Killed 33 (52%)
KILLED 32 SURVIVED 2 TIMED_OUT 1 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 29

org.pitest.mutationtest.engine.gregor.mutators.returns.EmptyObjectReturnValsMutator
> Generated 13 Killed 4 (31%)
KILLED 4 SURVIVED 5 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 4

org.pitest.mutationtest.engine.gregor.mutators.returns.BooleanFalseReturnValsMutator
> Generated 20 Killed 8 (40%)
KILLED 8 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 12

org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
> Generated 187 Killed 57 (30%)
KILLED 57 SURVIVED 28 TIMED_OUT 0 NON_VIABLE 0
MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
NO_COVERAGE 102


-TIMINGS

>pre-scan for mutations : < 1 second

>scan classpath : < 1 second

>coverage and dependency analysis : 1 second

>build mutation tests : < 1 second

>run mutation analysis : 34 seconds

>Total  : 35 seconds


-STATISTICS
>Line Coverage (for mutated classes only): 458/864 (53%)

>Generated 670 mutations Killed 205 (31%)

>Mutations with no coverage 394. Test strength 74%

>Ran 456 tests (0.68 tests per mutation)

## SELF-EVALUATION
- Eduardo - 40%

- Frederica - 20%

- Gonçalo - 40%

