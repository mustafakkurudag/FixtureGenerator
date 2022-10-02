package com.info;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashSet<String> teams = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        int teamNumber = r.nextInt((3) + 1) + 5;//8-5 = 3
        int weekNumber = teamNumber - 1;

        if (teamNumber % 2 != 0) {
            teams.add("Bay");
            weekNumber = teamNumber;
        }

        for (int i = 0; i < teamNumber; i++) {
            String team = scanner.nextLine();
            teams.add(team);
        }

        List<List<List<String>>> fixture = new ArrayList<>();
        List<List<String>> matches = new ArrayList<>();
        List<String> match = new ArrayList<>();

        int i = 0;
        while (i != weekNumber) {
            List<String> listFromSet = new ArrayList<>(teams);
            Collections.shuffle(listFromSet);
            for (String t : listFromSet) {
                match.add(t);
                if (match.size() == 2) {
                    matches.add(match);
                    match = new ArrayList<>();
                }
            }
            fixture.add(matches);
            matches = new ArrayList<>();
            i++;
        }

        System.out.println("İlk yarı maçları: ");
        for (int w = 0; w < weekNumber; w++) {
            System.out.println(w+1 + ". Hafta");
            for(List<String> matchesOfWeek : fixture.get(w)) {
                System.out.println(matchesOfWeek.toString());
            }

        }

        int x = 0;//ikinci yarı maçları için listeyi baştan gezmeyi sağlayacak sayaç
        System.out.println("İkinci yarı maçları: ");
        for (int w = weekNumber; w < weekNumber*2; w++) {
            System.out.println(w+1 + ". Hafta");
            for(List<String> matchesOfWeek : fixture.get(x++)) {
                Collections.reverse(matchesOfWeek);
                System.out.println(matchesOfWeek);
            }
        }
    }
}
