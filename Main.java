import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    String[] words = {
      "apple", "grape", "peach", "melon", "mango", "lemon", "olive", "berry", 
      "guava", "prune", "pearl", "dates", "cumin", "cedar", "otter", "eagle",
      "moose", "zebra", "tiger", "snake", "shark", "whale", "horse", "panda",
      "sloth", "mouse", "flame", "stone", "cloud", "storm", "ocean", "earth",
      "plant", "lunar", "solar", "metal", "glass", "crane", "raven", "frost",
      "blaze", "cliff", "sword", "chain", "brick", "forge", "flare", "spine",
      "spark", "smoke", "candy", "sugar", "flour", "spoon", "knife", "bread",
      "honey", "sauce", "fruit", "meaty", "grain", "cream", "juice", "roast",
      "broil", "grill", "bloom", "pouch", "shrub", "mirth", "flock", "chasm",
      "gorge", "crash", "spore", "latch", "vivid", "quilt", "rider", "proud",
      "crisp", "dream", "flute", "brace", "steam", "glide", "patch", "plaza",
      "trout", "scarf", "pride", "vault", "scout", "twirl", "blend", "cloak", 
      "straw", "chill", "shore", "wheat", "swirl", "shady", "clash", "brave",
      "stake", "brisk", "chime", "slate", "quash", "stout", "grace", "sweep",
      "plume", "swoop", "blush", "fence", "house", "lamps", "roots", "fuzzy"
    };

    List<String> validWords = new ArrayList<>();
    for (String word : words) {
      if (word.length() == 5) {
        validWords.add(word);
      }
    }

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    boolean playAgain = true;

    while (playAgain) {
      String selectedWord = validWords.get(random.nextInt(validWords.size()));
      boolean guessedCorrectly = false;

      System.out.println("Welcome to Wordle! Guess the 5-letter word.");
      
      for (int attempt = 1; attempt <= 6; attempt++) {
        System.out.print("Attempt " + attempt + ": ");
        String guess = scanner.nextLine().toLowerCase();

        if (guess.length() != 5) {
          System.out.println("Please enter a 5-letter word.");
          attempt--;
          continue;
        }

        if (guess.equals(selectedWord)) {
          System.out.println("Congratulations! You guessed the word.");
          guessedCorrectly = true;
          break;
        } else {
          System.out.print("Feedback: ");
          for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == selectedWord.charAt(i)) {
              System.out.print(guess.charAt(i));
            } else if (selectedWord.contains(Character.toString(guess.charAt(i)))) {
              System.out.print("?");
            } else {
              System.out.print("_");
            }
          }
          System.out.println();
        }
      }

      if (!guessedCorrectly) {
        System.out.println("The correct word was: " + selectedWord);
      }

      System.out.print("Do you want to play again? (yes/no): ");
      String response = scanner.nextLine().toLowerCase();
      playAgain = response.equals("yes");
    }
    
    System.out.println("Thank you for playing!");
    scanner.close();
  }
}
