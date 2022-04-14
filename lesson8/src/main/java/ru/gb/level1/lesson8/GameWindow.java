package ru.gb.level1.lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 640;
    private GameMap gameMap;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");
        setResizable(false);

        JButton btnStart = new JButton("<html><body><b>START</b></body></html>");
        JButton btnExit = new JButton("EXIT");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnExit);
        add(buttonPanel, BorderLayout.SOUTH);

        gameMap = new GameMap();
        add(gameMap, BorderLayout.CENTER);

        setVisible(true);

        SettingsWindow settings = new SettingsWindow(this);
        btnStart.addActionListener(e -> settings.setVisible(true));
        btnExit.addActionListener(e -> System.exit(0));
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        gameMap.startNewGame(gameMode, fieldSize, winLength);
        System.out.printf("Mode: %d, Size: %d length: %d\n", gameMode, fieldSize, winLength);
    }
}
