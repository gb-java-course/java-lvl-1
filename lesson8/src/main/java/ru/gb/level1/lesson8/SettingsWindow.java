package ru.gb.level1.lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 300;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size: ";
    private static final String WIN_LENGTH_PREFIX = "Win length: ";

    private JRadioButton humanVsAi;
    private JRadioButton humanVsHuman;
    private JSlider winLengthSlider;
    private JSlider fieldSizeSlider;
    private GameWindow gameWindow;

    public SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("Settings");
        setLayout(new GridLayout(10, 1));
        JButton buttonStart = new JButton("START");
        buttonStart.addActionListener(e -> submitSettings(gameWindow));
        addFieldSize();
        addGameMode();
        add(buttonStart);
    }

    private void addFieldSize() {
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        fieldSizeSlider = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        winLengthSlider = new JSlider(MIN_WIN_LENGTH, MAX_FIELD_SIZE, MIN_WIN_LENGTH);

        fieldSizeSlider.addChangeListener(e -> {
            int current = fieldSizeSlider.getValue();
            labelFieldSize.setText(FIELD_SIZE_PREFIX + current);
            winLengthSlider.setMaximum(current);
        });

        winLengthSlider.addChangeListener(e -> labelWinLength.setText(WIN_LENGTH_PREFIX + winLengthSlider.getValue()));

        add(new JLabel("Choose field size"));
        add(labelFieldSize);
        add(fieldSizeSlider);
        add(new JLabel("Choose win length"));
        add(labelWinLength);
        add(winLengthSlider);
    }

    private void addGameMode() {
        add(new JLabel("Choose game mode"));
        humanVsAi = new JRadioButton("Human vs AI", true);
        humanVsHuman = new JRadioButton("Human vs human");
        ButtonGroup group = new ButtonGroup();
        group.add(humanVsAi);
        group.add(humanVsHuman);
        add(humanVsAi);
        add(humanVsHuman);
    }

    private void submitSettings(GameWindow gameWindow) {
        int gameMode;
        if (humanVsAi.isSelected()) {
            gameMode = GameMap.MODE_VS_AI;
        } else {
            gameMode = GameMap.MODE_VS_HUMAN;
        }
        int fieldSize = fieldSizeSlider.getValue();
        int winLength = winLengthSlider.getValue();
        gameWindow.startGame(gameMode, fieldSize, winLength);
        setVisible(false);
    }
}
