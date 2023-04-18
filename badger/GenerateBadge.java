import java.util.Scanner;

// The class GenerateBadge generates a shields.io URL link of a badge. The details the user enter will determine the
// name, logo & the color of the badge.
public class GenerateBadge {
    /** get_details() is a method that takes in user input & returns an array containing the details the user
     * inputted. */
    public static String[] get_details() {
        String entity_name;
        String hex_color_code;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Entity Name:");
        entity_name = scan.nextLine();
        entity_name = entity_name.replace(" ", "&20");

        boolean invalid;
        do {
            invalid = false;
            System.out.print("Enter the Hex Color Code for your Badge:");
            hex_color_code = scan.nextLine();
            System.out.println("+--------------------------------------------+");
            hex_color_code = hex_color_code.replace("#", "");

            for (int i = 0; i < hex_color_code.length(); i++) {
                char current_char = hex_color_code.charAt(i);
                if (!Character.isLetterOrDigit(current_char)) {
                    System.out.println("The details you have entered were invalid. Please try again.");
                    invalid = true;
                    break;
                }
            }
        } while (invalid);

        String[] details = new String[2];
        details[0] = entity_name;
        details[1] = hex_color_code;

        return details;
    }

    /** main() prints the information required to input the details of the entity they wish to create a badge of.
     get_details() is called to take in the details from the user with the final URL being printed to the terminal. */
    public static void main(String[] args) {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("This program generates a URL for your own personal badges.");
        System.out.println("Look up the details of the entity you wish to create a badge for using this link:");
        System.out.println("https://simpleicons.org/");
        System.out.println("+-------------------------------------------------------------------------------+");

        String[] details = get_details();

        System.out.println("Your URL is:");
        System.out.println("https://img.shields.io/badge/-" + details[0] + "-" + details[1] + "?logo=" + details[0] + "&logoColor=white&style=flat");
        System.out.println("+-------------------------------------------------------------------------------+");
    }
}
