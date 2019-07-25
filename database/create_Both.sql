use librarysystem;

INSERT INTO Address values (0,"1000N 4th St","Iowa","52557","Fairfield");


INSERT INTO Person Values (0,"Kiran", "Luitel", LAST_INSERT_ID(),"45678904");


INSERT INTO User Values(0,"00",LAST_INSERT_ID());
SELECT @idUser := LAST_INSERT_ID();

Insert into Librarian Values(0,LAST_INSERT_ID());

Insert into administrator Values(0,@idUser);
