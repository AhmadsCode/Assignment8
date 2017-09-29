/*
 * @author Ahmad Wahedi
 * CSC 201-004N
 * Assignment 8
 * Problem 8.3
 * (Sort students on grades) Rewrite Listing 8.2, GradeExam.java, to display the
 * students in increasing order of the number of correct answers.
 */

public class Assignment8 {
    public static void main(String[] args) {
        // Students' answers to the questions
        char[][] answers = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

        char [] Ans = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'}; // Correct Answers

        int[][] correctCount = new int[answers.length][2]; // Students' number and correct answers


        for (int i = 0; i < answers.length; i++) { // Grade all answers

            for (int j = 0; j < answers[i].length; j++) { // Grade one student
                if (answers[i][j] == Ans[j]) {
                    correctCount[i][0] = i;
                    correctCount[i][1]++;
                }
            }

        }

        sort(correctCount); // Sorts it in increasing order of correct answers.

        // Displays sorted matrix
        for (int row = 0; row < correctCount.length; row++) {
            System.out.println("Student number " + correctCount[row][0] +
                    "'s correct count is " + correctCount[row][1]);
        }
    }

    public static void sort(int[][] m) {
        for (int i = 0; i < m.length; i++) {

            int minColumn1 = m[i][1]; // Find the min in column 1
            int minColumn0 = m[i][0];
            int minIndex = i;

            for (int j = i + 1; j < m.length; j++) {
                if (minColumn1 > m[j][1]) {
                    minColumn1 = m[j][1];
                    minColumn0 = m[j][0];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                m[minIndex][1] = m[i][1];
                m[minIndex][0] = m[i][0];
                m[i][1] = minColumn1;
                m[i][0] = minColumn0;
            }
        }
    }
}
