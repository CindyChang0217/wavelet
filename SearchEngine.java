import java.net.URI;
import java.util.ArrayList;
import java.io.IOException;
class Handler implements URLHandler{
    ArrayList<String> str = new ArrayList<String>();
    public String handleRequest(URI url){
        if (url.getPath().equals("/")) {
            return "";}
        if (url.getPath().contains("/add")){
            String[] parameter = url.getQuery().split("=");
            if (parameter[0].equals("s")){
                str.add(parameter[1]);
                return "";
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
                String output="";
                for (int i=0; i<result.size(); i++){
                    output=output+result.get(i)+" ";
                }
                return output;
            }
        }
        return "404 not found";
    }
    
}
class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

