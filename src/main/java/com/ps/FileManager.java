package com.ps;

import java.io.*;

public class FileManager {
    public static Zoo readZoo() {
        // read a zoo from a file
        Zoo zoo = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("animals.csv"))) {
            // Read the first line for zoo information
            String zooInfo = reader.readLine();
            if (zooInfo != null) {
                String[] zooDetails = zooInfo.split(",");
                String zooName = zooDetails[0];
                String zooAddress = zooDetails[1];
                String zooPhone = zooDetails[2];
                zoo = new Zoo(zooName, zooAddress, zooPhone);
            }
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] animalData = line.split(",");
                    String name = animalData[0];
                    String species = animalData[1];
                    int age = Integer.parseInt(animalData[2]);
                    String habitatStructure = animalData[3];
                    boolean hasCleanHabitat = Boolean.parseBoolean(animalData[4]);
                    String dateLastCleaned = animalData[5];
                    if ("Lion".equalsIgnoreCase(species)) {
                        boolean isEasilyFrightened = Boolean.parseBoolean(animalData[6]);
                        int prideSize = Integer.parseInt(animalData[7]);
                        Lion lion = new Lion(name, age, habitatStructure, dateLastCleaned, isEasilyFrightened, prideSize);
                        lion.setHasCleanHabitat(hasCleanHabitat);
                        zoo.addAnimal(lion);
                    } else if ("Axolotl".equalsIgnoreCase(species)) {
                        boolean isCurrentlyHealing = Boolean.parseBoolean(animalData[6]);
                        Axolotl axolotl = new Axolotl(name, age, dateLastCleaned, isCurrentlyHealing);
                        axolotl.setHasCleanHabitat(hasCleanHabitat);
                        zoo.addAnimal(axolotl);
                    }
                }
            } catch(IOException e){
                e.printStackTrace();
                System.out.println("Error reading the zoo data from the file.");
            }

            return zoo != null ? zoo : new Zoo("", "", "");
        }


    public static void writeZoo(Zoo zoo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("zoo.csv"))) {
            writer.write(zoo.getName() + "," + zoo.getAddress() + "," + zoo.getPhone());
            writer.newLine();

            for (Animal animal : zoo.getAllAnimals()) {
                String line = animal.getName() + "," + animal.getSpecies() + "," + animal.getAge() + "," +
                        animal.getHabitatStructure() + "," + animal.hasCleanHabitat() + "," + animal.getDateLastCleaned();

                if (animal instanceof Lion) {
                    Lion lion = (Lion) animal;
                    line += "," + lion.isEasilyFrightened() + "," + lion.getPrideSize();
                } else if (animal instanceof Axolotl) {
                    Axolotl axolotl = (Axolotl) animal;
                    line += "," + axolotl.isCurrentlyHealing();
                }

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing the zoo data to the file.");
        }
    }
}