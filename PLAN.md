# Data Plan
## Joseph Heflin

This is the link to the [assignment](http://www.cs.duke.edu/courses/compsci307/current/assign/01_data/):


### What is the answer to the two questions below for the data file yob1900.txt (pick a letter that makes it easy to answer)? 
1)Mary, John
2)There are 27407 different males that have one of 71 names beginning with J.

### Describe the algorithm you would use to answer each one.
For the first question I plan on reading in the file, iterating through each line of text, and reading the third element of each comma separated line.
I'll compare this value to a gender specific variable containing the current maximum count. If the value read is higher than the current max then that value becomes the max.
After reading every line in a single file the correct answers should be the current name values for each gender.

For the second question I'll also iterate through each line and if the first letter of the name matches the letter given then add 
the count for that line to a running sum and increment a variable tracking the name count.
### Likely you may not even need a data structure to answer the questions below, but what about some of the questions in Part 2?
I think that I'll need to create a structure to form rankings based on name popularity which is the subject of multiple questions
An array of linked lists, where access time for the alphabetically first name at each rank is O(1), might be the best option.
This might be the best option for question number two.
It might require another data structure like a binary search tree to be able to find name specific information quickly.

### What are some ways you could test your code to make sure it is giving the correct answer (think beyond just choosing "lucky" parameter values)?
There are a few specific cases to test:
* Give a name that doesn't exist in the database.
* Try unisex names which appear twice in the dataset; once as male adn once as female.

### What kinds of things make the second question harder to test?
The files seem to be sorted by number of names to searching for a name will be harder to find manually in the data set.
Finding the top names for each gender is easy; it's just the top name and then the first one that's male.

### What kind of errors might you expect to encounter based on the questions or in the dataset?
Possible errors:
* Name not found

### How would you detect those errors and what would a reasonable "answer" be in such cases?

### How would your algorithm and testing need to change (if at all) to handle multiple files (i.e., a range of years)?
When considering multiple files, an algorithm that assigns rankings assuming the list of given names is sorted using name
count won't work. This new algorithm has to be able to rank nonsequentially. 
