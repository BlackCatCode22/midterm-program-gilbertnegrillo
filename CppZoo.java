// References:
// JavaMidtermSpr23.java approved solution file and video
// https://www.youtube.com/watch?v=-Aud0cDh-J8

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.Period;

public class CppZoo {
    // Calculate birthday
    static String genBirthDay(int yearsOld, String birthSeason) {

        int year = 2023 - yearsOld;
        String monthDay;
        String newDate;

        if (birthSeason.equals("spring,")) {
            monthDay = "03-21";
        } else if (birthSeason.equals("summer,")) {
            monthDay = "06-21";
        } else if (birthSeason.equals("fall,")) {
            monthDay = "09-21";
        } else if (birthSeason.equals("winter,")) {
            monthDay = "12-21";
        } else {
            monthDay = "01-01";
        }
        newDate = Integer.toString(year) + "-" + monthDay;

        return newDate;
    }

    // Generate unique ID for each animal
    static String genUanimalID(String speciesName, int numOfSpecies) {

        String uniqueID;

        if (speciesName.equals("hyena")) {
            uniqueID = "Hy0" + Integer.toString(numOfSpecies);
        } else if (speciesName.equals("lion")){
            uniqueID = "Li0" + Integer.toString(numOfSpecies);
        } else if (speciesName.equals("tiger")){
            uniqueID = "Ti0" + Integer.toString(numOfSpecies);
        } else if (speciesName.equals("bear")){
            uniqueID = "Be0" + Integer.toString(numOfSpecies);
        } else {
            uniqueID = "error";
        }
        return uniqueID;
    }

    public static void main(String[] args) {
        System.out.println(" \n Welcome to Gilbert Negrillo's Digital Zoo Program \n");

        int numOfHyenas = 0;
        int numOfLions = 0;
        int numOfTigers = 0;
        int numOfBears = 0;

        String hyenas[] = new String[4];
        hyenas[0] = "The first hyena";
        System.out.println("hyenas[0] is: " + hyenas[0]);
        String lions[] = new String[4];
        lions[0] = "The first lion";
        System.out.println("lions[0] is: " + lions[0]);
        String tigers[] = new String[4];
        tigers[0] = "The first tiger";
        System.out.println("tigers[0] is: " + tigers[0]);
        String bears[] = new String[4];
        bears[0] = "The first bear";
        System.out.println("bears[0] is: " + bears[0]);

        String arrivingAnimals[] = new String[16];
        String filePath = "C:/Users/bertn/IdeaProjects/midterm-program-gilbertnegrillo/arrivingAnimals.txt";
        String nextLine = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            System.out.println("\n The arrivingAnimals.txt  \n");
            int lineNum = 0;
            while ((nextLine = br.readLine()) !=null) {
                arrivingAnimals[lineNum] = nextLine;
                lineNum++;
                System.out.println(nextLine);
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File error occurred");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n The array... \n");
        for (String line:arrivingAnimals) {
            System.out.println(line);
        }

        int position = 0;
        int years = 0;
        String season;
        String sex;
        String species;
        String birthdate;
        String color;
        String origin;
        String weight;
        String name;
        String uniqueID = "xyz";
        String arrived;

        String hyenaNames[] = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou", "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
        String lionNames[] = {"Scar", "Mufasa", "Simba", "Kiara", "King", "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
        String tigerNames[] = {"Tony", "Tigger", "Amber", "Cosimia", "Cuddles", "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};
        String bearNames[] = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle", "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};

        for (int i = 0; i < 16; i++) {
            String splitStr[] = arrivingAnimals[i].split(" ",0);
            for (String s : splitStr) {
                System.out.println(s);
            }

            birthdate = genBirthDay(Integer.parseInt(splitStr[0]), splitStr[7]);
            System.out.println("birthdate is: " + birthdate);

            sex = splitStr[3];
            System.out.println("sex is: " + sex);

            species = splitStr[4];
            System.out.println("species is: " + species);

            position = species.indexOf(",");
            System.out.println("position of comma is: " + position);

            species = species.substring(0, position);
            System.out.println("species is now: " + species);

            switch (species) {
                case "hyena":
                    numOfHyenas++;
                    uniqueID = genUanimalID(species, numOfHyenas);
                    break;
                case "lion":
                    numOfLions++;
                    uniqueID = genUanimalID(species, numOfLions);
                    break;
                case "tiger":
                    numOfTigers++;
                    uniqueID = genUanimalID(species, numOfTigers);
                    break;
                case "bear":
                    numOfBears++;
                    uniqueID = genUanimalID(species, numOfBears);
                    break;
                default:
                    System.out.println("An error occurred organizing the number of animals");
                }

            System.out.println("numOfHyenas = " + numOfHyenas);
            System.out.println("numOfLions = " + numOfLions);
            System.out.println("numOfTigers = " + numOfTigers);
            System.out.println("numOfBears = " + numOfBears);

            System.out.println("UniqueID = " + uniqueID);

            String splitStrComma[] = arrivingAnimals[i].split(",", 0);
            for (String s : splitStrComma) {
                System.out.println(s);
            }

            color = splitStrComma[2];
            System.out.println("color = " + color);

            weight = splitStrComma[3];
            System.out.println("weight = " + weight);

            origin = splitStrComma[4] + "," + splitStrComma[5];
            System.out.println("origin = " + origin);

            String uniqueIDPrefix = uniqueID.substring(0, 2);
            System.out.println("UniqueIDPrefix = " + uniqueIDPrefix);

            String uniqueIDSuffix = uniqueID.substring(2);
            System.out.println("UniqueIDSuffix = " + uniqueIDSuffix);

            int suffixAsInt = Integer.parseInt(uniqueIDSuffix);
            System.out.println("suffixAsInt = " + suffixAsInt);

            switch (uniqueIDPrefix) {
                case "Hy":
                    name = hyenaNames[suffixAsInt];
                    break;
                case "Li":
                    name = lionNames[suffixAsInt];
                    break;
                case "Ti":
                    name = tigerNames[suffixAsInt];
                    break;
                case "Be":
                    name = bearNames[suffixAsInt];
                    break;
                default:
                    name = "Error occurred";
                    break;
            }

            System.out.println("name is: " + name);

            String arrivalDate;
            LocalDate curDate = LocalDate.now();
            arrivalDate = curDate.toString();
            System.out.println("arrivalDate: " + arrivalDate);
            LocalDate bDate = LocalDate.parse(birthdate);

            int animalAge = Period.between(bDate, curDate).getYears();
            System.out.println(" Age is: " + animalAge);

            String outputLine;
            outputLine = uniqueID + "; " + name + "; " + animalAge + " years old" + "; " + "birth date " + birthdate + "; " + color + "; " + sex + "; " + weight + "; " + origin + "; " + " arrived " + arrivalDate;
            System.out.println("\n\n" + outputLine + "\n\n");

            if (species.equals("hyena")) {
                hyenas[numOfHyenas-1] = outputLine;
            } else if (species.equals("lion")) {
                lions[numOfLions-1] = outputLine;
            } else if (species.equals("tiger")) {
                tigers[numOfTigers-1] = outputLine;
            } else if (species.equals("bear")) {
                bears[numOfBears-1] = outputLine;
            }
        }

        System.out.println("\nMidterm Program Output; by Gilbert Negrillo, Spring 2023, Fresno CA");

        System.out.println("\nHyena Habitat\n");
        for (int i = 0; i < 4; i++) {
            System.out.println(hyenas[i]);
        }
        System.out.println("\nLion Habitat\n");
        for (int i = 0; i < 4; i++) {
            System.out.println(lions[i]);
        }
        System.out.println("\nTiger Habitat\n");
        for (int i = 0; i < 4; i++) {
            System.out.println(tigers[i]);
        }
        System.out.println("\nBear Habitat\n");
        for (int i = 0; i < 4; i++) {
            System.out.println(bears[i]);
        }

        try {
            FileWriter file = new FileWriter("C:/Users/bertn/IdeaProjects/midterm-program-gilbertnegrillo/JavaOutputFile.txt");
            BufferedWriter output = new BufferedWriter(file);

            output.write("Midterm Program Output; by Gilbert Negrillo; Spring 2023; Fresno CA\n\n");

            output.write("Hyena Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(hyenas[i]+"\n");
            }

            output.write("\nLion Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(lions[i]+"\n");
            }

            output.write("\nTiger Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(tigers[i]+"\n");
            }

            output.write("\nBear Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(bears[i]+"\n");
            }

            output.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
