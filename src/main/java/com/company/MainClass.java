package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 */
final class MainClass {
    /**
     * @param s string
     * @return string w/o control characters
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
     *
     */
    private MainClass() {
    }

    /**
     * @param fileName input file name
     * @return text from file
     * @throws IOException error of I/O
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
     * @param args params from command line
     * @throws IOException error of I/O
     */
    public static void main(final String[] args)
            throws IOException {
        int level = 0;
        int skip = 0;
        if (args.length < 2) {
            System.out.print("Error! PLease set input and "
                    + "output filename as parameter\n");
            return;
        }
        String text = getTextFromFile(args[0]);
        StringBuilder formattedString = new StringBuilder();
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
            }
        }

        BufferedWriter wr = new BufferedWriter(new FileWriter(args[1]));
        wr.write(formattedString.toString());
        wr.flush();
        System.out.println(formattedString.toString());
    }
}
