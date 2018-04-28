/*
 * Copyright (C) 2018 Jerome Cases 
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

/**
 *
 * @author Jerome Cases
 */
public class bresenham {

    double x1 = 20;
    double x2 = 30;
    double y1 = 10;
    double y2 = 18;
    ArrayList<Double> x = new ArrayList<>();
    ArrayList<Double> y = new ArrayList<>();   
    double deltaY = y2 - y1;
    double deltaX = x2 - x1;
    double twiceDeltaY = 2 * deltaY;
    double twiceDeltaX = 2 * deltaX;
    double twiceDeltaDifference = twiceDeltaY - twiceDeltaX;
    double p = twiceDeltaY - deltaX;
    double counter = Math.abs(deltaY);
    double counter2 = Math.abs(deltaX);
    int i = 0;

    public void Calculate() {
        System.out.println("counter1 = " + counter + "counter2 = " + counter2);
        if ((counter == 0) && (counter2 == 0)) {
            System.out.println("END");
            x.add(x2);
            y.add(y2);
            System.out.println(x);
            System.out.println(y);
        } else if(i == 0){
            System.out.println("P" + i + " = " + p);           
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
        }
        else if (p >= 0) {
            p = p + twiceDeltaDifference;
            System.out.println("P" + i + " = " + p);           
            if (counter > 0) {
                counter--;
            }
            if (counter2 > 0) {
                counter2--;
            }
            if(x1 < x2){
            x.add(x.get(i - 1) + 1);     
            } else if(x1 > x2){
            x.add(x.get(i - 1) - 1); 
            }
            if(y1 < y2){
            y.add(y.get(i - 1) + 1);    
            }else if(y1 > y2){
            y.add(y.get(i - 1) - 1);
            }
            System.out.println(x);
            System.out.println(y);
            i++;
            Calculate();
        } else {
            p = p + twiceDeltaY;
            System.out.println("P" + i + " = " + p);            
            if (counter > 0) {
                counter--;
            }
            if (counter2 > 0) {
                counter2--;
            }
            if(x1 < x2){
            x.add(x.get(i - 1) + 1);     
            } else if(x1 > x2){
            x.add(x.get(i - 1) - 1); 
            }
            if(y1 < y2){
            y.add(y.get(i - 1));    
            }else if(y1 > y2){
            y.add(y.get(i - 1));
            }
            System.out.println(x);
            System.out.println(y);
            i++;
            Calculate();
        }
    }
}

class Run {

    public static void main(String[] args) {
        bresenham b = new bresenham();
        b.Calculate();
    }
}
