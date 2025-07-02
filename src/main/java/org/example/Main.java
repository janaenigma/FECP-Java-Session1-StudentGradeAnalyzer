package org.example;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();

        System.out.println();

        String[] studentNames = new String[numStudents];
        int[] scores = new int[numStudents];

        double totalScore = 0;
        char letterGrade = 0;
        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeF = 0;

        int topStudentScore = -1;


        for (int i = 0; i < numStudents; i++){
            System.out.print("Enter name of student " + (i+1) + ": ");
            studentNames[i] = input.next();
            System.out.print("Enter score for " + studentNames[i] + ": ");
            scores[i] = input.nextInt();
            totalScore = totalScore + scores[i];
            if (scores[i] >= 90 && scores[i] <= 100) {
                letterGrade = 'A';
                gradeA++;
            }
            else if (scores[i] >= 80 && scores[i] <= 89){
                letterGrade = 'B';
                gradeB++;
            }
            else if (scores[i] >= 70 && scores[i] <= 79){
                letterGrade = 'C';
                gradeC++;
            }
            else if (scores[i] >= 60 && scores[i] <= 69){
                letterGrade = 'D';
                gradeD++;
            }
            else if (scores[i] < 60) {
                letterGrade = 'F';
                gradeF++;
            }

            System.out.println(studentNames[i] + " got grade: " + letterGrade);
            System.out.println();

            if (scores[i] > topStudentScore){
                topStudentScore = scores[i];
            }
        }

        System.out.println("----- Class Summary -----");
        double studentAve = totalScore/numStudents;
        System.out.printf("Average Score: " + "%.2f%n", studentAve);
        System.out.println("Grade Counts: A:" + gradeA + " B:" + gradeB + " C:" + gradeC + " D:" + gradeD + " F:" + gradeF);
        System.out.print("Top Student(s): ");
        boolean firstTopStudent = true;
        for (int i = 0; i < numStudents; i++) {
            if (scores[i] == topStudentScore) {
                if (!firstTopStudent) {
                    System.out.print(", ");
                }
                System.out.print(studentNames[i] + " (" + scores[i] + ")");
                firstTopStudent = false;
            }
        }
        System.out.println();
        input.close();
    }
}
