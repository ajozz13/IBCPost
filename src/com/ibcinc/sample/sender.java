/*      This is a Java class that will read the input of a file and submit the contents to 
        a Restful web service, using a specific HTTP method and using a specific content-type.
        
        Use this software at your own risk.
*/

package com.ibcinc.sample;

import java.net.*;
import java.io.*;

public class sender {
	
        private File inputFile;
        private String inurl;
        private boolean debug = false;

        //Main Constructor requires the path of the input file and the service URL
	public sender( String _inputFile, String _url ){
                inputFile = new File( _inputFile );
                inurl = _url;
        }

        //Specify if more output should be displayed.
        public void setDebug( boolean _debug ){
                debug = _debug;
        }

        //Perform the specific HTTP post operation and report back the server response.	
	public void sendRequest( String method, String content ) throws Exception{
                if( debug ){	        
                        System.out.println( String.format( "Post to: %s %nInputFile: %s %nMethod: %s, Content: %s %n=============================", inurl, inputFile.getAbsolutePath(), method, content ) );
                }
		URL url = new URL( inurl );
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setDoInput( true );
                connection.setDoOutput( true );
                connection.setRequestMethod( method );
                connection.setRequestProperty( "Content-Type", content );
		
		String inputLine;
                StringBuilder builder = new StringBuilder();
                BufferedReader input =  new BufferedReader( new FileReader( inputFile ) );
                if( debug ){ System.out.print( "Read Input file...." ); }
                while (( inputLine = input.readLine()) != null ){
                        builder.append( inputLine );
                }
                System.out.println( String.format( "Input File: %s", builder.toString() ) );
                if( debug ){ System.out.print( "Done....Start Post...." ); }

                //Send request              
                OutputStream output = connection.getOutputStream();
                output.write( builder.toString().getBytes() );
                output.flush();
                
                System.out.println( String.format( "Response code = %d", connection.getResponseCode() ) );
                
                InputStream is = null;
                try{
                        is = connection.getInputStream();
                }catch( Exception e ){
                        is = connection.getErrorStream();
                }

                BufferedReader reader = new BufferedReader( new InputStreamReader( is ) );
                String response;
                System.out.println( "------------------------------" );
                System.out.println( "Server Response:" );
                while( ( response = reader.readLine() ) != null ){
                        System.out.println( response );
                }
                
                connection.disconnect();
	}
}
