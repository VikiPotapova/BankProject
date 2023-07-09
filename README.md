# BankProject
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [FAQ](#FAQ)


## General info

This is project for bank. It helps to:
* read the files and choose proper ones
* track the money transfers
* prevent wrong situations
* update account balance information
	
## Technologies

Project is created with JAVA SE 19.
	
## Setup

To run this project, install it: https://github.com/VikiPotapova/BankProject/tree/master
The program will wait for the information to be entered from the console (number of operation):
* number 1 means – call the operation of parsing files with transfers
* number 2 means – show the list of all transfers.

## FAQ

### 1. How to use the project?

After downloading it add files to right packages. Pay attention that there are certain formats for files(txt), account number (xxxxx-xxxxx) and spaces. The formats can be changed according to the case.

### 2. How to be sure that the file with transfers goes once and return correct sum?

There is a method that move parsed files to the archive. So they can be used only one time.

### 3. What happened in case of wrong format or empty files?

Each of these cases are processed by program with checking the conditions and throwing exceptions. That’s why such files are not going to be read.
