import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Kernel {
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в JFOS!");
        System.out.println("Введите 'help' для списка доступных команд.");

        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.print("jfsh> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "help":
                    System.out.println("Доступные команды:");
                    System.out.println("  help      - Показать список команд");
                    System.out.println("  gui       - Запустить GUI интерфейс");
                    System.out.println("  shutdown  - Выключить систему");
                    System.out.println("  clear     - Очистить экран");
                    System.out.println("  about     - Информация о системе");
                    break;
                case "gui":
                    openGui();
                    break;
                case "shutdown":
                    System.out.println("Выключение JFOS...");
                    running = false;
                    break;
                case "clear":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                case "about":
                    System.out.println("JFOS — Java File Operating System.");
                    System.out.println("Разработчик: ты.");
                    break;
                default:
                    System.out.println("Неизвестная команда. Введите 'help' для списка.");
            }
        }

        scanner.close();
    }

    public static void openGui() {
        JFrame frame = new JFrame("JFOS GUI");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton exitButton = new JButton("Выйти из GUI");
        JButton shutdownButton = new JButton("Выключить систему");

        exitButton.addActionListener(e -> frame.dispose());

        shutdownButton.addActionListener(e -> {
            System.out.println("Система выключена через GUI.");
            running = false;
            frame.dispose();
        });

        panel.add(exitButton);
        panel.add(shutdownButton);

        frame.add(panel);
        frame.setVisible(true);
    }
          }
