import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

public class Wolfram {

	private static String appid="";
	public String Result="Null";
	
	public Wolfram(String input ) {
		WAEngine engine= new WAEngine();
		
		engine.setAppID(appid);
		engine.addFormat("plaintext");
		
		WAQuery query= engine.createQuery();
		
		query.setInput(input);
		
		try {
			System.out.println("Query URL:");
			System.out.println(query);
			System.out.println("");
			
			WAQueryResult queryResult= engine.performQuery(query);
			
			if(queryResult.isError()) {
				System.out.println("Query error");
			}else if(!queryResult.isSuccess())
				System.out.println("Query was not understood; no results available");
			else {
				System.out.println("Success");
				for (WAPod pod : queryResult.getPods()) {
					if(!pod.isError()&& pod.getTitle().equalsIgnoreCase("Result")) {
						System.out.println(pod.getTitle());
						System.out.println("---------");
						for(WASubpod subpod : pod.getSubpods()) {
							for(Object element : subpod.getContents()) {
								if(element instanceof WAPlainText) {
									System.out.println(((WAPlainText) element).getText());
									if(pod.getTitle().equalsIgnoreCase("Result")) {
										Result=((WAPlainText) element).getText().toString();
										System.out.println("This is the String"+Result);
									}
									System.out.println("");
								}
							}
						}
						System.out.println("");
					}
				}
			}
		}catch (WAException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
