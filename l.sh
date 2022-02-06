#!/bin/bash

regexString='release'

echo $(git branch -a | grep $regexString | grep -E '([0-9]+\.){2}[0-9]+' | sort --version-sort | tail -n 1 | sed 's@.*/@@')
