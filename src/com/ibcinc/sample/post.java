/*      This is a sample Java application of a POST submssion to IBC's Manifest submit API.
        For the specific information on how to create the IBC Json structure please visti:
        https://api.pactrak.com/manifest/aams
        
        Use this software at your own risk.
*/

package com.ibcinc.sample;

public class post{
	public static void main( String[] args ){
                int exit_code = 0;
		try{
			if( args.length < 1 ){
				throw new Exception( "Usage: java -jar post.jar file_with_json_structure [-d]" );	
			}else{
                                //** If you need to setup your proxy specify below
                                //System.setProperty( "http.proxyHost", "proxy.ibcinc.com" );
                                //System.setProperty( "http.proxyPort", "3128" );

                                //create the sender object and send the request.
                                sender s = new sender( args[ 0 ], "https://api.pactrak.com/manifest/aams?_test" );
                                s.setDebug( set( args, "-d" ) );
                                s.sendRequest( "POST", "application/x-www-form-urlencoded" ); // "application/json" );
			}
		}catch(Exception t){
			System.out.println( t.getMessage() );
			t.printStackTrace();
			exit_code = 1;
		}finally{
                        System.exit( exit_code );
                }

	}
	
        //Set a flag based on the existance of a specific switch
	public static boolean set( String[] args, String searchFor ){
		int counter = 0;
		for(String s : args){
			counter++;
			if(s.equalsIgnoreCase(searchFor)){
				return true;
			}
		}
		return false;
	}
}
