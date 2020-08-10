import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main{
    static List<String> words=new ArrayList<String>();
    static List<Integer> repeated=new ArrayList<Integer>();
    static String[] totalwords;

    public Main(String fileName, int topN) throws IOException {
        File fp=new File("dosya.txt");
        BufferedReader br=new BufferedReader(new FileReader(fp));
        String filexx=br.readLine()+" "+br.readLine()+" "+br.readLine();
        totalwords=filexx.split(" ");
        computeEntropy();
        computeAvgLengthByFirstChar();
        Set pairs = calculateMinPairDist();
    }

    private void computeEntropy() {
        for(String word:totalwords)
        {
            if(!words.contains(word))
            {
                words.add(word);
                repeated.add(1);
            }
            else
            {
                int index=words.indexOf(word);
                repeated.set(index, repeated.get(index)+1);

            }

        }

        double entropy = 0;

        for(int i=0;i<repeated.size();i++)
        {
            int a=repeated.get(i);

            double Pt=(double)a/(double)totalwords.length;
            entropy+=Pt*Math.log10(Pt)/Math.log10(2);
        }
        System.out.println("entropy  : " + -entropy);
    }

    private void computeAvgLengthByFirstChar() throws FileNotFoundException, IOException {
        List<String> numbersandcharacters = new ArrayList<>();
        List<Integer> length =new ArrayList<>();
        List<Integer> total =new ArrayList<>();



        for(String word:totalwords)
        {
            if(!numbersandcharacters.contains(String.valueOf(word.charAt(0))))
            {
                numbersandcharacters.add(String.valueOf(word.charAt(0)));
                length.add(word.length());
               total.add(1);
            }
            else
            {
                int index = numbersandcharacters.indexOf(String.valueOf(word.charAt(0)));
                length.set(index, length.get(index)+word.length());
                total.set(index, total.get(index)+1);
            }



        }
        for(int i=0;i<numbersandcharacters.size();i++)
        {
            System.out.println(numbersandcharacters.get(i)+" "+ String.valueOf((float)length.get(i)/(float)total.get(i)));
        }



    }

    private Set calculateMinPairDist() {



        TreeSet<Listxx> set = new TreeSet<Listxx>();

        double score;
        double numerator;
        for(String t1:words)
        {
            for(String t2:words)
            {
                if(!t1.equals(t2))
                {
                    numerator=(double)(repeated.get(words.indexOf(t1))*repeated.get(words.indexOf(t2)));
                    score=numerator/(1+Math.log10(d(t1,t2))/Math.log10(Math.E));
                    set.add(new Listxx(t1, t2, score));

                }
            }


        }


        for(int i=0;i<11;i++)
        {
            Listxx temp;
            temp=set.pollLast();
            System.out.println(temp.t1+" " +temp.t2+" "+temp.score);
        }







        return null;
    }





    public static int d(String t1,String t2)
    {
        int distance = 0;
        int t1index = 0;

        for(int i=0;i<totalwords.length;i++)
        {

            if(t1.equals(totalwords[i]))
            {

                for(int j=i;j<totalwords.length;j++)
                {
                    if(t1.equals(totalwords[j]))
                    {
                        t1index=j;
                    }
                    if(t2.equals(totalwords[j]))
                    {
                        distance+=j-t1index;
                        break;
                    }

                }
            }

        }
        return distance;
    }



    public static void main(String[] args) throws IOException {
        new Main(args[0],Integer.parseInt(args[1]));














    }

}
