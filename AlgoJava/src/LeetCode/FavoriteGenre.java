package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenre {

    public static HashMap<String, List<String>> favoriteGenre(int numUsers, Map<String, List<String>> userListenedTo,
            int numGenres, Map<String, List<String>> bookGenres) {
        Map<String, String> bookToGenre = new HashMap<>();
        for (Map.Entry<String, List<String>> mp : bookGenres.entrySet()) {
            String genre = mp.getKey();
            List<String> books = mp.getValue();
            for (int i = 0; i < books.size(); ++i) {
                bookToGenre.put(books.get(i), genre);
            }
        }
        HashMap<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, List<String>> user : userListenedTo.entrySet()) {
            List<String> booksRead = user.getValue();
            Map<String, Integer> frequency = new HashMap<>();
            for (String book : booksRead) {
                if (frequency.containsKey(bookToGenre.get(book))) {
                    frequency.put(bookToGenre.get(book), frequency.get(bookToGenre.get(book)) + 1);
                } else {
                    frequency.put(bookToGenre.get(book), 1);
                }
            }
            int max = 0;
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
            System.out.println(max);
            List<String> favGenres = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                if (entry.getValue() == max) {
                    favGenres.add(entry.getKey());
                }
            }
            result.put(user.getKey(), favGenres);
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userListenedTo = new HashMap<>();
        userListenedTo.put("agrawal", Arrays.asList("madhushala", "beerrecipes", "eatdrinkrepeat"));
        userListenedTo.put("harshit", Arrays.asList("madhushala2", "beerrecipes2", "eatdrinkrepeat2"));

        Map<String, List<String>> genreMap = new HashMap<String, List<String>>();
        genreMap.put("daaru", Arrays.asList("madhushala", "madhushala2", "beerrecipes"));
        genreMap.put("recipes", Arrays.asList("beerrecipes2"));
        genreMap.put("motto", Arrays.asList("eatdrinkrepeat"));
        genreMap.put("goals", Arrays.asList("eatdrinkrepeat2"));

        Map<String, List<String>> favGenres = FavoriteGenre.favoriteGenre(2, userListenedTo, 4, genreMap);
        for (Map.Entry<String, List<String>> entry : favGenres.entrySet()) {
            System.out.print("User: " + entry.getKey() + " Favorite Genres: ");
            for (String item : entry.getValue()) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}
