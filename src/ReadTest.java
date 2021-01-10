import java.io.*;

public class ReadTest {
    public static void main(String[] args) throws IOException {
        LineNumberReader reader = null;
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\ZenBook 13\\Downloads\\products.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int count = 0;
            String lastProduct = "";
            double lastCount = 0;
            double lastPrice = 0;
            double totalPrice = 0;
            StringBuilder stringBuilder = new StringBuilder();

            while ((strLine = br.readLine()) != null){
                switch (count) {
                    case 0: lastProduct = strLine;
                        break;
                    case 1: lastPrice = Double.parseDouble(strLine);
                        break;
                    case 2: lastCount = Double.parseDouble(strLine);
                }
                count++;
                if (count == 3) {
                    double calculatedPrice = lastPrice*lastCount;
                    totalPrice += calculatedPrice;
                    String productLine = lastProduct + " " + lastPrice + " x "  + lastCount + " =" + calculatedPrice;
                    stringBuilder.append("\n");
                    stringBuilder.append(productLine);
                    count = 0;
                }
                //System.out.println(strLine);
            }
            stringBuilder.append("\n===================");
            stringBuilder.append("\nИтого:              " + totalPrice);
            System.out.println(stringBuilder.toString());

        }catch (IOException e){
            System.out.println("Ошибка");

        }

    }
}
