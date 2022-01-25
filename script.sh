#!/bin/bash

FILENAME="all_projects"
LINES=$(cat $FILENAME)
             for LINE in $LINES
             do
                echo "$LINE"
             done
