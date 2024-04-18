import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);
    double totalPrice = 0.0;
    int numOf1 = 0;
    int numOf2 = 0;
    int numOf3 = 0;

    System.out.println("Please choose a product. (input -1 to stop)");
    System.out.println("1. Bathwater $4.99");
    System.out.println("2. Airpods $249.99");
    System.out.println("3. Minecraft: Java Edition $29.99");

    int userInput = scnr.nextInt();

    while (userInput != -1) {

        if (userInput == 1) {
          totalPrice += 4.99;
          numOf1++;
          //System.out.println("1");
        } else if (userInput == 2) {
          totalPrice += 249.99;
          numOf2++;
          //System.out.println("2");
        } else if (userInput == 3) {
          totalPrice += 29.99;
          numOf3++;
          //System.out.println("3");
        } else {
          System.out.println("Please input 1, 2, or 3");
        }

        userInput = scnr.nextInt();

    }
    System.out.println("Cart:");
    if (numOf1 > 0)
        System.out.println(numOf1 + "x Bathwater");
    if (numOf2 > 0)
        System.out.println(numOf2 + "x Airpods");
    if (numOf3 > 0)
        System.out.println(numOf3 + "x Minecraft: Java Edition");
    if (numOf1 == 0 && numOf2 == 0 && numOf3 == 0)
        System.out.println("Empty");

    System.out.println("Do you have a coupon code?(Y/N)");

    System.out.print("Total: $" + totalPrice + "\uD83D\uDE33");
  }
}
