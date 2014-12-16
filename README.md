Traffic simulation
=======

Ioopm traffic assignment
A program for simulating a road crossing with support for loading parameter values from a text file.


      C           B                               A
    s1<----r1-----<---------r0---------------------
    s2<----r2-----< 


## Usage ##

    Compile and run with make.
    Parameter values can be assignened in the properties.data file in the bin directory.



### Parameters
    AtoB        - length of lane between A and B
    BtoC        - length of lane between B and C
    Turn        - length of turn lane
    delay       - delay between printouts
    steps       - number of steps to perform simulation
    period      - traffic light full period
    green       - traffic light green period
    frequency   - car spawn frequency (0 - 100)
