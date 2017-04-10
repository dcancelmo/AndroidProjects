Daniel Cancelmo
dcancelm@u.rochester.edu
CSC 214 - Android Mobile App Development
Professor St Jacques
TA: Alan Beadle
Project 02
April 9, 2017
ReadMe File

I affirm that I did not give or receive any unauthorized help on this project, and that all work herein is my own.

Code description:
The database package contains the classes maintaining the database for the users, posts, and favorites.
Each row in post and favorite can be linked back to its user by username or email.
The model package stores the post and user objects.
The recyclerView package stores the fragments, adapters, and view holders for the recyclerviews.
Each activity utilizes the header fragment ot allow for back navigation except for UpdateAccountActivity because it is called immediately after creation and although back navigation will allow navigation to the networkfeed, bypassing the extra info entering it deters users form doing so.


This app was developed for Android version 7.1.1 API 25 and texted on the Nexus 6 with 1440x2560 resolution and x86 CPU.

Extra credit:
