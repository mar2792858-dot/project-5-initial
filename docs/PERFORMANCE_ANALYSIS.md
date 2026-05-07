Results: 

Unsorted data...

First 10 of Array...
1: 25689
2: 6683
3: 7058
4: 48874
5: 22204
6: 18154
7: 30565
8: 12776
9: 18198
10: 46007

Gnome Sort...

First 10 of Array...
1: 6
2: 15
3: 15
4: 17
5: 32
6: 33
7: 37
8: 38
9: 43
10: 46
Time elapsed: 202.7397 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 6
2: 15
3: 15
4: 17
5: 32
6: 33
7: 37
8: 38
9: 43
10: 46
Time elapsed: 258.4044 ms

Shell Sort...

First 10 of Array...
1: 6
2: 15
3: 15
4: 17
5: 32
6: 33
7: 37
8: 38
9: 43
10: 46
Time elapsed: 6.4866 ms

StopWatch '': 0.4676307 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.2027397     43%     Gnome Sort
0.2584044     55%     Cocktail Shaker Sort
0.0064866     01%     Shell Sort


-------------------------------------

Complexity Observations and analysis: 

The shell sort was by far the quickest. which I expected because of it being sequence based and using the
specific sequence for the gaps seemed like it would be effective. The cocktail shaker and gnome algorithms 
I expected to be close, but Cocktail shaker is consistently slower than gnome sort. I believe
this is because gnome sort deals with a swap when it comes upon it and as the array becomes sorted,
there are less elements to pass through. Whereas cocktail shaker does not deal with smaller elements toward the end of the array
until it is done with the pass forward and starts passing through it backward. Still is often
faster than bubble sort because it passes through the array in both directions, moving smaller
elements toward the front faster than bubble sort. So cocktail shaker is much faster on data that is nearly sorted compared
to data that is reverse ordered. Gnome sort is pretty consistently O(n^2) because it is a simple swap and move back algorithm, there are many swaps and it
has to loop through the array at least one time under a perfectly sorted array. 
