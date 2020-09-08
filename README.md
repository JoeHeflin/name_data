data
====

This project uses data about [baby names from the US Social Security Administration](https://www.ssa.gov/oact/babynames/limits.html) to answer specific questions. 


Name: Joseph Heflin, jnh24

### Timeline

Start Date: 08/04/2020

Finish Date: 09/08/2020

Hours Spent: ~35+ hours

### Resources Used
####Online resources:
- [stackoverflow.com for navigating some errors information and regex help](https://stackoverflow.com/)
- [The Google Java Style Guide provided by Professor Duvall](https://google.github.io/styleguide/javaguide.html)
- [Java Documentation for basic syntactical stuff](https://docs.oracle.com/javase/8/docs/api/index.html)
####Human Resources:
- My lab partner Onome Akinbode-James did a code review on 09/04
- TA Orgil Batzaya

### Running the Program

Main class: src/names/Main.java

Data files needed: 
To use a local  data source run
~~~
Main.setDataPath("<Relative path to resource directory containing .txt files>");
~~~
To use a remote data source run
~~~
Main.setDataPath("<URL of directory containing .txt files>");
~~~
Data files are provided under the data directory in subdirectories titled "ssa_2000s" and "ssa_complete". The answers provided by running Main.main() uses the data in the data/ssa_complete/ directory. To run Main.main() with another dataset modify the argument passed in setDataPath() in line 139.

Test files:
The testdata/ directory contains the files used by the jUnit tests found in the test/ directory.
Certain data errors will throw exceptions:
- An invalid filename in the resource directory that isn't of the form yob\d+.txt.
- Missing file(s) for a year when querying about a range of years containing the missing year.
- Name not found in data file except for one **very important** instance. When running methods that find the ranks of names over a range of years and the name isn't found, the method will return the rank one below the least occuring name in the data file. I'm not sure how to indicate this otherwise without print statements.

Known Bugs:
The program stalls when running Complete5.maxAvgRank() on a dataset as large as a few years in data/ssa_complete/. The algorithm I used works only for the small test files that I made. I didn't realize it wasn't scalable until too late. It very well could work on the larger dataset but runtime would be on the order of minutes, even for a small set of files.

Extra credit:
I did not leave myself time to attempt the two optional questions.


### Notes/Assumptions
I assume that the data within the files follows the format as specified in NationalReadMe.pdf except I don't require that data is sorted in any way.
I also assume that in question number two of the Basic implementation is asking for both the male and female name/gender pairs that match the rank of the given name/gender/year. (ie if a female name Sally ranked third in 2002, then for the most recent year I return the third place males and females.) It would be easy to provide a gender specific answer I was just unclear as to what the question required.)
### Impressions
I think that I would have saved a lot of time spent refactoring if I had some specs from Complete when I started. It was kind of cool to see how each deadline forced my approach to change but I'd trade that for more time to work on my final product. I also wish that I had an opportunity for a TA code review before now.

