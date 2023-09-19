## Java-Programming-Solving-Problems-with-Software
[View Coursera Certificate](https://coursera.org/share/fc69e48bdcaa796396e79311eca3be14) 🧑‍🎓

My project (module 4) for the Coursera course Java Programming: Solving Problems with Software by Duke University

### Module 1 - Fundamental Java Syntax and Semantics
Acquired Skills:
  1) ~~Download and run BlueJ, the Java programming environment for this course~~ I preferred to use IntelliJ IDEA CE and JUnit to test my code
  2) ~~Access the documentation for the Java libraries specially designed for this course~~ I replaced some of the simplified course libraries with widely adopted ones (better maintained and documented)
  3) Edit, compile, and run a Java program
  4) Construct methods, variables, if-else statements, and for each loops in Java
  5) Use Iterables (like DirectoryResource) to run a program that iterates over multiple lines in a document or webpage or multiple files in a directory.

### Module 2 - Strings in Java: Identifying Genes in DNA
In this module, Raluca Gordân, an assistant professor at Duke University’s Center for Genomic and Computational Biology, presents an important problem that genomics scientists often encounter - how to identify genes in a strand of DNA.
To solve this problem, you will need to understand strings, which are a series of characters such as letters, digits, punctuation, etc.
After learning about Java methods that work with strings, you will be able to find genes within a DNA string and tackle other string-related problems, such as finding all of the links on a web page. 

Acquired Skills:
  1) Understanding important methods for the Java String class
  2) Using conditionals, for loops, and while loops appropriately in a Java program
  3) Finding patterns in the data represented by strings to help develop algorithms for your program
  4) Understanding the importance of designing programs that keep different data processing steps separate
  5) Using the StorageResource iterable for this course to store some data for further processing
  6) Relying on Java documentation to better understand how to use different Java packages and classes.


### Module 3 - CSV Files and Basic Statistics in Java
A common format for storing tabular data (any data organized into columns and rows) is comma-separated values (CSV) files.
In this module, you will learn how to analyze and manipulate data from multiple CSV data files using a powerful open-source software package: Apache Commons CSV.
Using this library will empower you to solve problems that could prove too complex to solve with a spreadsheet.

Acquired Skills:
  1) Use the open-source Apache Commons CSV package in your own Java programs
  2) Access data from one or many CSV files using Java
  3) Convert strings into numbers
  4) Understand how to use “null” in Java programs (when you want to represent “nothing”)
  5) Devise an algorithm (and implement in Java) to answer questions about CSV data
  6) Analyze CSV data across multiple CSV files (for example, finding maximums, minimums, averages, and other simple statistical results).

## Module 4 - Mini Project BabyNames
This module wraps up the course with a mini project that ties together the different practices, skills, and libraries I have gained across the course!
Using data on the popularity of different baby names in the United States from the past several decades, I was able to compare different names’ popularity over time.

For this assignment, I was provided data on baby names from the United States and I had to answer questions about this data.
The data files give information on the first names of people born in a particular year. We have data from 1880 through 2014 on both boys and girls names.

<img width="747" alt="baby_names_instructions" src="https://github.com/s-dousse/Java-Programming-Solving-Problems-with-Software/assets/63320415/1dd277e9-8a0e-4077-a3e4-897709cfe56e">

For example, below are two pictures of parts of the  file "yob2014.csv", for names of babies born in 2014.
On the left is the top of the file which shows that Emma is the most popular name, the F is for females and the 20799 indicates the number of Emma’s born in 2014.
The file lists all the girls first, and they are listed in order based on the number of births, from largest numbers to smallest numbers.
On the right is another snapshot of the file, showing the end of the girls and the start of the boys.
You can see that Noah was the most popular boys name in 2014, the M indicates a male, and 19144 is the number of boys named Noah that year.
Also, notice there are no headers in this file. The video showed you how to access the fields in a .csv file when there are no headers.

Since these data files are quite large, I was also provided three small files with fake data for testing.
The three files have only ten lines each, 5 girls and 5 boys names, and smaller numbers to work with. You can download a .zip folder of the shortened baby name data by clicking 

I wrote a program with several methods and tester methods to test each method I wrote:
  - method **totalBirths** to also print the number of girls names, the number of boys names and the total names in the file.
  - method **getRank** that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male).
    This method returns the rank of the name in the file for the given gender,  where rank 1 is the name with the largest number of births.
  - method **getName** that has three parameters: an integer named year, an integer named rank, and a string named gender (F for female and M for male).
    This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME”  is returned.
  - method **whatIsNameInYear** that has four parameters: a string name, an integer named year representing the year that name was born,  an integer named newYear and a string named gender (F for female and M for male).
    This method determines what name would have been named if they were born in a different year, based on the same popularity.
    That is, you should determine the rank of the name in the year they were born, and then print the name born in newYear that is at the same rank and same gender.
  - method **yearOfHighestRank** that has two parameters: a string name, and a string named gender (F for female and M for male).
    This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. 
  - method **getAverageRank** that has two parameters: a string name, and a string named gender (F for female and M for male).
    This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. It should return -1.0 if the name is not ranked in any of the selected files.
  - method **getTotalBirthsRankedHigher** that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than name. For example, if getTotalBirthsRankedHigher accesses the "yob2012short.csv" file with name set to “Ethan”, gender set to “M”, and year set to 2012, then this method should return 15, since Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than Ethan. 


