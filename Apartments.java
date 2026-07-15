import java.io.*;
import java.util.*;

public class Apartments {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numOfPeople = Integer.parseInt(st.nextToken());
        int numOfAppartments = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] people = new int[numOfPeople];
        int[] appartments = new int[numOfAppartments];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numOfPeople; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numOfAppartments; i++){
            appartments[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);
        Arrays.sort(appartments);

        int i1 = 0, i2 = 0, count = 0;

        while(i1 < numOfPeople && i2 < numOfAppartments){
            int p = people[i1];
            int a = appartments[i2];

            if(a >= p - k && a <= p + k){
                count++;
                i1++;
                i2++;
            }
            else if(a < p - k){
                i2++;
            }
            else{
                i1++;
            }
        }

        System.out.println(count);
    }
}