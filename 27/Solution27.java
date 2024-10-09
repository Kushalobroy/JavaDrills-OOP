import java.util.*;

class Associate {
    private int id;
    private String name;
    private String technology;
    private int experienceInYears;

    public Associate(int id, String name, String technology, int experienceInYears) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.experienceInYears = experienceInYears;
    }

    public int getId() {
        return id;
    }

    public String getTechnology() {
        return technology;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }
}

public class Solution27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Associate[] associates = new Associate[4];

        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline character after int input
            String name = sc.nextLine();
            String technology = sc.nextLine();
            int experienceInYears = sc.nextInt();
            sc.nextLine(); // Consume the newline character after int input
            associates[i] = new Associate(id, name, technology, experienceInYears);
        }

        String tech = sc.nextLine(); // Read the technology filter

        Associate[] filteredAssociates = associatesForGivenTechnology(associates, tech);

        if (filteredAssociates.length > 0) {
            for (Associate a : filteredAssociates) {
                System.out.println(a.getId());
            }
        } else {
            System.out.println("No such Associates with given attributes !");
        }

        sc.close();
    }

    public static Associate[] associatesForGivenTechnology(Associate[] associates, String tech) {
        return Arrays.stream(associates)
                .filter(a -> a.getTechnology().equalsIgnoreCase(tech) && a.getExperienceInYears() % 5 == 0)
                .toArray(Associate[]::new);
    }
}
