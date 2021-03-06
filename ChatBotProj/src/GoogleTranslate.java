import com.google.cloud.translate.*;
import com.google.cloud.translate.Translate.TranslateOption;
public class GoogleTranslate {
	
	Translate translate = TranslateOptions.newBuilder().setApiKey("").build().getService();
	String Result="";
	String lan="";
	String prevLan="en";
	int count=0;
	
	public void DetectAndTranslate(String s) {
		Detection detection= translate.detect(s);
		System.out.println(detection);
		String language=detection.getLanguage();
		lan=language;
		if(language.equalsIgnoreCase("en")&& count==1) {
			TranslateToUnknown(s);
		}
		else if(language.equalsIgnoreCase("en")||s.equals(""))
			Result=s;
		else
			TranslateToEngUser(s);
	}
	
	public void TranslateToEngUser(String s) {
		Translation translation = translate.translate(
				s,
				TranslateOption.sourceLanguage(lan),
				TranslateOption.targetLanguage("en"));
		
		prevLan=lan;
		count=1;
		
		System.out.printf("Translated Text:\n\t%s\n", translation.getTranslatedText());
		Result=translation.getTranslatedText();
	}
	public void TranslateToUnknown(String s) {
		Translation translation = translate.translate(
				s,
				TranslateOption.sourceLanguage(lan),
				TranslateOption.targetLanguage(prevLan));
		
		
		System.out.printf("Translated Text:\n\t%s\n", translation.getTranslatedText());
		Result=translation.getTranslatedText();
	}
	
}
