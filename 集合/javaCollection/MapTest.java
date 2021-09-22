package javaCollection;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map的实现类的结构：
 *  |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 *         |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
 *              |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                      对于频繁的遍历操作，此类执行效率高于HashMap。
 *         |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                      底层使用红黑树
 *         |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *              |----Properties:常用来处理配置文件。key和value都是String类型
 *
 *
 *      HashMap的底层：数组+链表  （jdk7及之前）
 *                    数组+链表+红黑树 （jdk 8 ）
 *但凡是与打破了自定义类的时候我们需要自定义的equals 和 hashcode
 *
 *
 *
 *  二、Map结构的理解：
 *    Map中的key:无序的、不可重复的，使用Set存储所有的key  ---> key所在的类要重写equals()和hashCode() （以HashMap为例）
 *    Map中的value:无序的、可重复的，使用Collection存储所有的value --->value所在的类要重写equals()
 *    一个键值对：key-value构成了一个Entry对象。
 *    Map中的entry:无序的、不可重复的，使用Set存储所有的entry
 *面试题：
 *  *  1. HashMap的底层实现原理？
 *  *  2. HashMap 和 Hashtable的异同？
 *  *  3. CurrentHashMap（分段访问数据） 与 Hashtable的异同？（暂时不讲）
 *
 * 三、HashMap的底层实现原理？以jdk7为例说明：
 *    HashMap map = new HashMap():
 *    在实例化以后，底层创建了长度是16的一维数组Entry[] table。
 *    ...可能已经执行过多次put...
 *    map.put(key1,value1):
 *    首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 *    如果此位置上的数据为空，此时的key1-value1添加成功。 ----情况1
 *    如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据
 *    的哈希值：
 *           如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。----情况2
 *           如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
 *                如果equals()返回false:此时key1-value1添加成功。----情况3
 *                如果equals()返回true:使用value1替换value2。（类似更新数据）
 *
 *   补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *   在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 */

/**
 * HashMap的扩容
 *     当HashMap中的元素越来越多的时候，hash冲突的几率也就越来越高，
 *     因为数组的长度是固定的。所以为了提高查询的效率，
 *     就要对HashMap的数组进行扩容，而在HashMap数组扩容之后，
 *     最消耗性能的点就出现了：原数组中的数据必须重新计算其在新数组中的位置，
 *     并放进去，这就是resize。
 *
 * 那么HashMap什么时候进行扩容呢？
 *      当HashMap中的元素个数超过数组大小(数组总大小length,
 *      不是数组中个数size)*loadFactor时，就 会 进 行 数 组 扩 容，
 *      loadFactor的默认值(DEFAULT_LOAD_FACTOR)为0.75，这是一个折中的取值。
 *      也就是说，默认情况下，数组大小(DEFAULT_INITIAL_CAPACITY)为16，
 *      那么当HashMap中元素个数超过16*0.75=12（这个值就是代码中的threshold值，
 *      也叫做临界值）的时候，就把数组的大小扩展为2*16=32，即扩大一倍，
 *      然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作，
 *      所以如果我们已经预知HashMap中元素的个数，
 *      那么预设元素的个数能够有效的提高HashMap的性能。
 *      /* 总结：
 *  *   jdk8 相较于jdk7在底层实现方面的不同：
 *  *      1.new HashMap():底层没有创建一个长度为16的数组
 *  *      2.jdk 8底层的数组是：Node[],而非Entry[]
 *  *      3.首次调用put()方法时，底层创建长度为16的数组
 *  *      4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *  *         4.1形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
 *  *         4.2当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。
 *  个人理解：对于哈希表，是按照哈希值（即哈希地址）来存储的，
 *  /*
 *  *  四、LinkedHashMap的底层实现原理（了解）
 *  *      源码中：
 *  *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *  *            Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *  *            Entry(int hash, K key, V value, Node<K,V> next) {
 *  *               super(hash, key, value, next);
 *  *            }
 *  *        }
 *  */
public class MapTest {
    @Test
    public void test(){
        Map map = new HashMap();
//        map = new Hashtable();（不能存放null的key和value）
        map.put(null,123);
    }
    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }
    /**
     *  五、Map中定义的方法：
     *      添加、删除、修改操作：
     *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *      void putAll(Map m):将m中的所有key-value对存放到当前map中
     *      Object remove(Object key)：移除指定key的key-value对，并返回value
     *      void clear()：清空当前map中的所有数据
     *      元素查询的操作：
     *      Object get(Object key)：获取指定key对应的value
     *      boolean containsKey(Object key)：是否包含指定的key
     *      boolean containsValue(Object value)：是否包含指定的value
     *      int size()：返回map中key-value对的个数
     *      boolean isEmpty()：判断当前map是否为空
     *      boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     *      元视图操作的方法：
     *      Set keySet()：返回所有key构成的Set集合
     *      Collection values()：返回所有value构成的Collection集合
     *      Set entrySet()：返回所有key-value对构成的Set集合
     *
     * 总结：常用方法：
     *    添加：put(Object key,Object value)
     *    删除：remove(Object key)
     *    修改：put(Object key,Object value)
     *    查询：get(Object key)
     *    长度：size()
     *    遍历：keySet() / values() / entrySet()
     *
     */




    /**
     * 添加、删除、修改操作：
     *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *  void putAll(Map m):将m中的所有key-value对存放到当前map中
     *  Object remove(Object key)：移除指定key的key-value对，并返回value
     *  void clear()：清空当前map中的所有数据，但其实我们的map对象还在
     *
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //修改
        map.put("AA", 87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 456);
        map.putAll(map1);

        System.out.println(map);

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();//与map = null操作不同
        System.out.println(map.size());
        System.out.println(map);
    }
    /**
     *  元素查询的操作：
     *  Object get(Object key)：获取指定key对应的value
     *  boolean containsKey(Object key)：是否包含指定的key
     *  boolean containsValue(Object value)：是否包含指定的value
     *  int size()：返回map中key-value对的个数
     *  boolean isEmpty()：判断当前map是否为空
     *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        // Object get(Object key)
        System.out.println(map.get(45));
        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();

        System.out.println(map.isEmpty());
    }
    /**
     *  元视图操作的方法：
     *  Set keySet()：返回所有key构成的Set集合
     *  Collection values()：返回所有value构成的Collection集合
     *  Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*****************");

        //遍历所有的values集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println("***************");
        //遍历所有的key-values
        //方式一：
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
        System.out.println("/");
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }
    }
}
