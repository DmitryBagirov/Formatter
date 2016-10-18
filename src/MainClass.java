import java.io.*;
import java.lang.reflect.Array;

public class MainClass {

    public static String clearControlChars(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int j = 0; j < s.length(); j++) {
            int ch = s.codePointAt(j);
            if (ch >= ' ')
                sb.appendCodePoint(ch);
        }
        return sb.toString();
    }

    public static String getTextFromfile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder builder = new StringBuilder();
        String text;
        while ((text = br.readLine()) != null) {
            builder.append(text);
        }
        return clearControlChars(builder.toString());
    }

    public static void main(String[] args) throws IOException {
        int level = 0;
        int skip = 0;
        String text = getTextFromfile(args[0]);
        StringBuilder formattedString = new StringBuilder();
        for (int pos = 0; pos < text.length(); ++pos ) {
            char ch = text.charAt(pos);
            if (Character.toLowerCase(text.charAt(pos)) == 'f' &&
                Character.toLowerCase(text.charAt(pos+1)) == 'o' &&
                Character.toLowerCase(text.charAt(pos+2)) == 'r')
                skip = text.indexOf('{', pos);
            switch (ch) {
                case '{': {
                    level++;
                    formattedString.append(ch+"\n");
                    for(int i = 0; i < level; ++i, formattedString.append('\t'));
                }break;
                case '}': {
                    level--;
                    formattedString.deleteCharAt(formattedString.length()-1);
                    formattedString.append(ch+"\n");
                    for(int i = 0; i < level; ++i, formattedString.append('\t'));
                }break;
                case ';': {
                    if (pos<skip) {
                        formattedString.append(ch);
                        continue;
                    }
                    formattedString.append(ch+"\n");
                    for(int i = 0; i < level; ++i, formattedString.append('\t'));
                }break;
                default: formattedString.append(ch);
            }
        }

        BufferedWriter wr = new BufferedWriter(new FileWriter("output"));
        wr.write(formattedString.toString());
        wr.flush();
        System.out.println(formattedString.toString());
    }
}
