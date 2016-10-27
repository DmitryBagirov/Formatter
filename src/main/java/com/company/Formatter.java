package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 */
final class Formatter {
    /**
     *
     */
    private Formatter() {
    }

    /**
     * @param s text
     * @return clear text
     */
    private static String clearControlChars(final String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int j = 0; j < s.length(); j++) {
            int ch = s.codePointAt(j);
            if (ch >= ' ') {
                sb.appendCodePoint(ch);
            }
        }
        return sb.toString();
    }

    /**
     * @param fileName input file
     * @return text from file
     * @throws IOException err
     */
    private static String getTextFromFile(final String fileName)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder builder = new StringBuilder();
        String text;
        while ((text = br.readLine()) != null) {
            builder.append(text);
        }
        return clearControlChars(builder.toString());
    }

    /**
     * @param inputFile  source file
     * @param outputFile output file
     * @throws IOException errrror
     */
    static void format(final String inputFile, final String outputFile)
            throws IOException {
        StringBuilder formattedString = new StringBuilder();
        int level = 0;
        int skip = 0;
        String text = getTextFromFile(inputFile);
        for (int pos = 0; pos < text.length(); ++pos) {
            char ch = text.charAt(pos);
            if (Character.toLowerCase(text.charAt(pos)) == 'f'
                    && Character.toLowerCase(text.charAt(pos + 1)) == 'o'
                    && Character.toLowerCase(text.charAt(pos + 2)) == 'r') {
                skip = text.indexOf('{', pos);
            }
            switch (ch) {
                case '{':
                    level++;
                    formattedString.append(ch).append("\n");
                    for (int i = 0; i < level; ++i) {
                        formattedString.append('\t');
                    }
                    break;
                case '}':
                    level--;
                    formattedString.deleteCharAt(formattedString.length() - 1);
                    formattedString.append(ch).append("\n");
                    for (int i = 0; i < level; ++i) {
                        formattedString.append('\t');
                    }
                    break;
                case ';':
                    if (pos < skip) {
                        formattedString.append(ch);
                        continue;
                    }
                    formattedString.append(ch).append("\n");
                    for (int i = 0; i < level; ++i) {
                        formattedString.append('\t');
                    }
                    break;
                default:
                    formattedString.append(ch);
                    break;
            }
        }
        BufferedWriter wr = new BufferedWriter(new FileWriter(outputFile));
        wr.write(formattedString.toString());
        wr.flush();
    }
}
