My understanding of the Gnome sorting algorithm is that the gnome starts at
the second element of a given array and compares it to the previous element. If
the current element is greater than  or equal to the previous element, the gnome continues
forward. If the current element is less than the previous element it swaps those values
and continues to compare to move backwards until the current element is greater than the previous one or it
reaches the beginning of the array. Then the gnome moves forward again and repeats the process
sorting the array from least to greatest until the gnome is able to move forward completely
through the array because every element at current position is greater than or equal
to the previous.

For the cocktailShakerSort algorithm, I asked for clarification
from Gemini on the functionality of this. I understood it was supposed to be
a bubble sort variation and that it sorted from front to back as well as back to 
front, but I missed where that was in the pseudocode. After reading through it I realized I missed
this line " for each i in length(a) − 1 to 0 do:"
So my understanding is it compares pairs of elements from front to back 
by asking if the current element is greater than the next and swapping if so.
Once it gets to the end of the array it then compares the pairs from the back of the array to the
front, moving the smaller elements to the front faster than traditional bubble sort.

My understanding of shellSort algorithm is that you compare elements a
that are a fixed distance apart and swap them if needed, so they are smaller 
to larger (or least to greatest). The next pass you reduce the distance until the distance is 1 and you compare elements that are neighbors
.In our algorithm the distances are defined in the gaps array. This process
has a possibility of helping move smaller elements at the end of the array to the front much faster than a regular insertion sort.

The swaps were handled well, in the cocktailShakerSort and gnomeSort algorithms, it used the existing swap method, but in the Shell sort it did not.
The time comparison results were as follows:

Seconds       %       Task name
----------------------------------------
0.2078301     41%     Gnome Sort
0.2888057     58%     Cocktail Shaker Sort
0.0052731     01%     Shell Sort
