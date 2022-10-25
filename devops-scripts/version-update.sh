#!/bin/bash

version="$1"
major=0
minor=0
patch=0

# break down the version number into it's components
regex="([^0-9]*)([0-9]+).([0-9]+).([0-9]+)"
if [[ $version =~ $regex ]]; then
  major="${BASH_REMATCH[2]}"
  minor="${BASH_REMATCH[3]}"
  patch="${BASH_REMATCH[4]}"
fi

# check paramater to see which number to increment
if [[ "$2" == "minor" ]]; then
  minor=$(echo $minor + 1 | bc)
  patch=0
elif [[ "$2" == "patch" ]]; then
  patch=$(echo $patch + 1 | bc)
elif [[ "$2" == "major" ]]; then
  major=$(echo $major+1 | bc)
  minor=0
  patch=0
else
  echo "usage: version_number [major/minor/patch]"
  exit -1
fi

# echo the new version number
echo "${BASH_REMATCH[1]}${major}.${minor}.${patch}"