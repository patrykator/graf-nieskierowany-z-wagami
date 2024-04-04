import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Graf {
    private Map<Character, Map<Character, Integer>> wierzcholki;

    public Graf() {
        this.wierzcholki = new HashMap<>();
    }

    public void dodajWierzcholek(char wierzcholek) {
        if (!wierzcholki.containsKey(wierzcholek)) {
            wierzcholki.put(wierzcholek, new HashMap<>());
        }
    }

    public void dodajKrawedz(char wierzcholek1, char wierzcholek2, int waga) {
        dodajWierzcholek(wierzcholek1);
        dodajWierzcholek(wierzcholek2);
        wierzcholki.get(wierzcholek1).put(wierzcholek2, waga);
        wierzcholki.get(wierzcholek2).put(wierzcholek1, waga);
    }

    public Map<Character, Integer> getSasiadow(char wierzcholek) {
        Map<Character, Integer> sasiedzi = new HashMap<>();
        if (wierzcholki.containsKey(wierzcholek)) {
            sasiedzi = wierzcholki.get(wierzcholek);
        }
        return sasiedzi;
    }

    public Integer getPierwotnaWaga(char wierzcholek1, char wierzcholek2) {
        Integer waga = null;
        if (wierzcholki.containsKey(wierzcholek1) && wierzcholki.get(wierzcholek1).containsKey(wierzcholek2)) {
            waga = wierzcholki.get(wierzcholek1).get(wierzcholek2);
        }
        return waga;
    }

    // Dodaj metodę do pobierania wszystkich wierzchołków grafu
    public Map<Character, Map<Character, Integer>> getWierzcholki() {
        return wierzcholki;
    }
}

// Przykładowe użycie:
public class Main {
    public static void main(String[] args) {
        Graf graf = new Graf();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę krawędzi:");
        int liczbaKrawedzi = scanner.nextInt();

        System.out.println("Podaj krawędzie w formacie: wierzchołek1 wierzchołek2 waga");

        for (int i = 0; i < liczbaKrawedzi; i++) {
            char wierzcholek1 = scanner.next().charAt(0);
            char wierzcholek2 = scanner.next().charAt(0);
            int waga = scanner.nextInt();
            graf.dodajKrawedz(wierzcholek1, wierzcholek2, waga);
        }

        Map<Character, Map<Character, Integer>> wierzcholki = graf.getWierzcholki();
        System.out.println("Wierzchołki: " + wierzcholki.keySet());

        // Wyświetlenie sąsiadów dla każdego wierzchołka
        for (char wierzcholek : wierzcholki.keySet()) {
            System.out.println("Sąsiedzi wierzchołka '" + wierzcholek + "': " + graf.getSasiadow(wierzcholek));
        }
        

        scanner.close();
    }
}
