import java.util.*;

public class App {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter number of customers:\t");
        int n=sc.nextInt();

        System.out.print("\nEnter number of Drivers:\t");
        int m=sc.nextInt();

        List<Integer> ot=new ArrayList<>();
        List <Integer> tt=new ArrayList<>();

        for (int i =0;i<n;i++){
            System.out.print("Enter order time of C"+ (i+1)+": \t");
            ot.add(sc.nextInt());

            System.out.print("Enter travel time of C"+ (i+1)+": \t");
            tt.add(sc.nextInt());

        }

        List<int[]> combined_orders= new ArrayList<>();
        for (int i=0; i<n;i++){
            combined_orders.add(new int[]{i,ot.get(i),tt.get(i)});
        }

        combined_orders.sort(Comparator.comparingInt(a->a[1]));

        List <String> res=new ArrayList<>();

        int[] driverFreeTime=new int[m];
        Arrays.fill(driverFreeTime,0);

        for (int [] order: combined_orders){
            int index=order[0];
            int orderTime=order[1];
            int travelTime=order[2];

            Integer driver=null;

            for (int d=0;d<m;d++){
                if(driverFreeTime[d]<=orderTime){
                    driver=d;
                    driverFreeTime[d]=orderTime+travelTime;
                    break;
                }

        
            }

            if(driver!=null){
                res.add("C" + (index+1)+"-> D"+(driver+1));
            }
            else{
                res.add("C"+(index+1)+"-> No Food:(");
            }
        }

        for (String r : res){
            System.out.println(r);
        }

    }
}
