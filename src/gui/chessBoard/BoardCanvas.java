package gui.chessBoard;


import core.Move;
import core.Moves;
import gui.Colors;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;


public class BoardCanvas extends Canvas {

    public CanvasSettings s;
    char [] board;

    public BoardCanvas(int size_factor, char[] board, Colors COLORS) {
        s = new CanvasSettings(COLORS); //todo refactor to MainWindow
        this.board = board;
        adjustSize(size_factor);
    }

    public void adjustSize(int size_factor) {
        s.adjustSize(size_factor);
        setSize(s.margin, s.margin);
    }

    public void setBoard(char[] board) {
        this.board = board;
    }

    public void fontRoulette() {
        s.nextFont();
        adjustSize(s.size_factor);
        repaint();
    }

    public void repaint() {
        paint(getGraphics());
    }

    public void refresh(boolean showMoves, boolean showLastMove, Moves moves, Move move) {
        Graphics g = getGraphics();
        Painter.paintBoard(g, s);
        if (showMoves) Painter.paintHighlights(g,s,moves, true);
        if (showLastMove) Painter.paintLastMove(g,s,move);
        Painter.paintPieces(g, s, board);
        Painter.paintFilesAndRanks(g, s);
    }

    public void paintDiffus() {
        paint(getGraphics());
        Graphics g = getGraphics();
        g.setColor(s.COLORS.LIGHT_COLOR);
        g.fillRect(0, 0, s.margin, s.margin);
    }

    @Override
    public void paint(Graphics g) {
        Painter.paintBoard(g, s);
        Painter.paintPieces(g, s, board);
        Painter.paintFilesAndRanks(g, s);
    }
}