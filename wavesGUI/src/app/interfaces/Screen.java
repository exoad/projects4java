package app.interfaces;

/**
 * Main Window and Display Module
 * 
 * <p>
 * MIT License
 * 
 * Copyright (c) 2022 Jack Meng
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy
 * of this software and associated documentation files (the "Software"),
 * to deal
 * in the Software without restriction, including without limitation the
 * rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
 * SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE
 * SOFTWARE.
 * </p>
 * 
 * @author Jack Meng
 */

import app.AppInterface;
import app.math.Algo;
import app.struct.Pair;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.geom.QuadCurve2D;

public class Screen extends JPanel implements AppInterface, ChangeListener {
  private JFrame frame;
  private JSlider frequencySlider;

  public Screen() {
    setPreferredSize(new Dimension(600, 600));
    setLayout(new BorderLayout());
    frequencySlider = new JSlider();
    frequencySlider.setMinimum(1);
    frequencySlider.setMaximum(1000);
    frequencySlider.addChangeListener(this);

    add(frequencySlider, BorderLayout.SOUTH);
    frame = new JFrame("Waves");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setLocationRelativeTo(null);
    frame.add(this);

  }

  
  /** 
   * @param g
   */
  @Override
  public void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new java.awt.BasicStroke(0.5f));
    g2.setColor(Color.BLUE);
    ArrayList<Pair<Integer, Integer>> points = Algo.generateSinWave(new Dimension(getWidth(), 50), frequencySlider.getValue() / 1000.0);
    for (int i = 0; i < points.size() - 1; i++) {
      QuadCurve2D curve = new QuadCurve2D.Double(points.get(i).first, points.get(i).second,
          (points.get(i).first + points.get(i + 1).first) / 2,
          (points.get(i).second + points.get(i + 1).second) / 2,
          points.get(i + 1).first, points.get(i + 1).second);
      g2.draw(curve);
    }
    g2.setColor(Color.RED);
    points = Algo.generateCosWave(new Dimension(getWidth(), 50), frequencySlider.getValue() / 10000.0);
    for(int i = 0; i < points.size() - 1; i++) {
      QuadCurve2D curve = new QuadCurve2D.Double(points.get(i).first, points.get(i).second,
          (points.get(i).first + points.get(i + 1).first) / 2,
          (points.get(i).second + points.get(i + 1).second) / 2,
          points.get(i + 1).first, points.get(i + 1).second);
      g2.draw(curve);
    }

    g2.setColor(Color.GREEN);
    points = Algo.generateLogWave(new Dimension(getWidth(), 50), frequencySlider.getValue() / 10000.0);
    for(int i = 0; i < points.size() - 1; i++) {
      QuadCurve2D curve = new QuadCurve2D.Double(points.get(i).first, points.get(i).second,
          (points.get(i).first + points.get(i + 1).first) / 2,
          (points.get(i).second + points.get(i + 1).second) / 2,
          points.get(i + 1).first, points.get(i + 1).second);
      g2.draw(curve);
    }

    g2.setColor(Color.MAGENTA);
    points = Algo.generateExpWave(new Dimension(getWidth(), 50), frequencySlider.getValue() / 10000.0);
    for (int i = 0; i < points.size() - 1; i++) {
      QuadCurve2D curve = new QuadCurve2D.Double(points.get(i).first, points.get(i).second,
          (points.get(i).first + points.get(i + 1).first) / 2,
          (points.get(i).second + points.get(i + 1).second) / 2,
          points.get(i + 1).first, points.get(i + 1).second);
      g2.draw(curve);
    }

  }

  @Override
  public void run() {
    frame.pack();
    frame.setVisible(true);
  }

  @Override
  public void stop() {

  }

  @Override
  public void refresh() {

  }

  
  /** 
   * @param e
   */
  @Override
  public void stateChanged(ChangeEvent e) {
    repaint();
    
  }

}
