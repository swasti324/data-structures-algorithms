# Sorting Algorithm Benchmarking and Research

## Benchmarking
Test the performance of your sorting algorithms on sorting different sized lists of numbers. Create some representation (e.g., a table r a graph) of the runtimes of the algorithms as a function of list size. In a writeup (I would suggest a markdown file), discuss how you tested your algorithms (e.g., how you generated the lists to be sorted, how many times you performed each experiment). Draw some conclusions based on your experiment (e.g., which algorithm seems faster and in which cases).
### Testing

The main function measures the execution time of the four implemented sorting algorithms (Insertion, Selection, Heap, Merge) on arrays of increasing size.
The function iterates 20 times, doubling the size of the array each time. It measures the time each algorithm takes to complete and stores them in separate lists.
The printed time intervals are then plotted against the size of the array in a separate MATLAB file.
### Performance
Below is a graph denoting the difference in efficiency as the size of the array increases exponentially

![](/home/swasti/Documents/Data Structures and Algorithms/data-structures-algorithms/homework4/Sorting/src/SortingAlgPerformance.png)

Strikingly the Heap Sort algorithm takes the longest time when the size increases. Whereas the merge sort algorithm is consistent.
This is due to the divide and conquer implementation that Merge Sort adopts. Heap sort must allocate a lot of space and time to complete its sorting. 

## Research
Do some research to determine what new problems exist in terms of sorting. In your writeup, discuss at least one variant of sorting that has active research. Make sure you explain what solving this problem entails. Read one research paper that is related to this sorting problem and summarize its contributions (you may not be able to understand the paper at full detail, but hopefully you can get the gist).

### Paper: Faster sorting algorithms discovered using deep reinforcement learning
#### Authors: Mankowitz, D.J., Michi, A., Zhernov, A. et al. 
The authors of the paper wanted to see if they could use artificial intelligence to find new ways to sort things that are even faster than what humans have come up with. 
They created a new deep reinforcement learning agent called AlphaDev and trained it to come up with new sorting methods by playing a single player game.
The study shows the potential of AI to advance critical computing tasks, such as sorting, by autonomously discovering more efficient methods than previously known human-designed algorithms.





