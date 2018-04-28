/*
 * Copyright (C) 2018 Jerome Cases, Ellis Evangelista 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Bresenham_Action {

    ArrayList<Double> x = new ArrayList<>();
    ArrayList<Double> y = new ArrayList<>();
    ArrayList<Double> pArrayList = new ArrayList<>();
    double x1, x2, y1, y2;
    double deltaY;
    double deltaX;
    double twiceDeltaY;
    double twiceDeltaX;
    double twiceDeltaDifference;
    double twiceDeltaDifference_;
    double p;
    double counter;
    double counter2;
    double slope;
    int i;

    public Map<String, ArrayList<Double>> Map() {

        Map<String, ArrayList<Double>> map = new HashMap();
        map.put("xValues", x);
        map.put("yValues", y);
        map.put("pValues", pArrayList);
        return map;
    }

    public void Assign(double a, double b, double c, double d) {
        x1 = a;
        x2 = b;
        y1 = c;
        y2 = d;
        deltaY = y2 - y1;
        deltaX = x2 - x1;
        twiceDeltaY = 2 * deltaY;
        twiceDeltaX = 2 * deltaX;
        twiceDeltaDifference = twiceDeltaY - twiceDeltaX;
        twiceDeltaDifference_ = twiceDeltaX - twiceDeltaY;
        p = twiceDeltaY - deltaX;
        counter = Math.abs(deltaY);
        counter2 = Math.abs(deltaX);
        slope = deltaY / deltaX;
        i = 0;
    }

    public void Calculate() {
        System.out.println(x1 + " " + x2 + " " + y1 + " " + y2);
        System.out.println("counter1 = " + counter + "counter2 = " + counter2);
        if ((counter == 0) && (counter2 == 0)) {
            System.out.println("END");
            x.add(x2);
            y.add(y2);
            if (p >= 0) {
                p = p + twiceDeltaDifference;
            } else {
                p = p + twiceDeltaY;
            }
            pArrayList.add(p);
            System.out.println(pArrayList.size());
            System.out.println(x);
            System.out.println(y);
        } else if (i == 0) {
            System.out.println("P" + i + " = " + p);
            pArrayList.add(p);
            i++;
            if (counter > 0) {
                counter--;
            }
            if (counter2 > 0) {
                counter2--;
            }
            x.add(x1);
            y.add(y1);
            System.out.println("x = " + x1 + "y = " + y1);
            Calculate();
        } else if(slope < 1) {
//            if (p >= 0) {
//                p = p + twiceDeltaDifference;
//            } else {
//                p = p + twiceDeltaY;
//            }
            if (p >= 0) {
                 p = p + twiceDeltaDifference;
                System.out.println("P" + i + " = " + p);
                pArrayList.add(p);
                if (counter > 0) {
                    counter--;
                }
                if (counter2 > 0) {
                    counter2--;
                }
                if (x1 < x2) {
                    x.add(x.get(i - 1) + 1);
                } else if (x1 > x2) {
                    x.add(x.get(i - 1) - 1);
                } else if(x1 == x2){
                    x.add(x.get(i - 1));
                }
                if (y1 < y2) {
                    y.add(y.get(i - 1) + 1);
                } else if (y1 > y2) {
                    y.add(y.get(i - 1) - 1);
                }
                System.out.println(x);
                System.out.println(y);
                i++;
                Calculate();
            } else {
                 p = p + twiceDeltaY;
                System.out.println("P" + i + " = " + p);
                pArrayList.add(p);
                if (counter > 0) {
                    counter--;
                }
                if (counter2 > 0) {
                    counter2--;
                }
                if (x1 < x2) {
                    x.add(x.get(i - 1) + 1);
                } else if (x1 > x2) {
                    x.add(x.get(i - 1) - 1);
                } else if(x1 == x2){
                    x.add(x.get(i - 1));
                }
                y.add(y.get(i - 1));
                System.out.println(x);
                System.out.println(y);
                i++;
                Calculate();
            }
        }else if(slope > 1){
            if (p >= 0) {
                p = p + twiceDeltaDifference_;
                System.out.println("P" + i + " = " + p);
                pArrayList.add(p);
                if (counter > 0) {
                    counter--;
                }
                if (counter2 > 0) {
                    counter2--;
                }
                if (y1 < y2) {
                    y.add(y.get(i - 1) + 1);
                } else if (y1 > y2) {
                    y.add(y.get(i - 1) - 1);
                } else if(y1 == y2){
                    y.add(y.get(i - 1));
                }
                if (x1 < x2) {
                    x.add(x.get(i - 1) + 1);
                } else if (x1 > x2) {
                    x.add(x.get(i - 1) - 1);
                }
                System.out.println(x);
                System.out.println(y);
                i++;
                Calculate();
            } else {
                p = p + twiceDeltaX;
                System.out.println("P" + i + " = " + p);
                pArrayList.add(p);
                if (counter > 0) {
                    counter--;
                }
                if (counter2 > 0) {
                    counter2--;
                }
                if (y1 < y2) {
                    y.add(y.get(i - 1) + 1);
                } else if (y1 > y2) {
                    y.add(y.get(i - 1) - 1);
                } else if(y1 == y2){
                    y.add(y.get(i - 1));
                }
                x.add(x.get(i - 1));
                System.out.println(x);
                System.out.println(y);
                i++;
                Calculate();
            }
        }
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}
