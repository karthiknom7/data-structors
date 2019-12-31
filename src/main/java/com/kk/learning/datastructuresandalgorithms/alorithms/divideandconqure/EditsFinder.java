package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

public class EditsFinder {

    int findNumberOfEdits(char[] str1, char[] str2, int charAtS1, int charAts2) {
        int s1Length = str1.length;
        int s2Length = str2.length;
        if (charAtS1 == s1Length - 1 && charAts2 == s2Length - 1) {
            return 0;
        } else if (charAtS1 != s1Length - 1 && charAts2 == s2Length - 1) {
            return findNumberOfEdits(str1, str2, charAtS1 + 1, charAts2) + 1;
        } else if (charAtS1 == s1Length - 1 && charAts2 != s2Length - 1) {
            return findNumberOfEdits(str1, str2, charAtS1, charAts2 + 1) + 1;
        } else {
            if (str1[charAtS1] == str2[charAts2]) {
                return findNumberOfEdits(str1, str2, charAtS1 + 1, charAts2 + 1);
            } else {
                int replace = findNumberOfEdits(str1, str2, charAtS1 + 1, charAts2+1) + 1;
                int delete = findNumberOfEdits(str1, str2, charAtS1 + 1, charAts2) + 1;
                int insert = findNumberOfEdits(str1, str2, charAtS1, charAts2 + 1) + 1;
                return Math.min(replace, Math.min(delete, insert));
            }

        }

    }
}
