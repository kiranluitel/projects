-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2019 at 10:33 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12
drop database librarysystem;
create database librarysystem;
USE librarysystem;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `librarysystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `idAddress` int(11) NOT NULL,
  `street` varchar(100) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip` varchar(15) NOT NULL,
  `city` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `idAdministrator` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `idAuthor` int(11) NOT NULL,
  `shortBio` varchar(255) NOT NULL,
  `credentials` varchar(100) NOT NULL,
  `idPerson` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `author_book_connection`
--

CREATE TABLE `author_book_connection` (
  `idAuthorBookConn` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  `idAuthor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `idBook` int(11) NOT NULL,
  `ISBN` varchar(15) NOT NULL,
  `title` varchar(100) NOT NULL,
  `shortDescription` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bookcopy`
--

CREATE TABLE `bookcopy` (
  `idBookCopy` int(11) NOT NULL,
  `availabilty` tinyint(1) NOT NULL,
  `bookDate` int(10) NOT NULL,
  `idBook` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `idCheckout` int(11) NOT NULL,
  `bookName` varchar(100) NOT NULL,
  `dueDate` varchar(20) NOT NULL,
  `checkOutDate` varchar(20) NOT NULL,
  `idFine` int(11) DEFAULT NULL,
  `idCheckOutRecord` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `checkout_bookcopy_connection`
--

CREATE TABLE `checkout_bookcopy_connection` (
  `idCheckoutBookCopyConn` int(11) NOT NULL,
  `idBookCopy` int(11) NOT NULL,
  `idCheckout` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `checkout_record`
--

CREATE TABLE `checkout_record` (
  `idCheckoutRecord` int(11) NOT NULL,
  `idMember` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fine`
--

CREATE TABLE `fine` (
  `idFine` int(11) NOT NULL,
  `returnedDate` varchar(100) NOT NULL,
  `fineValue` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `idLibrarian` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `idMember` int(11) NOT NULL,
  `idPerson` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `idPerson` int(11) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `idAddress` int(11) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `idPerson` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`idAddress`);

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`idAdministrator`),
  ADD KEY `administrator_user` (`idUser`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`idAuthor`),
  ADD KEY `author_person` (`idPerson`);

--
-- Indexes for table `author_book_connection`
--
ALTER TABLE `author_book_connection`
  ADD PRIMARY KEY (`idAuthorBookConn`),
  ADD KEY `author_connection` (`idAuthor`),
  ADD KEY `book_connection` (`idBook`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`idBook`);

--
-- Indexes for table `bookcopy`
--
ALTER TABLE `bookcopy`
  ADD PRIMARY KEY (`idBookCopy`),
  ADD KEY `book_bookcopy` (`idBook`);

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`idCheckout`),
  ADD KEY `checkout_fine` (`idFine`),
  ADD KEY `checkout_checkoutrecord` (`idCheckOutRecord`);

--
-- Indexes for table `checkout_bookcopy_connection`
--
ALTER TABLE `checkout_bookcopy_connection`
  ADD PRIMARY KEY (`idCheckoutBookCopyConn`),
  ADD KEY `checkout_connection` (`idCheckout`),
  ADD KEY `bookcopy_connection` (`idBookCopy`);

--
-- Indexes for table `checkout_record`
--
ALTER TABLE `checkout_record`
  ADD PRIMARY KEY (`idCheckoutRecord`),
  ADD KEY `checkout_member` (`idMember`);

--
-- Indexes for table `fine`
--
ALTER TABLE `fine`
  ADD PRIMARY KEY (`idFine`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`idLibrarian`),
  ADD KEY `librarian_user` (`idUser`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`idMember`),
  ADD KEY `member_person` (`idPerson`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idPerson`),
  ADD KEY `person_address` (`idAddress`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`),
  ADD KEY `user_person` (`idPerson`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `idAddress` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `administrator`
--
ALTER TABLE `administrator`
  MODIFY `idAdministrator` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `idAuthor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `author_book_connection`
--
ALTER TABLE `author_book_connection`
  MODIFY `idAuthorBookConn` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `idBook` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bookcopy`
--
ALTER TABLE `bookcopy`
  MODIFY `idBookCopy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `checkout`
--
ALTER TABLE `checkout`
  MODIFY `idCheckout` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `checkout_bookcopy_connection`
--
ALTER TABLE `checkout_bookcopy_connection`
  MODIFY `idCheckoutBookCopyConn` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `checkout_record`
--
ALTER TABLE `checkout_record`
  MODIFY `idCheckoutRecord` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `fine`
--
ALTER TABLE `fine`
  MODIFY `idFine` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `idLibrarian` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `idMember` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `idPerson` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `administrator_user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `author_person` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`);

--
-- Constraints for table `author_book_connection`
--
ALTER TABLE `author_book_connection`
  ADD CONSTRAINT `author_connection` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`idAuthor`),
  ADD CONSTRAINT `book_connection` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Constraints for table `bookcopy`
--
ALTER TABLE `bookcopy`
  ADD CONSTRAINT `book_bookcopy` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`);

--
-- Constraints for table `checkout`
--
ALTER TABLE `checkout`
  ADD CONSTRAINT `checkout_checkoutrecord` FOREIGN KEY (`idCheckOutRecord`) REFERENCES `checkout_record` (`idCheckoutRecord`),
  ADD CONSTRAINT `checkout_fine` FOREIGN KEY (`idFine`) REFERENCES `fine` (`idFine`);

--
-- Constraints for table `checkout_bookcopy_connection`
--
ALTER TABLE `checkout_bookcopy_connection`
  ADD CONSTRAINT `bookcopy_connection` FOREIGN KEY (`idBookCopy`) REFERENCES `bookcopy` (`idBookCopy`),
  ADD CONSTRAINT `checkout_connection` FOREIGN KEY (`idCheckout`) REFERENCES `checkout` (`idCheckout`);

--
-- Constraints for table `checkout_record`
--
ALTER TABLE `checkout_record`
  ADD CONSTRAINT `checkout_member` FOREIGN KEY (`idMember`) REFERENCES `member` (`idMember`);

--
-- Constraints for table `librarian`
--
ALTER TABLE `librarian`
  ADD CONSTRAINT `librarian_user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_person` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`);

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_address` FOREIGN KEY (`idAddress`) REFERENCES `address` (`idAddress`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_person` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`);
COMMIT;

