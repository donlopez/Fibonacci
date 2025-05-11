package cop2805;

import java.io.*;
import java.net.*;

public class FibonacciServer {
    private static boolean shutdown = false;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5050)) {
            System.out.println("Server is listening on port 5050");

            while (!shutdown) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class ServerThread extends Thread {
        private Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
                String number = input.readLine();
                if (number.equalsIgnoreCase("shutdown")) {
                    output.println("Server is shutting down.");
                    shutdown = true;
                    socket.close();
                    // Delay to ensure client receives the shutdown message
                    Thread.sleep(1000);
                    System.exit(0);
                } else {
                    try {
                        int n = Integer.parseInt(number);
                        int fibonacciValue = fibonacci(n);
                        output.println(fibonacciValue);
                    } catch (NumberFormatException ex) {
                        output.println("Invalid input. Please enter a positive integer.");
                    }
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        private int fibonacci(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            int v1 = 0, v2 = 1, v3 = 0;
            for (int i = 2; i <= n; i++) {
                v3 = v1 + v2;
                v1 = v2;
                v2 = v3;
            }
            return v3;
        }
    }
}