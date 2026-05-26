package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    public static void  saveReceipt(Order order){
        try {
            //Create receipts folder object
            File folder = new File("receipts");
            //Create folder if missing
            if(!folder.exists()){
                folder.mkdir();
            }
            //Create timestamp for filename
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = "receipts/" + timestamp + ".txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write(order.getReceiptText());
            writer.close();
            System.out.println("Receipt saved!");
        } catch (Exception e) {
            System.out.println("Error Saving with receipt");
        }
    }
    //VIEW ALL RECEIPT
    public static void viewAllReceipts() {
        File folder = new File("receipts");
        // Check if folder exists
        if (!folder.exists()) {
            System.out.println("No receipts folder found.");
            return;
        }
        // Get all files
        File[] files = folder.listFiles();
        // Check if folder is empty
        if (files == null || files.length == 0) {
            System.out.println("No receipts found.");
            return;
        }
        // Loop through all receipt files
        for (File file : files) {
            System.out.println("\n================================");
            System.out.println("Receipt File: "+ file.getName());
            System.out.println("================================");
            try {
                // Read file content
                String content = Files.readString(file.toPath());
                // Print receipt
                System.out.println(content);
            }
            catch (IOException e) {
                System.out.println("Error reading receipt.");
            }
        }
    }
}
