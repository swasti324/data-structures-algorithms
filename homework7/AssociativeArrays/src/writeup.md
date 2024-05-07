# Markov Analyzer for Bee Movie Script

## Overview
This project analyzes the occurrences of selected words in the Bee Movie script and visualizes the results using a simple text-based graph. It utilizes a custom implementation of a Markov Analyzer and an Associative Array data structure in Kotlin.

## Components
1. **AssociativeArray Class**: This class represents a mapping of keys to values. It provides functionalities such as insertion, key existence check, value retrieval, removal, and size retrieval.

2. **CustomMarkovAnalyzer Class**: This class is responsible for analyzing the occurrences of a target word in the Bee Movie script. It reads the script from a file, processes it to extract words, cleans the words, and counts the occurrences of the target word followed by other words.

3. **Main Function**: The main function orchestrates the analysis process. It defines a list of words to analyze, iterates through each word, invokes the `analyze` method of `CustomMarkovAnalyzer`, stores the total occurrences of each word, and then prints the results.


## Output
### Words Tested:
- bee
- honey
- love
- hive
- queen
- worker
- human
- pollen

```angular2html
Graph:
bee: ############################################################################### (79)
honey: ############################################################## (62)
love: ##### (5)
hive: ############ (12)
queen: ###### (6)
worker: # (1)
human: ################# (17)
pollen: ###################### (22)


Analyzing occurrences of 'bee'...
Occurrences of 'bee':
should
of
have
existence
jobs
enough
pouring
died
pourer
law
in
Barry
but
law
BARRY
BARRY
And
is
joke
law
law
my
BARRY
WORKER
WORKER
Thinking
Thinking
Thinking
Flash
JANET
JANET
Mooseblood
boy
Mooseblood
do
beards
Barry
community
century
VANESSA
VANESSA
team
Montgomery
Honeys
culture
And
Ive
documentary
children
arent
smoker
smoker
Montgomery
way
work
gets
plant
joke
Its
on
shouldnt
way
Barry
Thinking
On
Thinking
Thinking
BARRY
Thinking
Thinking
CONTROL
Thinking
Thinking
BARRY
power
honey
is
my
Me
Total occurrences: 79
--------------------------------------------------
Analyzing occurrences of 'honey'...
Occurrences of 'honey':
into
that
field
JANET
Our
and
for
because
You
He
Barry
pool
until
and
and
pool
for
shocked
Barry
out
coming
jars
and
and
Our
is
Thats
We
packaging
industry
you
KLAUSS
I
slaves
industry
will
is
that
of
container
with
SNIPER
in
into
OLD
truck
is
production
The
Cannonball
and
production
was
back
Who
would
trial
takes
pollinate
factories
with
in
Total occurrences: 62
--------------------------------------------------
Analyzing occurrences of 'love'...
Occurrences of 'love':
this
it
it
a
the
Total occurrences: 5
--------------------------------------------------
Analyzing occurrences of 'hive'...
Occurrences of 'hive':
ADAM
Our
ADAM
flying
BARRY
but
right
talking
with
I
WORKER
We
Total occurrences: 12
--------------------------------------------------
Analyzing occurrences of 'queen'...
Occurrences of 'queen':
was
was
who
Thats
What
give
Total occurrences: 6
--------------------------------------------------
Analyzing occurrences of 'worker'...
Occurrences of 'worker':
bees
Total occurrences: 1
--------------------------------------------------
Analyzing occurrences of 'human'...
Occurrences of 'human':
hand
saved
I
ADAM
florist
walks
girlfriend
race
world
race
news
for
news
race
teatime
species
news
Total occurrences: 17
--------------------------------------------------
Analyzing occurrences of 'pollen'...
Occurrences of 'pollen':
that
than
jocks
jocks
jocks
jock
jock
jock
as
here
power
more
jock
jocks
jocks
jock
VANESSA
I
to
to
from
from
Total occurrences: 22
--------------------------------------------------
Total Occurrences:
bee: 79
honey: 62
love: 5
hive: 12
queen: 6
worker: 1
human: 17
pollen: 22


```