import java.util.*;
class Engine{
    private int engineId;
    private String engineName;
    private String engineType;
    private double enginePrice;
    public Engine(int engineId, String engineName, String engineType, double enginePrice){
        this.engineId = engineId;
        this.engineName = engineName;
        this.engineType = engineType;
        this.enginePrice = enginePrice;
    }
    public int getEngineId(){return engineId;}
    public double getEnginePrice(){return enginePrice;}
    public String getEngineType(){return engineType;}
    public String getEngineName(){return engineName;}
}
public class Solution25 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Engine[] engines = new Engine[4];
        for(int i=0;i<4;i++){
            int engineId = sc.nextInt();
            sc.nextLine();
            String engineName = sc.nextLine();
            String engineType = sc.nextLine();
            double enginePrice = sc.nextDouble();
            sc.nextLine();
            engines[i] = new Engine(engineId, engineName, engineType, enginePrice);
        }
        String type = sc.nextLine();
        String name = sc.nextLine();
        sc.close();

        int avg = findAvgEnginePriceByType(engines, type);
        if(avg > 0) System.out.println(avg);
        else System.out.println("There are no engine with given type");

        Engine[] engines2 = searchEngineByName(engines, name);
        if(engines2 != null){
            for(Engine e:engines2) System.out.println(e.getEngineId());
        }
        else System.out.println("There are no engine with the given name");
    }
    public static Engine[] searchEngineByName(Engine[] engines, String name){
        Engine[] fE = Arrays.stream(engines).filter(e -> e.getEngineName().equalsIgnoreCase(name)).toArray(Engine[]::new);
        if(fE.length == 0) return null;
        Arrays.sort(fE, (e1,e2) -> Integer.compare(e1.getEngineId(), e2.getEngineId()));
        return fE;
    }
    public static int findAvgEnginePriceByType(Engine[] engines, String type){
        Engine[] fE = Arrays.stream(engines).filter(e -> e.getEngineType().equalsIgnoreCase(type)).toArray(Engine[]::new);
        if(fE.length == 0) return 0;
        int sum=0;
        for(Engine e:fE) sum+=e.getEnginePrice();
        return sum/fE.length;
    }
}