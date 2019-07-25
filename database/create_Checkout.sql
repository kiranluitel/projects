use librarysystem;

SELECT @idCheckoutRecord := 
	idCheckoutRecord 
	from Member M, checkout_record cr
	where M.idMember = cr.idMember;

SELECT @nmBook :=
	title
	from Book b, BookCopy BC
	where b.idBook = BC.idBook AND BC.idBook = 1;

	
SELECT @bookDate :=
	bookDate
	from Book b, BookCopy BC
	where b.idBook = BC.idBook AND BC.idBook = 1;

SELECT @idFine :=
	idFine 
	From fine;

insert into checkout VALUES (0, @nmBook,DATE_ADD(CURDATE(), INTERVAL @bookDate DAY),CURDATE(),null,@idCheckoutRecord);