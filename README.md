# Team Project (Gang of Four - Space Invaders)

## Our Team

Name                    | Student ID | XP Core Value
-------------           |------------| -------------
Harshit                 | 016099083  | Feedback
Sankalp                 | 016598140  | Communication
Rafic Hasbini           | 011243466  | Simplicity
Zaber Ahmed             | 015277548  | Respect

## Game Introduction and Project Plan:
The Gang of Four team has implemented a new iteration of the famous Space Invadors game for this project. The game includes the traditional components: Aliens, Spaceship, Alien-Bombs and additional features implemented by our team for this new version. The team will enhance the traditional game with new features to create a more exhilirating player experience. The game objective is for the player to destroy all the aliens before they either destroy the player or invade the player in the fastest time.
<br>
<br>
As a starting point, source code was found, reviewed, and tested so that it may be used. The source code, implemented in java, provided a bare implementaion of only the component mechanincs and interaction. Those included, movement of player, shot from player to destroy alien, alien movement, alien dropping bombs. This limited implementation served as the perfect base to expand on, especially because the implementation was already fairly loosely coupled. The refactoring step was not too tedious to create the best base to expand on and build features. The team implemented features to provide the player with three lives, created feature for leveling up the player shot to destroy multiple aliens, a scoreboard to display the player score, a timer to display the time it took to beat the game, buttons to restart, pause, toggle music, and cheat-codes to increase the player's abilities. As the code base increased, the code was organised into packages based on the design and feature being implemented. By doing so, it was easier to troubleshoot and merge contributions from other teammates.
<br>
<br>
The Gang of Four team functioned as an agile team and completed the project in a four week sprint period. The team followed and maintained the core XP values when developing the game, created a Kanban board to track the tasks and progess, took part in daily scrum meetings (either virutal or in person), and worked together to complete blockers, plan and design features, and maintain a realistic and value adding sprint backlog. Each team memeber maintained a weekly journal to document what was completed, what is planned to be completed, any blockers, and how the team is staying true to the XP core values to work as an effective team.

### **Link to Project Ad and Demo:**

* User Advertisement Story

[![User Story](https://i9.ytimg.com/vi/PzhhCfio32U/mq2.jpg?sqp=CMSRrpwG&rs=AOn4CLDxOtA45uTMfWomDACW0aF1DYN40g)](https://www.youtube.com/watch?v=PzhhCfio32U)

* Gameplay Demo

[![Gameplay Demo](https://i9.ytimg.com/vi/o2iQpkRLrAo/mq1.jpg?sqp=CODCrpwG&rs=AOn4CLAXGtzj_v3mjFiMd39fDBmFHvSySA)](https://www.youtube.com/watch?v=o2iQpkRLrAo)


### **Individual Journals**
* Rafic Hasbini's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week1.md), [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week4.md)
* Zaber Ahmed's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week1.md), [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week4.md)
* Sankalp Tiwari's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Sankalp/Week1.md),  [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/LiveScoreFeature/Journals/Sankalp/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Background-Music-Feature/Journals/Sankalp/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Background-Music-Feature/Journals/Sankalp/Week4.md)
* Harshit Chouksey's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Multiple-Lives/Journals/Harshit/Week1.md), [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Multiple-Lives/Journals/Harshit/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Harshit/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Harshit/Week4.md)


## Gameplay Summary:
The traditional gameplay and rules for Space Invaders have been maintained. The player will attempt to destroy all the aliens, while avoiding their bombs, before they are able to invade. Once the game is started up, the player is able to move the ship left and right only usign the left and right arrow buttons. The player is able to fire a shot from the ship's gun using the space bar. When the game begins, the Aliens will begin at the top of the screen, and gradually move down towards the player while they move from the left edge to the right edge of the screen. While the Aliens move, they will drop a rain of bombs and the player must avoid them or risk losing lives and eventually dying. 
<br>
<br>
Aliens will be destroyed upon collision with the shot sent by the player. The base player shoots a shot that can kill only one alien at a time. The leveled up player is able to destroy up to three aliens with a single shot. The leveled up player is activated by destroying the green level up icon on the screen. The collision of the player shot with the icon will automatically level up the player. As the player destroys the aliens, they will receieve one point per alien. The score is displayed on the gameplay screen. The timer is also implemented for the player to see how fast they are able to destroy the aliens. The timer is also displayed on the gameplay screen. This adds competitiveness to the game as players can compare how fast they were able to beat the came. 
<br>
<br>
The player is also able to set the difficulty level for the game. By Toggling the difficulty button on the gameplay screen, the player will may switch between easy and difficult gameplay. The difficulty level feature will switch the background of the game to make gameplay more difficult. The contrast of the colors in the hard setting makes it difficult for player to aim the shot. This feature allows even more competitiveness and fun to be gained from playing the game. 
<br>
<br>
During game play, the player is able to activate cheat codes which will help the player beat the game as fast as possible. Cheat codes may be toggled by providing keyboard input of numbers 1 through 9. The numbers 1-9 implement player speed, 1 being the slowest and 9 being the fastest. The player is able to change the spaceship speed to their preference or to dodge certain bombs. Toggling b will level up the player's shot without needing to destroy the level up icon. Toggling l will provide the player with three additional lives everytime.
<br>
<br>
On the gameplay screen, buttons have been implemented to pause the game and restart the game during gameplay. This feature has been added to empower the player to have control over the game. The player is able to restart the game which will refresh the game as if the game was starting up from scratch. Pause will hold the game until the player clicks the button again to continue.
<br>
<br> 
To enhance player experience futher, music has been added to create a fun player environment. Sound effects have also been added for the shot. The background music may be toggle by a button on the screen. The background song may also be changed by toggling the next button.


## Overview of System Architecture:

The system architecture has been designed in a way to maintain loose coupling of components and enable developers to understand the code easily. Features have been added to the code base in the form of packages. By reviewing the architectual diagram below, it becomes easy to expand on features, fix bugs, and add new features by following the feature-package approach. The Board.java class is essentially what ties together all packages by implementing how the objects will interact to create the game play.
<br>
<br>
The Sprite package consists of all the components which make up the game play: Aliens, player, shot, bombs. Since all of these components have the same base movements and jobs. Aliens, Player, and bombs extend the Sprite.java class, However, to implement the decortor pattern for the shot level up feature, it was necessary to create the IShot interface in the Sprite package and implement the decorator separate from the Sprite class. By implementing the IShot interface, it was possible to include it in the Board.java and switch between the different types of shots.

Architectural Diagram

![Architectural Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Architectural%20Diagrams/Architecture%20Diagram.png)

Diagram depicting underlying components:

![Component Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Architectural%20Diagrams/Component%20Diagram.png)


## UI wireframes:

UI Wireframe Combined:

![UI Wireframe Combined](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UI%20Wireframe/UI_Wireframes_GOF_Space_Invaders.png)

UI Wireframe Components:

![Component 1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UI%20Wireframe/IMG_1146.jpeg)

![Component 2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UI%20Wireframe/IMG_1147.jpeg)

![Component 3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UI%20Wireframe/IMG_1148.jpeg)

![Component 4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UI%20Wireframe/IMG_1149.jpeg)




## Features Design Notes:

### **Feature list**
The features implemented for this new Space Invaders version are:
* Difficulty mode setting - State design pattern
* Player shot levelup - decorator pattern
* Cheat codes - chain of responsibility pattern
* Score display - observer pattern
* Timer display - observer pattern
* Lives display - observer pattern
* Buttons - Command pattern
* Music/sounds - Strategy pattern

### **Difficulty mode setting**

The feature was decided to make the gameplay more challenging. A player can now switch between easy and hard modes. The easy mode continues to have the regular gameplay, but the hard mode leads to the player shots being invisible. The player now has to estimate the position of alien and play accordingly. To switch between the modes a Button has been added which toggles between easy and hard mode based on the current mode of play. When you press the button the state pattern is invoked which changes the state of the game from easy to hard; and the other way around.

### **Player shot levelup**
The player shot levelup is implemented by using a decorator pattern. The IShot interface class provides the template for the Shot classes to implement and decorate. The Shot.java class is the base shot. The ShotDecorator.java class implements the IShot interface and does that by passing commands to the Shot.java base. The concrete decorator class, DoubleShot.java, then changes whichever methods it wishes to change and implements additional behavior as well. In Board.java class a flag is set for the shot type. Based on that flag, the IShot variable will either represent an object of DoubleShot.java or the base Shot.java class.

### **Cheat codes**

### **Chain of responsibility interface**


### **Plugging the chain inside Board class**


### **Score display**

Live Score in the gameplay is tracked using the observer pattern. It has two interfaces, ‘ILiveScoreObserver’ and ‘ILiveScoreSubject’. The concrete observer and Concrete subject are ‘LiveScoreObserver’ and ‘LiveScoreSubject’ respectively. We have a scoreState variable that will handle the current score status and the update method will update the player’s score based on the number of aliens killed. We use the attach method to attach the observer and notifyObservers method to notify the observers about the current score.

### **Timer display**

### **Multi Lives**

This feature was introduced to make the gameplay more enjoyable, where the player does not have to begin the game by getting shot just once. Therefore, the number of lives were increased to 3 and one life is reduced by getting hit by alien missiles once. To display and keep track of the number of lives left, observer pattern has been used.

### **Buttons**

The restart button uses command pattern to implement its logic. Whenever the button is pressed the gameplay restarts, this is done by using the ActionListener method in the Java awt library. ButtonControl Invoker is instantiated along with the RestartButton receiver. RestartButtonPressed method instantiates the receiver and sets the command to restart. The restart function works when the pressbutton is called in the codebase.


### **Music/sounds**

Strategy pattern is implemented to change the background music for the gameplay when a button is clicked. The IMusicStrategy is the interface for the strategy and is implemented by ‘Music1’, ‘Music2’ and ‘Music3’ classes. By default, the strategy is to play a music file and when the Next Music button is pressed, then the music should change to the next one.



## UML Diagrams

Space Invader Starter code class diagram:

![Starter Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/InitialCode_ClassDiagram.png)

GOF version Space invaders Simplified class diagram:

![Simplified class diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Class%20Diagram%20Simplified.png)

GOF version Space Invaders Detailed Class Diagram:

![Detailed Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Class%20Diagram%20Detailed.png)

Asta file available at [Asta](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Class%20diagram.asta)

Shot Level Up Decorator Class Diagram:

![Shot Level Up Decorator Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/ShotLevelUp_ClassDiagram.png)

Live Score Observer Class Diagram:

![Live Score Observer Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/LiveScoreObserver_ClassDiagram.png)


Multi Life Observer Class Diagram:

![Multi Life Observer Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Remaining%20Lives%20Observer.png)

Timer Observer Class Diagram:

![Timer Observer Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/TimerObserver_ClassDiagram.png)


Background Music Strategy Class Diagram:

![Background Music Strategy Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/MusicStrategy_ClassDiagram.png)


Difficulty Mode State Class Diagram:

![Difficulty Mode State Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Difficulty%20Mode%20State.png)


Difficulty Mode State Machine Diagram:

![Difficulty Mode State Machine Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Difficulty%20Mode%20State%20Machine.png)


Restart Button Command Class Diagram:

![Restart Button Command Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/ResetCommand_ClassDiagram.png)




## Sprint Details:

Sprint Task Sheet

![Sprint Task Sheet](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Agile/Table%20Burndown.PNG)

Sprint Burndown Chart

![Sprint Burndown Chart](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Agile/Burndown%20Chart.PNG)

## Agile Videos

Standup Meeting

[![Standup Meeting](https://i9.ytimg.com/vi/Dc23WRTAPT8/mq2.jpg?sqp=COjQrpwG&rs=AOn4CLATr3gLpjb7VVP6TVrlH2MV4jsYUA)](https://www.youtube.com/watch?v=Dc23WRTAPT8&ab_channel=hc693)

Retrospective Meeting

[![Retrospective Meeting](https://i9.ytimg.com/vi/XF24iT2FLoM/mq2.jpg?sqp=CJTTrpwG&rs=AOn4CLC3f5syMorKUz8uDN5or2RFchy3Qg)](https://www.youtube.com/watch?v=XF24iT2FLoM)


## Final Analysis and Conclusion:
To analyse and conclude on this project and the outcome of out sprint, working as an agile team has proven to be beneficial in the development cycle of our game. By using the standard approaches and tools, like the scrum meetings, and kanban board, along with maintaining core XP values, we have been able to develop product which meets our goals and maintains a contant mission for the team. 
<br>
<br>
Looking at the final product architecture, the code is loosely coupled and provides a good base for organic growth. However, the Sprite class could be broken down further to meet the same feature-package approach that was used to implement other features. Generally, the use of packages for each feature allowed us to maintain loosely coupled code.



