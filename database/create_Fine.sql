use librarysystem;

INSERT INTO Fine values (0,CURDATE(),15);

UPDATE checkout set idFine = LAST_INSERT_ID() where idCheckout = 1;