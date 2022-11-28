# Week 3 Journal


Team Member: Sankalp Tiwari


What have I been working on?

For the third sprint, I have been working to design and implement the logic for the Background Music feature, this feature plays a background music throughout the game. I have implemented this feature using strategy pattern, we can have different music strategies which will play different music during the gameplay. I imported new music files and then created an interface for implementing music strategies. Then, I created different music classes that implement the interface and run different music. I also created a SoundHandler class which has the code to get the audio stream into the system. To implement the logic, I am instantiating the Music strategy class and running it's runMusic method in the Board class. 

For making this change, I followed the standard Software development practice of creating a separate branch(Background-Music-Feature) to make the changes, and once the changes were completed I created a pull request which was reviewed by my team. After their approval, the branch was merged into the main branch. 


What do I plan to do today/this week?

For this week, I have planned to add a restart button on the gameplay screen. If the button will be pressed, then the game will restart. Moreover, I am planning to refactor the previously implemented features and improve the design and structure of the code.


What are my blockers?

There are no blockers for me right now. 


Core XP value - Communication

This week marked a test on how effective communication is helpful in an Agile Team. There was a merge issue in the development and the team was able to effectively resolve it by communicating over Whatsapp and group calls. We were able to make the code run. We all discussed the outstanding items and the most optimum design patterns that could be used for their development and planned to have more frequent meetings as we were approaching the last sprint. 

