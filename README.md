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
Aliens will be destroyed upon collision with the shot sent by the player. The base player shoots a shot that can kill only one alien at a time. The leveled up player is able to destroy up to three aliens with a single shot. The leveled up player is activated by destroying the green level up icon on the screen. The collision of the player shot with the icon will automatically level up the player. As the player destroys the aliens, they will receieve one point per alien. The timer is also implemented for the player to see how fast they are able to destroy the aliens. This adds competitiveness to the game as players can compare how fast they were able to beat the came. 
<br>
<br>
The player is also able to set the difficulty level for the game. 
<br>
<br>
During game play, the player is able to activate cheat codes which will help the player beat the game faste
~ list the gameplay cheat codes.
<br>
<br>
On the gameplay screen, buttons have been implemented to:
<br>
<br> 
Throughout the game music has been added to create a fun player environment. Sound effects have also been added for the shot.


## Overview of System Architecture:

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

### **Cheat codes**

### **Chain of responsibility interface**


### **Plugging the chain inside Board class**


### **Score display**

### **Timer display**

### **Multi Lives**

This feature was introduced to make the gameplay more enjoyable, where the player does not have to begin the game by getting shot just once. Therefore, the number of lives were increased to 3 and one life is reduced by getting hit by alien missiles once. To display and keep track of the number of lives left, observer pattern has been used.

### **Buttons**

### **Music/sounds**


## UML Diagrams

Space Invader Starter code class diagram:

![Starter Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/InitialCode_ClassDiagram.png)

GOF version Space invaders Simplified class diagram:

![Simplified class diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Class%20Diagram%20Simplified.png)

GOF version Space Invaders Detailed Class Diagram:

![Detailed Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Class%20Diagram%20Detailed.png)

Asta file available at [Asta](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Class%20diagram.asta)

Live Score Observer Class Diagram:

Live Score in the gameplay is tracked using the observer pattern. It has two interfaces, ‘ILiveScoreObserver’ and ‘ILiveScoreSubject’. The concrete observer and Concrete subject are ‘LiveScoreObserver’ and ‘LiveScoreSubject’ respectively. We have a scoreState variable that will handle the current score status and the update method will update the player’s score based on the number of aliens killed. We use the attach method to attach the observer and notifyObservers method to notify the observers about the current score.

![Live Score Observer Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/LiveScoreObserver_ClassDiagram.png)


Multi Life Observer Class Diagram:

![Multi Life Observer Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Remaining%20Lives%20Observer.png)


Background Music Strategy Class Diagram:

![Background Music Strategy Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/MusicStrategy_ClassDiagram.png)

Strategy pattern is implemented to change the background music for the gameplay when a button is clicked. The IMusicStrategy is the interface for the strategy and is implemented by ‘Music1’, ‘Music2’ and ‘Music3’ classes. By default, the strategy is to play a music file and when the Next Music button is pressed, then the music should change to the next one.

Difficulty Mode State Class Diagram:

![Difficulty Mode State Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Difficulty%20Mode%20State.png)


Difficulty Mode State Machine Diagram:

![Difficulty Mode State Machine Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/Difficulty%20Mode%20State%20Machine.png)


Restart Button Command Class Diagram:

![Restart Button Command Class Diagram](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/UML%20Diagrams/ResetCommand_ClassDiagram.png)

The restart button uses command pattern to implement its logic. Whenever the button is pressed the gameplay restarts, this is done by using the ActionListener method in the Java awt library. ButtonControl Invoker is instantiated along with the RestartButton receiver. RestartButtonPressed method instantiates the receiver and sets the command to restart. The restart function works when the pressbutton is called in the codebase.




## Sprint Details:

Sprint Task Sheet

![Sprint Task Sheet](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Agile/Table%20Burndown.PNG)

Sprint Burndown Chart

![Sprint Burndown Chart](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Agile/Burndown%20Chart.PNG)


## Final Analysis and Conclusion:





