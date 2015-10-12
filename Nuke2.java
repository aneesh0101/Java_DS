import java.io.*;

class Nuke2{
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i=0; i<s.length();i++){
            if(i == 1){
                continue;
            }
            System.out.print(s.charAt(i));
        }
    }
}