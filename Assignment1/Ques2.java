


import java.util.*;

public class Ques2 {
    
    public String replaceWords(String paragraph, Map<String,Integer> map){
        if(paragraph == null || paragraph.length() < 1)
            return null;
        
        StringBuilder new_paragraph = new StringBuilder();
        for(int i=0;i<paragraph.length();){
            int j=i;
            for(;j<paragraph.length();j++){
                if(paragraph.charAt(j)==' '){
                    break;
                }
            }
            String word=paragraph.substring(i,j);
            i=j+1;
            if(map.get(word)!=null){
                StringBuilder new_word= new StringBuilder();
                new_word.append(word.charAt(0));
                for(int index=1;index<word.length();index++){
                    new_word.append('*');
                }
                new_paragraph.append(' ');
                new_paragraph.append(new_word.toString());
            }
            else{
                new_paragraph.append(' ');
                new_paragraph.append(word);
            }
        }
        
        return new_paragraph.toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter paragraph:");
        Scanner sc = new Scanner(System.in);
        String paragraph = sc.nextLine();
        System.out.println("Enter number of words to be replaced:");
        int n = sc.nextInt();
        sc.nextLine();
        Map<String,Integer> words = new HashMap<>();
        if(n>0)
        	System.out.println("Words to be replaced are: ");
        for(int i=0; i<n; ++i){
        	System.out.println("Enter word number "+(i+1)+":");
            String word = sc.nextLine();
            words.put(word,1);
        }
        Ques2 obj = new Ques2();
        String new_paragraph = obj.replaceWords(paragraph, words);
        System.out.println("New paragraph is: "+ new_paragraph);
    }
    
}