use librarysystem;

INSERT INTO Address values (0,"1000N 4th St","Iowa","52557","Fairfield");


INSERT INTO Person Values (0,"Kiran", "Luitel", LAST_INSERT_ID(),"45678904");


INSERT INTO Member Values(0,LAST_INSERT_ID());

INSERT INTO Checkout_Record Values(0,LAST_INSERT_ID());