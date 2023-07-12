import java.util.*;

public class CollectionApp {
    public static void main(String[] args){
        Collection collection = null;
        List list = null;
        // ArrayList это список который оптимально реалиует  получение элемента списка по индексу
        list = new ArrayList<>();
        //добавление элемента в конец списка
        list.add("hello");
        //Получение первого элемета списка
        String listEl = (String) list.get(0);
        //Добавление второго элемента списка
        list.add("artyuiop");
        //ставка элемента в начало списка
        list.add(0, "rtyfghvbn");
        //Сортировка списка
        Collections.sort(list);
        //удаление первого элемента списка . опереция не опитамьна для ArrayList . приводит к полному его копированию
        list.remove(0);
        //Удаление всех элементов списка
        list.clear();

        //<> тип который можно поместить
        List<String> listSt = new ArrayList<>();
        listSt.add("jfjjgjgj");
        listSt.add("jfjjgjgj");
        //Получение первого элемента списка без cast
        String listst2 = listSt.get(0);

        //отличается тем что вставка по индекцу написанные не оптимально, но удаление элемента не приводит к пересозданию, редко
        List<String> list3 = new LinkedList<>();

        //Set коллекция которая содержит уникальные значения/элементы она не содержит элементы которые равны друг другу
        Set<String> setSt = new HashSet<String>();
        setSt.add("jfjjgjgj");
        setSt.add("jfjjgjgj");
        setSt.add("hello");
        //в случае помещения не строк, а объектов в set они сравниваются с помощью метода equals
        //задача разработчика убедиться что его классы которые он планирует помещать в set реалиуют метод equals
        //HashSet не сохроняет порядок добавления элементов
        Set<Point> setP = new HashSet<>();
        setP.add(new Point(150, 150));
        setP.add(new Point(200, 200));
        setP.add(new Point(200, 200));

        //LinkedHashSet сохраняет порядок добавления элементов, но он работает чуть медленее чем HashSet
        Set<Point> setP2 = new LinkedHashSet<>();
        setP2.add(new Point(150, 150));
        setP2.add(new Point(200, 200));
        setP2.add(new Point(300, 200));

        //TreeSet хранит элементы в сортированном порядке
        //Внутри храниться как бинарное дерево
        Set<String> setT = new TreeSet<>();
        setT.add("c");
        setT.add("a");
        setT.add("b");
        setT.add("d");

        //Мар хранит таблицу из двух колонок 1 key 2 Value при этом в кеу храниться уникальные значения
        //Ниже создается Мар где ключем является int значеним String
        //Программист обязан следить что класс указанный в качестве ключа всегда реализует метод equals и метод HashCode
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(23, "r");
        testMap.put(13, "r");
        testMap.put(23, "e");
        //Получение значения по ключу
        String mapP = testMap.get(23);

        //циклы по коллекциям
        for(String fSt:setT) {
            System.out.println(fSt);
        }
        for(Map.Entry<Integer, String> fMap: testMap.entrySet()) {
            System.out.println(fMap.getKey() + " = " + fMap.getValue());
        }

    }
}
