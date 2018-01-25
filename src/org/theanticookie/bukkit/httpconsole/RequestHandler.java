package org.theanticookie.bukkit.httpconsole;

import org.bukkit.Bukkit;

import java.io.StringWriter;

import org.json.simple.JSONObject;
import org.theanticookie.bukkit.HTTPConsole;

/**
 * Handles path /console POST/GET requests by executing the requested console
 * command on the minecraft console.
 *
 * @author BlueJeansAndRain
 */
public class RequestHandler extends HTTPRequestHandler
{

    public RequestHandler(  )
    {
    }

    private String executeConsoleCommand( final String command )
    {
        log( "Executing \"%s\"", command );
        final HTTPCommandSender sender = new HTTPCommandSender();   
        // Prevent concurrent exceptions, make sure that command is executed on MAIN
        // thread and not somewhere else. Otherwise we end up with. Shit.
        Bukkit.getServer().getScheduler().runTask(HTTPConsole.self, new Runnable() {
        	public void run() { 
        		try
        		{
        			Bukkit.getServer().dispatchCommand(sender, command); 
        		}
        		catch (Exception e) { /* no-op */ }
        		synchronized (sender) { sender.notifyAll(); }
        	}
        });  
        synchronized (sender) { try {
			sender.wait();
		} catch (InterruptedException e) {
			/** Shit? **/
		} }
        return sender.getOutput();
    }

    public boolean HandlePath( String path )
    {
        if ( path.equalsIgnoreCase( "/console" ) || path.equalsIgnoreCase( "/" ) )
            return true;

        return false;
    }

    public boolean HandleRequest( HTTPRequest request, StringWriter out )
    {
        if ( !request.method.equals( "GET" ) && !request.method.equals( "POST" ) )
            return false;

        String command = "";
        if ( request.parameters.containsKey( "command" ) )
        {
            command = request.parameters.get( "command" ).trim();
        }
        else if (  request.data instanceof JSONObject )
        {
            JSONObject json = (JSONObject)request.data;
            try
            {
                command = (String)json.get( "command" );
            }
            catch ( Exception e )
            {
                // Silently fail.
            }
        }

        String output = "";
        int response_code = 200;

        if(!(command.equals(""))){
            output = executeConsoleCommand( command );
        }


        HTTPResponseHeaderHelper.outputHeaders( response_code, out );
        out.write(output);

        return true;
    }
}
