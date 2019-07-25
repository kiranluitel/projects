use librarysystem;

INSERT INTO Address values (0,"1000N 4th St","Iowa","52557","Fairfield");


INSERT INTO Person Values (0,"Kiran", "Luitel", LAST_INSERT_ID(),"45678904");


INSERT INTO Author Values(0,"short bio","Credential",LAST_INSERT_ID());


SELECT @idAuthor := LAST_INSERT_ID();

INSERT INTO Book Values(0,"ISBN", "Title", "Short description");

SELECT @idBook := LAST_INSERT_ID();

INSERT INTO author_book_connection Values (0,@idBook, @idAuthor);

INSERT INTO bookcopy VALUES (0,1, @idBook);