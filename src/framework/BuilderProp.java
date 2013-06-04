package framework;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import android.os.Environment;

import com.stericson.RootTools.RootTools;

public class BuilderProp{

	public static List<String> getPropArray() throws IOException{
		//final Properties prop = new Properties();
		List<String> where = new ArrayList<String>();
		//String[] stockArr = new String[where.size()];
	    //stockArr = where.toArray(stockArr);
	    //System.out.println(stockArr);
		FileInputStream in = new FileInputStream(new File("/system/build.prop"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder text = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null){
			if (!line.startsWith("#")) {
				if(!"".equals(line)){
				where.add(line);
				//where.toString();
				//text.append(where);
		}
			}
		}
		reader.close();
		return where;
	}
}

