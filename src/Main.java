public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "Hello");
        System.out.println("First element: " + pair.getFirst());
        System.out.println("Second element: " + pair.getSecond());

        pair.setFirst(20);
        pair.setSecond("World");
        System.out.println("Updated first element: " + pair.getFirst());
        System.out.println("Updated second element: " + pair.getSecond());



        DataContainer<String> dataContainer = new DataContainer<String>(String.class);
        dataContainer.add("Apple");
        dataContainer.add("Banana");
        dataContainer.add("Orange");
        System.out.println(dataContainer);
        dataContainer.remove(1);
        System.out.println(dataContainer);
        System.out.println(dataContainer.getSize());
    }
}
