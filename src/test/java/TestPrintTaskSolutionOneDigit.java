import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestPrintTaskSolutionOneDigit {

   @Test
   public void test() {

      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      InputStream stdin = System.in;

      int side=10;

      String input=String.valueOf(side)+newLine;
      System.setIn(new ByteArrayInputStream(input.getBytes()));

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyRegularTriangle.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String expected="Szabalyos haromszog teruletenek meghatarozsa!"+newLine;
      expected+="Adja meg a haromszog oldalanak hosszat:A terulet nagysaga:43.30127018922193"+newLine;
      expected+="A kerekitett terulet erteke:43.3"+newLine;

      String actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      Assertions.assertEquals(expected,actual,"A teljes feladat megoldasanak megjelenitese nem megfelelo!");
   }
}
