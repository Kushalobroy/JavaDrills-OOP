import java.util.*;
class RRT{
    private int ticketNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;
    public RRT(int ticketNo,String raisedBy, String assignedTo, int priority, String project){
        this.ticketNo = ticketNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.project = project;
    }
    public int getTicketNo(){return ticketNo;}
    public String getRaisedBy(){return raisedBy;}
    public String getAssignedTo(){return assignedTo;}
    public int getPriority(){return priority;}
    public String getProject(){return project;}
}
public class Solution18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RRT[] rrts = new RRT[4];
        for(int i=0;i<4;i++){
            int ticketNo = sc.nextInt();
            sc.nextLine();
            String raisedBy = sc.nextLine();
            String assignedTo = sc.nextLine();
            int priority = sc.nextInt();
            sc.nextLine();
            String project = sc.nextLine();
            rrts[i] = new RRT(ticketNo, raisedBy, assignedTo, priority, project);
        }
        String pr = sc.nextLine();
        RRT[] rrts2 = getHighestPriorityTicket(rrts, pr);
        if(rrts2 !=null){
            for(RRT r:rrts2){
                System.out.println(r.getTicketNo()+" "+r.getRaisedBy()+" "+r.getAssignedTo());
            }
        }
        else System.out.println("No such Ticket");
        sc.close();
    }
    public static RRT[] getHighestPriorityTicket(RRT[] rrts, String pr){
        Arrays.sort(rrts, (r1, r2) -> Integer.compare(r1.getPriority(), r2.getPriority()));
        int hS = rrts[0].getPriority();
        RRT[] fR = Arrays.stream(rrts).filter(r -> r.getPriority()==hS && r.getProject().equalsIgnoreCase(pr)).toArray(RRT[]::new);
        if(fR == null) return null;
        return fR;
    }
}
