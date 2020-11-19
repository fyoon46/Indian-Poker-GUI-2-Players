package test;

import java.util.Scanner;

import network.*;

import static java.lang.System.exit;

/*
public class noGUI_Server {
    private static final String DEFAULT_SERVER_ADDR = "localhost";
    private static final int DEFAULT_PORT = 6777;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please choose a role you want to be: server or client.");
        System.out.println("server PORT - The port to listen to; \"6777\" is default port.");
        System.out.println("client SERVER_ADDRESS PORT - The server address and port to connect to; \"localhost:6777\" is default address-prt combination.");
        System.out.println("Make sure run the server first and then run client to connect to it.");
        System.out.println("> ---------- ");

        String line = in.nextLine();
        String[] cmd = line.split("\\s+");

        // Server selected
        if(cmd[0].contains("s")) {
            int port = DEFAULT_PORT;
            if(cmd.length > 1) {
                try {
                    port = Integer.parseInt(cmd[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: port is not a number!");
                    in.close();
                    return;
                }
            }

            ServerManager _svrMgr = new ServerManager(port);
            new Thread(_svrMgr).start();
        }
        // Client selected
        else if(cmd[0].contains("c")) {
            String svrAddr = DEFAULT_SERVER_ADDR;
            int port = DEFAULT_PORT;
            if (cmd.length > 2) {
                try {
                    svrAddr = cmd[1];
                    port = Integer.parseInt(cmd[2]);
                } catch(NumberFormatException e) {
                    System.out.println("Error: port is not a number!");
                    in.close();
                    return;
                }
            }

            ClientManager _cltMgr = new ClientManager(svrAddr, port);
            new Thread(_cltMgr).start();

            _cltMgr.startClient();
        }
        // Show help
        else {
            showHelp();
            in.close();
            return;
        }
    }

    // Show help when the user's input is incorrect
    public static void showHelp() {
        System.out.println("Restart and select role as server or client.");
        exit(0);
    }
}
*/