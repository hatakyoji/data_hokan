package hokan;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

		public class main_hokan {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
		    	
		    	BufferedReader br = null;

		        File file = new File("C:/Users/kyoji-ha/Desktop/IDソート後.csv");
		        FileWriter fw;
		        
		        //ここに解析したいファイルを指定する
		        //File file2 = new File("C:/Users/kyoji-ha/Desktop/log2016-02-12-13_all.csv");
	        
				try {
					fw = new FileWriter("C:/Users/kyoji-ha/Desktop/補完output.csv", true);
			      	PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			        br = new BufferedReader(new FileReader(file));

			    	String line;
			    	String[] tmp = new String[100];
			    	
			    	for(int j=0;j<78;j++){
	            		tmp[j]="";
			    	}
			    	
		            while ((line = br.readLine()) != null) {
		            	String[] split = line.split(",",-1);
		            	if(split[0].equals("time")){
		            		pw.println(line);
		            	}else{
//	            			pw.print(split[0]+",");
		            		for(int i=0;i<78;i++){
		            			if(split[i]==null || split[i].length() == 0){
		            				//THとCO2
		            				if(i<43){
		            					pw.print(tmp[i]+",");
		            				}
		            				//PIRとTMPとSWI
		            				else if((i>=64 && i<=66)||(i>=75)){
		            					pw.print(tmp[i]+",");
		            				}
		            				//OPN
		            				else{
		            					pw.print(split[i]+",");
			            				
		            				//	if(split[i].equals("OPEN")){
		            						
		            				//	}
		            				}
		            			} else {
	            					tmp[i] = split[i];
	            					pw.print(tmp[i]+",");
		            			}
		            		}
	            			pw.print("\n");
		            	}
		            }
		        	pw.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}  //※１
				finally {
		        try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}

			}

		}
