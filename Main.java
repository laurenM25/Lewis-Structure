public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> compound = new DoublyLinkedList<String>();
        compound.Root("N");
        compound.Add("C", "east");
        compound.Add("A", "south");

        compound.Move("north");
        compound.Move("west");

        compound.Add("K", "south");
        compound.Add("M", "west");

        compound.Print();

        System.out.println("\nLewis Structure printed.");
    }
}
