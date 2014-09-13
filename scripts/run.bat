@echo off
set JAVA_FLAGS="-Dhttp.proxyHost=proxy -Dhttp.proxyPort=3128"
java %JAVA_FLAGS% -cp . -jar IBCPost.jar %*
