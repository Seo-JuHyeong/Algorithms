package com.company.DFS_BFS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Expert_Academy_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        String[] output = new String[T];

        for(int i = 0; i < T; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String strN = st2.nextToken();

            int strN_length = strN.length();
            int[] N = new int[strN_length];

            for(int k = 0, kdx = 0; k <= strN.length() - 1; k++, kdx++) {
                N[kdx] = strN.charAt(k) - '0';
            }

            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            boolean carry = false;
            output[i] = "";

            for (int j = 0; j <= strN.length() - 1; j++) {
                if (N[j] >= y) {
                    output[i] += Integer.toString(y);
                } else if (N[j] > x) {
                    if (carry == true) {
                        output[i] += Integer.toString(y);
                    } else {
                        output[i] += Integer.toString(x);
                    }
                    carry = true;
                } else if (N[j] == x) {
                    if (carry == true) {
                        output[i] += Integer.toString(y);
                    } else {
                        output[i] += Integer.toString(x);
                    }
                }
            }
            if (output[i].equals("") || output[i].equals("0")) {
                System.out.println("#" + (i+1) + " " + "-1");
            } else {
                System.out.println("#" + (i+1) + " " + output[i]);
            }
        }
    }
}
