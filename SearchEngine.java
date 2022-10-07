import java.net.URI;
import java.util.ArrayList;
class SearchEngine implements URLHandler{
    ArrayList<String> str = new ArrayList<String>();
    public String handleRequest(URI url){
        if (url.getPath().contains("/add")){
            String[] parameter = url.getQuery().split("=");
            if (parameter[0].equals("s")){
                str.add(parameter[1]);
            }
        }
        if (url.getPath().contains("/search")){
            String[] parameter = url.getQuery().split("=");
            if (parameter[0].equals("s")){
                ArrayList<String> result = new ArrayList<String>();
                for (int i=0; i<str.size(); i++){
                    if (str.get(i).contains(parameter[1])){
                        result.add(str.get(i));
                    }
                }
                for (int i=0; i<result.size(); i++){
                    return result.get(i);
                }
            }
        }
        return "";
    }
    
}
