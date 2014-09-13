IBC POST Sample
===============

Introduction
------------

This project is a sample application to showcase the IBC Air AMS Manifest submission REST API.
The REST api URL is: https://api.pactrak.com/manifest/aams.

The project will read the contents of the file and submit them via HTTP post to the IBC Rest API.
For more information on the creation of the required JSON structure, please visit the
IBC REST API documentation https://api.pactrak.com/manifest/aams.

Requirements
------------
Java Runtime Environment (1.6 or greater)

To Execute
----------
java -jar post.jar file_with_json_structure [-d]
or
use the run scripts that are in the distribution sample.
Note: If you need the set the HTTP proxy, you may modify the run scripts or set the proxy parameters in post.java source file.

To Compile
----------
Use the ant build script: ant install [clean|compile]
This command creates a distribution directory (dist) with a copy of the Jar and a run shell script.
For questions or inquiries please email us directly at it@ibcinc.com.

Best Regards

Alberto Ochoa
