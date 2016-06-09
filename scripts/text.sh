#!/bin/bash
awk '$1=$1' ORS='\\n' $1 | sed 's/"/\\"/g'
