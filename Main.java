import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        yourOwnList();
    }

    // public LinkedList <String> ___(String inpuText) {}

    public static LinkedList<String> yourOwnList() {

        String stop = "quit";
        boolean flag = true;
        LinkedList<String> yourList = new LinkedList<>();
        System.out.println("Input some words those will be in your list: ");
        String input = System.console().readLine();
        while (flag == true) {
            if (input.equals(stop)) {
                flag = false;
            } else {
                System.out.println("add some or input \"quit\" and it will be over! ");
                yourList.add(input);
                input = System.console().readLine();
            }
        }
        System.out.println("it's yor list = " + yourList);
        return yourList;
    }
}
