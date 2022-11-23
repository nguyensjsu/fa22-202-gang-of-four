# Week 2 Journal


Team Member: Sankalp Tiwari


What have I been working on?

For the second sprint, I have been working to design and implement the logic for implementing the Live Score feature, this feature displays the current score of the player on top of the screen. I used Observer Design Pattern to implement this. I created interfaces for the observer and subject along with their concrete classes. To implement the logic, I have created and am updating the score(calling the scoreUp method in the update method of the Board class) whenever an alien is killed. The scoreUp method calls the subject to update the score and notifies the observer. The observer uses the Graphics library of Java to draw a String on the top of the screen.

For making this change, I followed the standard Software development practice of creating a separate branch(LiveScoreFeature) to make the changes, and once the changes were completed I created a pull request which was reviewed by my team. After their approval, the branch was merged into the main branch. 

Output Image of the implementation is attached below

![Live_Score_Implementation_Week2](https://github.com/nguyensjsu/fa22-202-gang-of-four/blob/LiveScoreFeature/Other%20Resources/Live%20Score%20Implementation%20Week%202.png)


What do I plan to do today/this week?

For this week, I have planned to add some background music that will run throughout the game. I am planning to use Strategy Design Pattern to implement this feature. By using this pattern, we will be able to apply different music to the game. Additionally, I will try to improve the design and structure of the code as I will work along with different code components of the game.


What are my blockers?

There are no blockers for me right now. 


Core XP value - Communication

The entire team was effectively communicating while implementing different features in parallel. We were effectively creating a pull request and merging the changes into the main source code quickly. We were discussing the optimal design pattern that could be used for specific feature implementations. After completing a certain task, we used to update our progress in the group and used to move to the next task at hand. 

