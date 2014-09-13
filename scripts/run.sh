#!/bin/bash
# java -jar post.jar file_with_json_structure [-d]
JAVA_FLAGS="-Dhttp.proxyHost=proxy -Dhttp.proxyPort=3128"

java ${JAVA_FLAGS} -cp . -jar IBCPost.jar $*
