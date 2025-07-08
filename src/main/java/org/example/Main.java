package org.example;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.apache.http.HttpException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws HttpException, IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Client client = new Client();
Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a question for the ai");
        String query = scanner.nextLine();
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.0-flash-001",
                        query,
                        null
                );

        System.out.println("Movie Description: " + response.text());
    }
}

