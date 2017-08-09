import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class TestRegularExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String  m_data = "2017-07-31 10:54:34,257:WARNING:oc-service:uploading local file: /usr/lib64/python2.6/site-packages/oracle/cloud/compute/admin/libs/audit_shim_connection.py on node: 10.89.1.53, at :/tmp/audit_shim_connection.py";
	    if ( m_data.contains("uploading local file") ){
	         String regex = "(\\d+\\.\\d+\\.\\d+\\.\\d+),\\s+at\\s+:(\\S+)";
	                 Pattern p = Pattern.compile( regex );
	                 Matcher m = p.matcher( m_data );

	                 if( m.find( )) {
	                     String ip = m.group( 1 );
	                     String fullFilePath = m.group( 2 );
	                     System.out.println("get Ip and File as :" +fullFilePath+"  "+ip);
	                 }

	    }
	}

}
