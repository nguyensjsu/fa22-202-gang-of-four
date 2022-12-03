# Team Project (Gang of Four - Space Invaders)

## Our Team

Name                    | Student ID  | XP Core Value
-------------           | ------------| -------------
Harshit                 |    | Feedback
Sankalp                 |    | Communication
Rafic Hasbini           | 011243466   | Simplicity
Zaber Ahmed             | 015277548   | Respect

## Game Introduction and Project Plan:
The Gang of Four team has implemented a new iteration of the famous Space Invadors game for this project. The game includes the traditional components: Aliens, Spaceship, Alien-Bombs and additional features implemented by our team for this new version. The team will enhance the traditional game with new features to create a more exhilirating player experience. The game objective is for the player to destroy all the aliens before they either destroy the player or invade the player in the fastest time.
<br>
<br>
As a starting point, source code was found, reviewed, and tested so that it may be used. The source code, implemented in java, provided a bare implementaion of only the component mechanincs and interaction. Those included, movement of player, shot from player to destroy alien, alien movement, alien dropping bombs. This limited implementation served as the perfect base to expand on, especially because the implementation was already fairly loosely coupled. The refactoring step was not too tedious to create the best base to expand on and build features. The team implemented features to provide the player with three lives, created feature for leveling up the player shot to destroy multiple aliens, a scoreboard to display the player score, a timer to display the time it took to beat the game, buttons to restart, pause, toggle music, and cheat-codes to increase the player's abilities. As the code base increased, the code was organised into packages based on the design and feature being implemented. By doing so, it was easier to troubleshoot and merge contributions from other teammates.
<br>
<br>
The Gang of Four team functioned as an agile team and completed the project in a four week sprint period. The team followed and maintained the core XP values when developing the game, created a Kanban board to track the tasks and progess, took part in daily scrum meetings (either virutal or in person), and worked together to complete blockers, plan and design features, and maintain a realistic and value adding sprint backlog. Each team memeber maintained a weekly journal to document what was completed, what is planned to be completed, any blockers, and how the team is staying true to the XP core values to work as an effective team.

### **Link to Project Ad and Demo:**
* Ad Link:
* Demo Link:


### **Individual Journals**
* Rafic Hasbini's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week1.md), [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Rafic/Week4.md)
* Zaber's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week1.md), [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Zaber/Week4.md)
* Sankalp's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Sankalp/Week1.md),  [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/LiveScoreFeature/Journals/Sankalp/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Background-Music-Feature/Journals/Sankalp/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Background-Music-Feature/Journals/Sankalp/Week4.md)
* Harshit's Journal - [Week1](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Multiple-Lives/Journals/Harshit/Week1.md), [Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/Multiple-Lives/Journals/Harshit/Week2.md), [Week3](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Harshit/Week3.md), [Week4](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/main/Journals/Harshit/Week4.md)


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
<image of Architecture diagram>


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

### **Player shot levelup**

### **Cheat codes**

* Chain of responsibility interface
```
public interface KeyEventDispenseChain {
	void setNextChain(KeyEventDispenseChain nextChain);	
	void keyEvent(int key);
}
```

* Plugging the chain inside Board class
```
  inputHandler = new InputHandler(this);
  player.setNextChain(livesSubject);
  livesSubject.setNextChain(this);
```


### **Score display**

### **Timer display**

### **Lives display**

### **Buttons**

### **Music/sounds**


## UI wireframes:
<image of UI frames>

## Burndown chart:
<image of burn down charts>

## Final Analysis and Conclusion:





