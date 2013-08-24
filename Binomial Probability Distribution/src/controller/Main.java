package controller;

import view.InputPanel;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setPanel(new InputPanel());
    }
}
