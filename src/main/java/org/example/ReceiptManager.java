package org.example;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    public static void  saveReceipt(Order order){
        try {
            //Create timestamp for filename
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = "receipts/" + timestamp + ".txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write(order.toString());
            writer.close();
            System.out.println("Receipt saved!");
        } catch (Exception e) {
            System.out.println("Error Saving with receipt");
        }
    }
}
