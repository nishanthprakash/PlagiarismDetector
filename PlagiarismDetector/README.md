PLAGIARISM DETECTOR
-------------------

SYNOPSIS

    PlagiarismDetector SYNONYM_FILE_NAME MANUSCRIPT INPUT_FILE [ TUPLE_SIZE ]

DESCRIPTION:

This is a program that checks for plagiarism between two given files
using another file containing sets of synonym functions 

SYNONYM_FILE_NAME is a file name of a file containing a list of synonyms where each
    where each line contains a set of interchangeably synonymous words

MANUSCRIPT is one of the two files to be compared for plagiarism

INPUT_FILE is another of the two files to be compared for plagiarism

TUPLE_SIZE this is an optional parameter, which is a number specifying the number of
    contiguous words in a tuple that must be checked for co-occurrence
