import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String symbol = new String();
        List<String> state_dat= new ArrayList<String>();
        List<String> state_sol= new ArrayList<String>();
        try ( FileReader fileReader = new FileReader("\\GameStates\\src\\state_dat.txt"))
        {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine())
            {
                state_dat.add(scanner.nextLine());
            }
            symbol= Character.toString(state_dat.get(0).charAt(state_dat.get(0).length()-1));
            fileReader.close();
            scanner.close();
            state_sol.add(state_dat.get(0));
            for (int j=0; j< state_dat.size();j++)
            {
                for (int i=0; i< state_dat.size();i++) {
                    if (symbol.toLowerCase().equals(Character.toString(state_dat.get(i).toLowerCase().charAt(0)))) {
                        symbol = Character.toString(state_dat.get(i).charAt(state_dat.get(i).length() - 1));
                        state_sol.add(state_dat.get(i));
                        System.out.println(state_dat.get(i));
                        state_dat.remove(state_dat.get(i));
                        i--;
                        break;
                    }
                }
            }
            try
            {
                FileWriter fileWriter = new FileWriter("\\GameStates\\src\\state_sol.txt");
                state_sol.forEach(on -> {
                    try
                    {
                        fileWriter.write(on+" -> ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(state_sol);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
