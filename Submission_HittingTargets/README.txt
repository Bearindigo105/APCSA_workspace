Subhash Muthu
This is an explanation of what was changed from the given files.

In Animation.java, I added a line of code to set the size of the gamePanel so that the gamePanel's width and height would be readable in later parts of the program instead of just being zero.

Direction.java was unchanged

In the Fireball constructor, instead of loading all four images, I only loaded one, depending on what direction the fireball was launched in. I added a boolean method called hasGoneOffPanel which, as the name implies, returns true when the fireball is out of the bounds of a passed JPanel.

GameObject's hasCollidedWith method was implemented utilizing the .intersects method.

I added an extra case in the KeyReleased method for the spacebar which calls the addFireball helper method. addFireball creates a new fireball if there is no current fireball. The addTarget method allows for me to quickly create a new target at a random location within the borders of the panel. In the ActionPerformed method, I iterated through all of the targets and checked if they had come into contact with a fireball. if they had, I removed them from the panel. The fireball's border detection was also done here.

I added an extra class for a scoreboard. this was just a little bit of text and it has an increment method to keep track of how many targets I had annihilated.

In the Hero class, I added a getDirection method with the intent that the Fireball would be able to get the direction of the Hero in the GamePanel class. I also added two extra methods to handle collisions. I had one to determine whether the hero had collided with the border or not and another one to actually enforce the collision by simply reversing the sign of dx and dy.

In the target class, I used a for loop to load all of the images. similarly to the Hero class. I then copied and pasted the updateIcon method from the Hero class. and then I used an or statement between a 4% chance and the whether or not the phase was divisible by 4 to call updateIcon so that if it got triggered by the random chance, it would repeat another 3 times before stopping. this was to make sure that the entire animation played through.
