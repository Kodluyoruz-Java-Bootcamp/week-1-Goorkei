public class MyList {

    private String[] items;
    private int lenght;
    private int index;

    public MyList() {
        items = new String[5];
        lenght = 5;
        index = 0;
    }

    public void add(String item) {

        if (item.charAt(0) == 'C' || item.charAt(0) == 'c') {
            items[index] = item;
            index++;
            if (index > lenght - 1) {
                String[] tempArray = items;
                items = new String[items.length + 7];
                lenght=lenght+7;
                for (int i = 0; i < tempArray.length; i++) {
                    items[i] = tempArray[i];
                }
            }
        }
    }

    public void print() {
        for (String s : items) {
            System.out.println(s);
        }
    }

    public int getLenght(){
        return lenght;
    }

}
