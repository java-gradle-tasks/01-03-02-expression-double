   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.*;

   public class TestTwoDigitArea {

      @Test
      public void test() {
         String newLine="";
         if (System.getProperty("os.name").startsWith("Windows")) {
            newLine="\r\n";
         } else {
            newLine="\n";
         }

         InputStream stdin = System.in;

         int side=15;

         String input=String.valueOf(side)+newLine;
         System.setIn(new ByteArrayInputStream(input.getBytes()));

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(byteArrayOutputStream);
         PrintStream stdout = System.out;
         System.setOut(ps);

         MyRegularTriangle.main(new String[0]);

         System.setIn(stdin);
         System.setOut(stdout);

         String expected="A terulet nagysaga:97.42785792574934"+newLine;
         String actual=byteArrayOutputStream.toString();

         System.out.println("Elvart:"+newLine+expected);
         System.out.println("Aktualis:"+newLine+actual);

         boolean found=actual.contains(expected);

         Assertions.assertTrue(found,"Hianyzik az input a kodbol!");
      }
   }
