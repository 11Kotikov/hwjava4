import java.util.*;
// 1. Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список.
//
// 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

public class Main {
    public static LinkedList<String> yourOwnList() {
        String stopWord = "q";
        boolean flag = true;
        LinkedList<String> yourList = new LinkedList<>();
        System.out.println("Input some words those will be in your list: ");
        String input = System.console().readLine();
        while (flag == true) {
            if (input.equals(stopWord)) {
                flag = false;
            } else {
                System.out.println("add some or input just \"q\" + enter and it will be over! ");
                yourList.add(input);
                input = System.console().readLine();
            }
        }
        System.out.println("it's your list = " + yourList);
        return yourList;
    }

    public static LinkedList<String> swapList(LinkedList<String> list) {
        String toFirst;
        LinkedList<String> swaped = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            toFirst = list.get(list.size() - 1 - i);
            swaped.addLast(toFirst);
        }
        System.out.println("it's your reversed list = " + swaped);
        return swaped;
    }

    public static LinkedList<String> enQueue(LinkedList<String> list, String item) {
        list.addLast(item);
        return list;
    }

    public static LinkedList<String> deQueue(LinkedList<String> list) {
        System.out.println("'" + list.removeFirst() + "'" + " was deleted");
        return list;
    }

    public static Object first(LinkedList<String> list) {
        return list.getFirst();
    }

    public static void main(String[] args) {
        LinkedList<String> yourList = yourOwnList();
        Scanner input = new Scanner(System.in);
        int choice = 100;
        do {
            System.out.println("1. Enquene");
            System.out.println("2. Dequeue");
            System.out.println("3. First");
            System.out.println("4. Reverse");
            System.out.println("0. Exit");
            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Please input item to the end of the list: ");
                        String itemToEnd = input.next();
                        LinkedList<String> enqList = enQueue(yourList, itemToEnd);
                        System.out.println(itemToEnd + " is successful queued");
                        System.out.println("It's your new list " + enqList);
                        break;
                    case 2:
                        if (yourList.isEmpty()) {
                            System.out.println("Your list is empty");
                            break;

                        } else {
                            LinkedList<String> deqList = deQueue(yourList);
                            System.out.println("DEqueued is successful");
                            System.out.println("It's your new list " + deqList);
                            break;
                        }

                    case 3:
                        if (yourList.isEmpty()) {
                            System.out.println("Your list is empty");
                            break;
                        } else {
                            System.out.println("Take your fist value: " + first(yourList));
                        }
                        break;
                    case 4:
                    yourList = swapList(yourList);
                        break;
                    case 0:
                        System.out.println("You're welcome!");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Choose right options or 0 to quit");
                input.nextLine();
            }

        } while (choice != 0);
        input.close();
    }

}