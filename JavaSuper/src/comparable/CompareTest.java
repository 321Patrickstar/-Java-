package comparable;

import org.junit.Test;

import java.util.Arrays;

/*Java中的对象，正常情况下，只能进行比较：==或 != 。不能使用 >或<的，但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。 如何实现？使用两个接口中的任何一个：Comparable或 Comparator

        Java实现对象排序的方式有两种：
        自然排序：java.lang.Comparable
        定制排序：java.util.Comparator*/
public class CompareTest {
    /**
     * Comparable接口的使用举例：  自然排序
     * 1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
     * 2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
     * 3. 重写compareTo(obj)的规则：
     *    如果当前对象this大于形参对象obj，则返回正整数，
     *    如果当前对象this小于形参对象obj，则返回负整数，
     *    如果当前对象this等于形参对象obj，则返回零。
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
