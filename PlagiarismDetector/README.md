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


OUTPUT:

The percentage of the manuscript content plagiarized from input file is output.


NOTES:

This application is coded such that the following improvements can be made with ease:

    The program can be scaled to take multiple input files to check for content used in the manuscript
    The parser can be scaled to have plugins of different file/document format readers; it can also
        be scaled to include grammar and sentence structuring using a grammar to find semantic similarities
    The renderer can be scaled to beautify the output or render graphics or webpage as required
    Additional book-keeping could be done in the reports for each input file or in the manuscript parsed 
        (which could in turn be used by the renderer perhaps for highlighting etc., or for performing 
        more analyses)
    The synonyms can be further scaled to have similarity metrics between words instead of treating 
        synonymous words as exactly equal
    
        
