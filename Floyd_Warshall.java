/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pahse1;

import java.util.stream.DoubleStream;

public class Floyd_Warshall {

    public static void main(String[] args) {
        //represent infinity
        double infinity = Double.POSITIVE_INFINITY;
                       
                        //A          B        C          D        E       F           G       H      I    J
        double[][] W = {{00, 10, infinity, infinity, infinity, 05, infinity, infinity, infinity, infinity},
                        {infinity, 00, 03, infinity, 03, infinity, infinity, infinity, infinity, infinity},
                        {infinity, infinity, 00, 04, infinity, infinity, infinity, 05, infinity, infinity},
                        {infinity, infinity, infinity, 00, infinity, infinity, infinity, infinity, 04, infinity},
                        {infinity, infinity, 04, infinity, 00, infinity, 02, infinity, infinity, infinity},
                        {infinity, 03, infinity, infinity, infinity, 00, infinity, infinity, infinity, 02},
                        {infinity, infinity, infinity, 07, infinity, infinity, 00, infinity, infinity, infinity},
                        {infinity, infinity, infinity, 04, infinity, infinity, infinity, 00, 03, infinity},
                        {infinity, infinity, infinity, infinity, infinity, infinity, infinity, infinity, 00, infinity},
                        {infinity, 06, infinity, infinity, infinity, infinity, 8, infinity, infinity, 00}
        };

        double[][] D = W;
        int num = 0;
        //print D(0)
        System.out.println("D(" + (num) + ")\n"
                + "|0         10        infinity  infinity  infinity  5         infinity  infinity  infinity  infinity |\n"
                + "|infinity  0         3         infinity  3         infinity  infinity  infinity  infinity  infinity |\n"
                + "|infinity  infinity  0         4         infinity  infinity  infinity  5         infinity  infinity |\n"
                + "|infinity  infinity  infinity  0         infinity  infinity  infinity  infinity  4         infinity |\n"
                + "|infinity  infinity  4         infinity  0         infinity  2         infinity  infinity  infinity |\n"
                + "|infinity  3         infinity  infinity  infinity  0         infinity  infinity  infinity  2        |\n"
                + "|infinity  infinity  infinity  7         infinity  infinity  0         infinity  infinity  infinity |\n"
                + "|infinity  infinity  infinity  4         infinity  infinity  infinity  0         3         infinity |\n"
                + "|infinity  infinity  infinity  infinity  infinity  infinity  infinity  infinity  0         infinity |\n"
                + "|infinity  6         infinity  infinity  infinity  infinity  8         infinity  infinity  0        |");

        //computing the distance matrix
        for (int k = 0; k < D.length; k++) {
            System.out.println("");
            System.out.println("D(" + (num + 1) + ")");
            for (int i = 0; i < D.length; i++) {
                 System.out.print("|");
                for (int j = 0; j < D.length; j++) {
                    D[i][j] = (Math.min(D[i][j], (D[i][k] + D[k][j])));

                    System.out.printf("%-10s", (D[i][j] + ""));
                }
                   System.out.print("|");
                System.out.println("");
            }
            System.out.println("");
            num++;
        }

    }

    public static int[] roundUp2(double[] array2) {
        return DoubleStream.of(array2).mapToInt(d -> (int) Math.ceil(d)).toArray();
    }

}
