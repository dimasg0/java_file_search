package com.company;
import java.io. *;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main extends WorkToFile{
    public static boolean isCountine = true;

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String files = "";
        String Writefile = "";
        Scanner scanner = new Scanner(System.in);
        files = scanner.nextLine();
        Writefile = scanner.nextLine();

        //String filename = "D:\\sensor_f.txt";
        BufferedReader reader = Files.newBufferedReader(Paths.get(files));
        List<String> list = new ArrayList<>();

            scanner = new Scanner(reader);
            int i = 1;

            while (scanner.hasNextLine()){
                list.add(scanner.nextLine());
                i++;
            }

            String[] directory_array = list.toArray(new String[0]);
            try {

                System.out.println("Получено путей: " + (i-1));
                String finalWritefile = Writefile;
                Thread myThready = new Thread(new Runnable()
                {
                    String text = "";

                    public void run()
                    {
                        for(int i = 0; i < directory_array.length; i++) {
                            text = "№" + (i + 1) +  ";" + countFile(directory_array[i]) +  directory_array[i] + "\n";
                            System.out.print(text);

                            PrintWriter writer2 = null;
                            try {
                                writer2 = new PrintWriter((new FileWriter(finalWritefile, true)));
                                writer2.println(text);
                                writer2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });

                myThready.start();

                reader.close();
            }catch (Exception e){
                System.out.println("Error");
            }

    }
}

