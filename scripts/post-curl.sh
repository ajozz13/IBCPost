#!/bin/sh
OUT_FILE=output-file.txt

if [ -f $OUT_FILE ]
then
	rm $OUT_FILE
fi

echo Posting the contents of data-json.txt
echo You may need to turn on a proxy? if so run export http_proxy=http://proxy:3128

curl -siL -X POST -k --data "@$1" https://api.pactrak.com/manifest/aams?_test -o $OUT_FILE

echo --------------- 
more $OUT_FILE
