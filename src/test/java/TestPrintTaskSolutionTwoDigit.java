import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestPrintTaskSolutionTwoDigit {

   @Test
   public void test() {

      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      InputStream stdin = System.in;

      int numberOfStudent=25;

      String input=String.valueOf(numberOfStudent)+newLine;
      System.setIn(new ByteArrayInputStream(input.getBytes()));

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyRegularTriangle.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String expected="Szabalyos haromszog teruletenek meghatarozsa!"+newLine;
      expected+="Adja meg a haromszog oldalanak hosszat:A terulet nagysaga:270.6329386826371"+newLine;
      expected+="A kerektett terulet erteke:270.63"+newLine;

      String actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      Assertions.assertEquals(expected,actual,"A teljes feladat megoldasanak megjelenitese nem megfelelo!");
   }
}
