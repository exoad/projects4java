package app.math;

/**
 * Algorithm Manager
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

import java.util.ArrayList;

import app.struct.Pair;

public abstract class Algo {
  
  /** 
   * @param size
   * @param frequency
   * @return ArrayList<Pair<Integer, Integer>>
   */
  public static ArrayList<Pair<Integer, Integer>> generateSinWave(java.awt.Dimension size, double frequency) {
    ArrayList<Pair<Integer, Integer>> points = new ArrayList<>();
    for (int i = 0; i < size.width; i++) {
      points.add(new Pair<>(i, (int) (size.height / 2 + Math.sin(i * (frequency % 10)) * size.height / 2)));
    }
    return points;
  }

  
  /** 
   * @param size
   * @param frequency
   * @return ArrayList<Pair<Integer, Integer>>
   */
  public static ArrayList<Pair<Integer, Integer>> generateCosWave(java.awt.Dimension size, double frequency) {
    ArrayList<Pair<Integer, Integer>> points = new ArrayList<>();
    for (int i = 0; i < size.width; i++) {
      points.add(new Pair<>(i, (int) (size.height / 2 + Math.cos(i * (frequency % 10)) * size.height / 2)));
    }
    return points;
  }

  
  /** 
   * @param size
   * @param frequency
   * @return ArrayList<Pair<Integer, Integer>>
   */
  public static ArrayList<Pair<Integer, Integer>> generateLogWave(java.awt.Dimension size, double frequency) {
    ArrayList<Pair<Integer, Integer>> points = new ArrayList<>();
    for (int i = 0; i < size.width; i++) {
      points.add(new Pair<>(i, (int) (size.height / 2 + Math.log(i * (frequency % 100)) * size.height / 2)));
    }
    return points;
  }

  
  /** 
   * @param size
   * @param frequency
   * @return ArrayList<Pair<Integer, Integer>>
   */
  public static ArrayList<Pair<Integer, Integer>> generateExpWave(java.awt.Dimension size, double frequency) {
    ArrayList<Pair<Integer, Integer>> points = new ArrayList<>();
    for (int i = 0; i < size.width; i++) {
      points.add(new Pair<>(i, (int) (size.height / 2 + Math.exp(i * (frequency % 100)) * size.height / 2)));
    }
    return points;
  }


}
