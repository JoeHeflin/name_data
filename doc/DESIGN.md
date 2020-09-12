#data_team40 Design Outline

###Names
Joseph Heflin, jnh24

### Goals
The primary goal of this project was to make it easy to interact with baby name data of the format specified in 
NationalReadMe.md. I wanted to make it easy to add functions that analyze the data by controlling various 
factors such as the range of years, kinds of names, ranks of names, and gender.

### Features
The Name and NameArray classes are the cornerstones of the package. Each name object stores specific attributes
about each name which currently includes name, gender, count in one year, and rank. A NameArray object builds 
and maintains an ArrayList of names that fit given parameters. The NameArray constructor is what iterates
through a database and converts text files to ArrayLists of Names. The Frequencies class currently holds instance 
variables representing a list of something that occurs most often in a range in the data and the frequency at 
which that thing occurs. There are methods in Frequencies to find the maximum number of occurances of a letter
in a range of years for example. This class needs to be modified before adding new features. See the written 
report for details on those modifications.

### Assumptions
I assume that the data base can be accessed using either a url datastream or a FileReader data stream.

### Adding New Features
To add new features, create a new method in main that performs whatever task is required. In most cases, in
this method you will create some quantitiy of NameArray objects, passing the constructor the years you want
to get data from and the gender of the names. The years should be in the format [first year of range, last year
of range] If the new feature wants to perform calculations on multiple years individually to maybe 
compare them, iteratively create a new NameArray object for each year, passing the constructor a single int 
as the year.