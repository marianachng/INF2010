package tp2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public final class Interview {

    /** TODO
     * This function returns if the two texts are similar based on if they have a similar entropy of the HashMap
     * @return boolean based on if the entropy is similar
     */
    public static Double compareEntropies(String filename1, String filename2) throws IOException {
        Double firstMapEntropy = calculateEntropy(getFrequencyHashTable(readFile(filename1)));
        Double secondMapEntropy = calculateEntropy(getFrequencyHashTable(readFile(filename2)));
        return Math.abs(firstMapEntropy - secondMapEntropy);
    }

    /** TODO
     * This function returns the difference in frequencies of two HashMaps which corresponds
     * to the sum of the differences of frequencies for each letter.
     * @return the difference in frequencies of two HashMaps
     */
    public static Integer compareFrequencies(String filename1, String filename2) throws IOException{
        HashMap<Character, Integer> firstTextMap = getFrequencyHashTable(readFile(filename1));
        HashMap<Character, Integer> secondTextMap = getFrequencyHashTable(readFile(filename2));
        Integer frequencyDiffSum = 0;

        ArrayList<Character> allKeys = new ArrayList<>();
        allKeys.addAll(firstTextMap.keySet());
        for(Character key : secondTextMap.keySet()){
            if(!allKeys.contains(key)){
                allKeys.add(key);
            }
        }

        for(Character key : allKeys){
            Integer frequencyFirstMap = firstTextMap.get(key);
            Integer frequencySecondMap = secondTextMap.get(key);
            if(frequencyFirstMap != null && frequencySecondMap != null){
                frequencyDiffSum += Math.abs(frequencyFirstMap - frequencySecondMap);
            }else if(frequencyFirstMap == null){
                frequencyDiffSum += frequencySecondMap;
            }else if (frequencySecondMap == null){
                frequencyDiffSum += frequencyFirstMap;
            }
        }
        return frequencyDiffSum;
    }

    /** TODO
     * @return This function returns the entropy of the HashMap
     */
    public static Double calculateEntropy(HashMap<Character, Integer> map){
        Double totalNumberCharacter = 0.0;
        for(Integer i : map.values()){
            totalNumberCharacter += i;
        }
        Double sum = 0.0;
        for(Integer value : map.values()){
            Double p = value / totalNumberCharacter;
            sum += p * (Math.log10(1 / p) / Math.log10(2.0));
        }
        return sum;
    }

    /**
     * This function reads a text file {filenamme} and returns the appended string of all lines
     * in the text file
     */
    public static String readFile(String filename) throws IOException {
        String fileContent = "";
        try {
            File textFile = new File(filename);
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNextLine()){
                fileContent += scanner.nextLine();
            }
        }catch (Exception e){
            System.out.println("Error while parsing the text file");
            throw new IOException(); //to stop the program from continuing;
        }
        return fileContent;
    }

    /** TODO
     * This function takes a string as a parameter and creates and returns a HashTable
     * of character frequencies
     */
    public static HashMap<Character, Integer> getFrequencyHashTable(String text) {
        HashMap<Character, Integer> letterMap = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            if(letterMap.containsKey(text.charAt(i)) || !isAlphabetic(text.charAt(i))){
                continue;
            }
            int letterCount = 0;
            Character currentChar = text.charAt(i);
            for (int j = 0; j < text.length(); j++){
                if(text.charAt(j) == currentChar){
                    letterCount++;
                }
            }
            letterMap.put(currentChar, letterCount);
        }
        return letterMap;
    }

    /** TODO
     * This function takes a character as a parameter and returns if it is a letter in the alphabet
     */
    public static Boolean isAlphabetic(Character c){
        return Character.isLetter(c);
    }
}
