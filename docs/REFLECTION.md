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

