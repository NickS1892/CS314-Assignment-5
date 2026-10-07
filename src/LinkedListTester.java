/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:
 *  email address:
 *  UTEID:
 *  Number of slip days used on this assignment:
 */

/* Experiment results. CS314 students, place your experiment
 *  results here:
 *
 */


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Experiment Results
 *<br>
 * 1. Adding to the End (same N)
 *<br>
 *                   ArrayList                   LL314
 *        N       Total     Per op          Total     Per op
 *               (sec)   (microsec)        (sec)    (microsec)
 *    ---------  ------   ----------      ------   ----------
 *      30,000   0.1153      3.84         0.0334       1.11
 *      60,000   0.3511      5.85         0.1298       2.16
 *     120,000   0.1412      1.18         0.2249       1.87
 *     240,000   0.7953      3.31         0.4740       1.98
 *     480,000   1.4547      3.03         0.9817       2.05
 *<br>
 * 2. Adding to Front (LinkedList is faster)
 *<br>
 *            ArrayList                              LL314
 *        N      Total     Per op          N        Total     Per op
 *              (sec)   (microsec)                  (sec)   (microsec)
 *    --------  ------  ----------     ---------   ------   ----------
 *      2,000   0.0697      34.85         10,000   0.0079       0.79
 *      4,000   0.1700      42.50         20,000   0.0143       0.72
 *      8,000   0.5007      62.59         40,000   0.0298       0.75
 *     16,000   1.8420     115.13         80,000   0.0560       0.70
 *     32,000   7.2072     225.23        160,000   0.1324       0.83
 *<br>
 * 3. Removing from Front (LinkedList is faster)
 *<br>
 *            ArrayList                              LL314
 *        N      Total     Per op          N        Total     Per op
 *              (sec)   (microsec)                  (sec)   (microsec)
 *    --------  ------  ----------     ---------   ------   ----------
 *      2,000   0.0662      33.10          5,000   0.0017       0.34
 *      4,000   0.1698      42.45         10,000   0.0035       0.35
 *      8,000   0.4506      56.33         20,000   0.0091       0.46
 *     16,000   1.7778     111.11         40,000   0.0227       0.57
 *     32,000   6.9626     217.58         80,000   0.0563       0.70
 *<br>
 * 4. Getting Random (ArrayList is faster)
 *<br>
 *            ArrayList                              LL314
 *        N      Total     Per op          N        Total     Per op
 *              (sec)   (microsec)                  (sec)   (microsec)
 *    --------  ------  ----------     ---------   ------   ----------
 *     10,000   0.0253       2.53          1,000   0.1088     108.80
 *     20,000   0.0541       2.71          2,000   0.4638     231.90
 *     40,000   0.1167       2.92          4,000   1.8723     468.08
 *     80,000   0.3432       4.29          8,000   7.6585     957.31
 *    160,000   0.9740       6.09         16,000  30.9516    1934.48
 *<br>
 * 5. Getting all using Iterator (ArrayList is faster)
 *<br>
 *                   ArrayList                   LL314
 *        N       Total     Per op          Total     Per op
 *               (sec)   (microsec)        (sec)    (microsec)
 *    ---------  ------   ----------      ------   ----------
 *      50,000   0.0091      0.18         0.0167       0.33
 *     100,000   0.0136      0.14         0.0357       0.36
 *     200,000   0.0280      0.14         0.0813       0.41
 *     400,000   0.0612      0.15         0.1743       0.44
 *     800,000   0.1173      0.15         0.3693       0.46
 *<br>
 * 6. Getting all using get method (ArrayList is faster)
 *<br>
 *            ArrayList                              LL314
 *        N      Total     Per op          N        Total     Per op
 *              (sec)   (microsec)                  (sec)   (microsec)
 *    --------  ------  ----------     ---------   ------   ----------
 *    100,000   0.0126       0.13          1,000   0.1002     100.20
 *    200,000   0.0296       0.15          2,000   0.4485     224.25
 *    400,000   0.0605       0.15          4,000   1.8903     472.58
 *    800,000   0.1196       0.15          8,000   7.5744     946.80
 *  1,600,000   0.2389       0.15         16,000  30.3415    1896.34
 *<br>
 *
 * Adding at end:
 * Both were similar in speed. Example: for N = 480000, ArrayList took 1.4547 and
 * LL314 took 0.9817. Both are about O(1). ArrayList is amortized O(1) because
 * it sometimes resizes, while LL314 just adds a node to the end.
 *<br>
 * Adding at front:
 * LL314 was much faster. ArrayList times increased quickly (0.0697 -> 7.2072)
 * which suggests O(N). LL314 times increased slowly (0.0079 -> 0.1324) which
 * suggests O(1). ArrayList has to shift all elements, LL314 just updates
 * pointers.
 *<br>
 * Removing from front:
 * LL314 was faster. ArrayList again grows quickly in time (0.0662 -> 6.9626)
 * which suggests O(N) because elements must shift left. LL314 is about O(1)
 * (0.0017 -> 0.0563) since it just moves the first pointer.
 * <br>
 * Getting random element:
 * ArrayList was much faster. Its times grow slowly (0.0253 -> 0.9740) which
 * suggests O(1) access. LL314 times grow very fast (0.1088 -> 30.9516) which
 * suggests O(N) because it must traverse the list.
 * <br>
 * Getting all using iterator:
 * Both are about O(N). ArrayList is a little faster (0.1173 vs 0.3693 at
 * N = 800000) but both increase at about the same rate because every element
 * must be visited.
 * <br>
 * Getting all using get():
 * ArrayList is much faster. ArrayList is O(N) since each get is O(1). LL314
 * is about O(N^2) because each get requires traversing the list. At N = 16000,
 * LL314 took 30.3415 while ArrayList took only 0.2389 at N = 1600000.
 * <br>
 * Overall, LL314 was faster for adding and removing at the front because
 * these operations only require updating pointers. ArrayList was faster
 * when accessing a specific position because it provides O(1) access.
 * When using an iterator to get every element, both were O(N) because
 * each element only needs to be visited once.
 */
public class LinkedListTester {

    public static void main(String[] args) {



       // studentTests();

        // CS314 Students:
        // uncomment the following line to run tests comparing
        // your LL314 class to the java ArrayList class.
        comparison();
    }

    private static void studentTests() {
        System.out.println("****** STUDENT TESTS *******\n");
        int testNum = 1;

        // ------------------- add -------------------
        System.out.println("\nTest " + testNum + ": add five elements keeps order and size");
        LL314<Integer> add1 = new LL314<>();
        for (int i = 1; i <= 5; i++) {
            add1.add(i);
        }
        System.out.println(add1.toString().equals("[1, 2, 3, 4, 5]") && add1.size() == 5
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": add after makeEmpty starts a fresh list");
        LL314<String> add2 = new LL314<>();
        add2.add("a");
        add2.makeEmpty();
        add2.add("b");
        add2.add("c");
        System.out.println(add2.toString().equals("[b, c]") && add2.size() == 2
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- insert -------------------
        System.out.println("\nTest " + testNum + ": insert at pos 0 into empty list");
        LL314<String> ins1 = new LL314<>();
        ins1.insert(0, "A");
        System.out.println(ins1.toString().equals("[A]") && ins1.size() == 1
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": two middle inserts keep prev links correct");
        LL314<String> ins2 = new LL314<>();
        ins2.add("A");
        ins2.add("D");
        ins2.insert(1, "B");
        ins2.insert(2, "C");
        String insBack1 = ins2.removeLast();
        String insBack2 = ins2.removeLast();
        System.out.println(insBack1.equals("D") && insBack2.equals("C") && ins2.toString().equals("[A, B]")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- set -------------------
        System.out.println("\nTest " + testNum + ": set middle element returns old value, size unchanged");
        LL314<String> set1 = new LL314<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        String setOld = set1.set(1, "X");
        System.out.println(setOld.equals("B") && set1.toString().equals("[A, X, C]") && set1.size() == 3
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": set with negative pos throws IllegalArgumentException");
        LL314<String> set2 = new LL314<>();
        set2.add("A");
        boolean setThrew = false;
        try {
            set2.set(-1, "B");
        } catch (IllegalArgumentException e) {
            setThrew = true;
        }
        System.out.println(setThrew && set2.get(0).equals("A")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- get -------------------
        System.out.println("\nTest " + testNum + ": get on single element list");
        LL314<String> get1 = new LL314<>();
        get1.add("solo");
        System.out.println(get1.get(0).equals("solo") ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": get(size) throws IllegalArgumentException");
        LL314<String> get2 = new LL314<>();
        get2.add("A");
        get2.add("B");
        boolean getThrew = false;
        try {
            get2.get(2);
        } catch (IllegalArgumentException e) {
            getThrew = true;
        }
        System.out.println(getThrew ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- size -------------------
        System.out.println("\nTest " + testNum + ": size after ten adds");
        LL314<Integer> size1 = new LL314<>();
        for (int i = 0; i < 10; i++) {
            size1.add(i);
        }
        System.out.println(size1.size() == 10 ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": size unchanged by failed remove, drops after removeRange");
        LL314<Integer> size2 = new LL314<>();
        for (int i = 0; i < 5; i++) {
            size2.add(i);
        }
        size2.remove(Integer.valueOf(99));
        boolean sizeSame = size2.size() == 5;
        size2.removeRange(1, 3);
        System.out.println(sizeSame && size2.size() == 3 ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- remove(int pos) -------------------
        System.out.println("\nTest " + testNum + ": remove(0) returns first and updates list");
        LL314<String> rp1 = new LL314<>();
        rp1.add("A");
        rp1.add("B");
        rp1.add("C");
        String rp1Result = rp1.remove(0);
        System.out.println(rp1Result.equals("A") && rp1.toString().equals("[B, C]") && rp1.size() == 2
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": remove(size - 1) then add");
        LL314<String> rp2 = new LL314<>();
        rp2.add("A");
        rp2.add("B");
        rp2.add("C");
        String rp2Result = rp2.remove(rp2.size() - 1);
        rp2.add("D");
        System.out.println(rp2Result.equals("C") && rp2.toString().equals("[A, B, D]")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- remove(E obj) -------------------
        System.out.println("\nTest " + testNum + ": remove(obj) from middle keeps links in both directions");
        LL314<String> ro1 = new LL314<>();
        ro1.add("A");
        ro1.add("B");
        ro1.add("C");
        boolean ro1Removed = ro1.remove("B");
        String ro1Back1 = ro1.removeLast();
        String ro1Back2 = ro1.removeLast();
        System.out.println(ro1Removed && ro1Back1.equals("C") && ro1Back2.equals("A") && ro1.size() == 0
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": remove(obj) on empty list returns false");
        LL314<String> ro2 = new LL314<>();
        System.out.println(!ro2.remove("A") && ro2.size() == 0
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- makeEmpty -------------------
        System.out.println("\nTest " + testNum + ": get on list after makeEmpty throws");
        LL314<String> me1 = new LL314<>();
        me1.add("A");
        me1.add("B");
        me1.makeEmpty();
        boolean meThrew = false;
        try {
            me1.get(0);
        } catch (IllegalArgumentException e) {
            meThrew = true;
        }
        System.out.println(meThrew && me1.toString().equals("[]")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": makeEmpty twice then addFirst works");
        LL314<String> me2 = new LL314<>();
        me2.add("A");
        me2.makeEmpty();
        me2.makeEmpty();
        me2.addFirst("Z");
        System.out.println(me2.toString().equals("[Z]") && me2.size() == 1
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- getSubList -------------------
        System.out.println("\nTest " + testNum + ": getSubList from the front");
        LL314<String> gs1 = new LL314<>();
        gs1.add("A");
        gs1.add("B");
        gs1.add("C");
        gs1.add("D");
        IList<String> gs1Sub = gs1.getSubList(0, 2);
        System.out.println(gs1Sub.toString().equals("[A, B]") && gs1Sub.size() == 2
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": changing a sublist does not change the original");
        LL314<String> gs2 = new LL314<>();
        gs2.add("A");
        gs2.add("B");
        gs2.add("C");
        gs2.add("D");
        IList<String> gs2Sub = gs2.getSubList(2, 4);
        gs2Sub.add("Z");
        System.out.println(gs2Sub.toString().equals("[C, D, Z]") && gs2.toString().equals("[A, B, C, D]")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- indexOf(item) -------------------
        System.out.println("\nTest " + testNum + ": indexOf finds item at the end");
        LL314<String> io1 = new LL314<>();
        io1.add("A");
        io1.add("B");
        io1.add("C");
        System.out.println(io1.indexOf("C") == 2 ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": indexOf on empty list returns -1");
        LL314<String> io2 = new LL314<>();
        System.out.println(io2.indexOf("A") == -1 ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- indexOf(item, pos) -------------------
        System.out.println("\nTest " + testNum + ": indexOf(item, 0) behaves like indexOf(item)");
        LL314<String> ip1 = new LL314<>();
        ip1.add("a");
        ip1.add("b");
        ip1.add("a");
        System.out.println(ip1.indexOf("a", 0) == 0 ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": indexOf(item, pos) with negative pos throws");
        LL314<String> ip2 = new LL314<>();
        ip2.add("a");
        boolean ipThrew = false;
        try {
            ip2.indexOf("a", -1);
        } catch (IllegalArgumentException e) {
            ipThrew = true;
        }
        System.out.println(ipThrew ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- iterator() -------------------
        System.out.println("\nTest " + testNum + ": iterator() returns a non-null iterator");
        LL314<String> it1 = new LL314<>();
        System.out.println(it1.iterator() != null ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": two iterators on the same list are independent");
        LL314<String> it2 = new LL314<>();
        it2.add("A");
        it2.add("B");
        Iterator<String> itA = it2.iterator();
        Iterator<String> itB = it2.iterator();
        itA.next();
        itA.next();
        System.out.println(!itA.hasNext() && itB.hasNext() && itB.next().equals("A")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- iterator.hasNext -------------------
        System.out.println("\nTest " + testNum + ": hasNext true until last element is returned");
        LL314<String> hn1 = new LL314<>();
        hn1.add("A");
        hn1.add("B");
        Iterator<String> hn1It = hn1.iterator();
        hn1It.next();
        boolean hnMid = hn1It.hasNext();
        hn1It.next();
        System.out.println(hnMid && !hn1It.hasNext() ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": hasNext false after removing the only element");
        LL314<String> hn2 = new LL314<>();
        hn2.add("A");
        Iterator<String> hn2It = hn2.iterator();
        hn2It.next();
        hn2It.remove();
        System.out.println(!hn2It.hasNext() && hn2.size() == 0
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- iterator.next -------------------
        System.out.println("\nTest " + testNum + ": next visits every element exactly once");
        LL314<String> nx1 = new LL314<>();
        nx1.add("A");
        nx1.add("B");
        nx1.add("C");
        StringBuilder nxSb = new StringBuilder();
        Iterator<String> nx1It = nx1.iterator();
        while (nx1It.hasNext()) {
            nxSb.append(nx1It.next());
        }
        System.out.println(nxSb.toString().equals("ABC") ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": next on integers sums correctly");
        LL314<Integer> nx2 = new LL314<>();
        for (int i = 1; i <= 4; i++) {
            nx2.add(i);
        }
        int nxSum = 0;
        Iterator<Integer> nx2It = nx2.iterator();
        while (nx2It.hasNext()) {
            nxSum += nx2It.next();
        }
        System.out.println(nxSum == 10 ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- iterator.remove -------------------
        System.out.println("\nTest " + testNum + ": removing every even number while iterating");
        LL314<Integer> ir1 = new LL314<>();
        for (int i = 1; i <= 6; i++) {
            ir1.add(i);
        }
        Iterator<Integer> ir1It = ir1.iterator();
        while (ir1It.hasNext()) {
            if (ir1It.next() % 2 == 0) {
                ir1It.remove();
            }
        }
        System.out.println(ir1.toString().equals("[1, 3, 5]") && ir1.size() == 3
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": removing the first element via iterator, next continues");
        LL314<String> ir2 = new LL314<>();
        ir2.add("A");
        ir2.add("B");
        ir2.add("C");
        Iterator<String> ir2It = ir2.iterator();
        ir2It.next();
        ir2It.remove();
        System.out.println(ir2It.next().equals("B") && ir2.toString().equals("[B, C]")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- removeRange -------------------
        System.out.println("\nTest " + testNum + ": removeRange of the whole list, then add");
        LL314<String> rr1 = new LL314<>();
        rr1.add("A");
        rr1.add("B");
        rr1.add("C");
        rr1.removeRange(0, rr1.size());
        boolean rr1Empty = rr1.size() == 0 && rr1.toString().equals("[]");
        rr1.add("Z");
        System.out.println(rr1Empty && rr1.toString().equals("[Z]")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": removeRange in the middle keeps links correct");
        LL314<String> rr2 = new LL314<>();
        rr2.add("A");
        rr2.add("B");
        rr2.add("C");
        rr2.add("D");
        rr2.add("E");
        rr2.removeRange(1, 3);
        String rr2Back1 = rr2.removeLast();
        String rr2Back2 = rr2.removeLast();
        String rr2Back3 = rr2.removeLast();
        System.out.println(rr2Back1.equals("E") && rr2Back2.equals("D") && rr2Back3.equals("A") && rr2.size() == 0
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- toString -------------------
        System.out.println("\nTest " + testNum + ": toString with two elements");
        LL314<String> ts1 = new LL314<>();
        ts1.add("a");
        ts1.add("b");
        System.out.println(ts1.toString().equals("[a, b]") ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": toString after makeEmpty");
        LL314<Integer> ts2 = new LL314<>();
        ts2.add(1);
        ts2.makeEmpty();
        System.out.println(ts2.toString().equals("[]") ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- equals -------------------
        System.out.println("\nTest " + testNum + ": lists equal after one has an element removed");
        LL314<String> eq1a = new LL314<>();
        eq1a.add("a");
        eq1a.add("b");
        eq1a.add("c");
        eq1a.remove("c");
        LL314<String> eq1b = new LL314<>();
        eq1b.add("a");
        eq1b.add("b");
        System.out.println(eq1a.equals(eq1b) && eq1b.equals(eq1a)
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": same elements in different order are not equal");
        LL314<String> eq2a = new LL314<>();
        eq2a.add("a");
        eq2a.add("b");
        LL314<String> eq2b = new LL314<>();
        eq2b.add("b");
        eq2b.add("a");
        System.out.println(!eq2a.equals(eq2b) ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- addFirst -------------------
        System.out.println("\nTest " + testNum + ": addFirst onto an existing list");
        LL314<String> af1 = new LL314<>();
        af1.add("B");
        af1.addFirst("A");
        System.out.println(af1.toString().equals("[A, B]") && af1.size() == 2
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": addFirst in a loop reverses order");
        LL314<Integer> af2 = new LL314<>();
        for (int i = 0; i < 5; i++) {
            af2.addFirst(i);
        }
        System.out.println(af2.get(0) == 4 && af2.get(4) == 0 && af2.size() == 5
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- removeFirst -------------------
        System.out.println("\nTest " + testNum + ": repeated removeFirst returns elements in order");
        LL314<String> rf1 = new LL314<>();
        rf1.add("A");
        rf1.add("B");
        rf1.add("C");
        String rf1a = rf1.removeFirst();
        String rf1b = rf1.removeFirst();
        String rf1c = rf1.removeFirst();
        System.out.println(rf1a.equals("A") && rf1b.equals("B") && rf1c.equals("C") && rf1.size() == 0
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": removeFirst then addFirst keeps links correct");
        LL314<String> rf2 = new LL314<>();
        rf2.add("A");
        rf2.add("B");
        rf2.removeFirst();
        rf2.addFirst("X");
        String rf2Last = rf2.removeLast();
        System.out.println(rf2Last.equals("B") && rf2.toString().equals("[X]")
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        // ------------------- removeLast -------------------
        System.out.println("\nTest " + testNum + ": repeated removeLast returns elements in reverse");
        LL314<String> rl1 = new LL314<>();
        rl1.add("A");
        rl1.add("B");
        rl1.add("C");
        String rl1a = rl1.removeLast();
        String rl1b = rl1.removeLast();
        String rl1c = rl1.removeLast();
        System.out.println(rl1a.equals("C") && rl1b.equals("B") && rl1c.equals("A") && rl1.size() == 0
                ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\nTest " + testNum + ": removeLast then removeFirst on two elements empties list");
        LL314<String> rl2 = new LL314<>();
        rl2.add("A");
        rl2.add("B");
        String rl2Last = rl2.removeLast();
        String rl2First = rl2.removeFirst();
        System.out.println(rl2Last.equals("B") && rl2First.equals("A") && rl2.size() == 0
                && rl2.toString().equals("[]") ? "Passed test " + testNum : "Failed test " + testNum);
        testNum++;

        System.out.println("\n****** TESTS COMPLETE (" + (testNum - 1) + " tests) *******\n");
    }


    // constants for the maximum length of the lists used in the tests as well as
    // the number of times each method should be tested
    private static final int MAX_LENGTH = 15;
    private static final int NUM_TESTS_PER_METHOD = 50;

    // From Spring 2021 students:
    // Tests use randomness to find edge cases, 
    // so the test numbering is irrelevant, each test being different every time the 
    // program is run.
    private static void spring2021StressTests() {
        System.out.println("\n****** SPRING 2021 RANDOM STRESS TESTS *******\n");

        // performs all the tests. The console displays some private methods I have as
        // well, but it isn't actually directly calling those private methods. It merely
        // sets the conditions to where those methods would be called in my personal
        // program. It still is useful to test for edge cases

        final String methodNamesRaw = "void addFirst(E item)\r\n" + "E removeFirst()\r\n"
                + "E removeLast()\r\n" + "void add(E item)\r\n" + "void insert(int pos, E item)\r\n"
                + "void insertBeforeLast(E item)\r\n" + "void insertAfterFirst(E item)\r\n" + "E set(pos, E item)\r\n"
                + "E get(int pos)\r\n" + "E remove(int pos)\r\n" + "E removeAFterFirst()\r\n"
                + "E removeBeforeLast()\r\n" + "boolean remove(E obj)\r\n"
                + "Ilist<E> getSubList(int start, int stop)\r\n" + "int size()\r\n" + "int indexOf(E item)\r\n"
                + "int indexOf(E item, int pos)\r\n" + "void makeEmpty()\r\n"
                + "void removeRange(int start, int stop)\r\n" + "string tosString()\r\n" + "boolean equals(other)\r\n"
                + "ITERATOR LLIterator()\r\n" + "ITERATOR boolean hasNext()\r\n" + "ITERATOR E next()\r\n"
                + "ITERATOR void remove()\r\n";
        final String[] methodNames = methodNamesRaw.split("\r\n");
        String methodName = methodNames[0];
        int methodNum = 0;
        LL314<String> testList = new LL314<>();
        int numTestsFailed = 0;
        HashSet<String> failedTests = new HashSet<>();
        // void addFirst(E item)
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            testList.addFirst("FIRST ELEMENT");
            toCompare.add(0, "FIRST ELEMENT");
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }


        System.out.println();
        // E removeFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeFirst();
            toCompare.remove(0);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeLast();
            toCompare.remove(toCompare.size() - 1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void add(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.add(methodName);
            toCompare.add(methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insert(int pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int randomPos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.insert(randomPos, methodName);
            toCompare.add(randomPos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void insertBeforeLast(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insertAfterFirst(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E set(pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.set(pos, methodName);
            toCompare.set(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E get(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here

            String expected = toCompare.get(pos);
            String actual = testList.get(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E remove(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.remove(pos);
            toCompare.remove(pos);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeAFterFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            if (toCompare.size() == 1) {
                toCompare.add("Item " + 2);
                testList.add("Item " + 2);
            }
            // perform actions here
            testList.remove(1);
            toCompare.remove(1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeBeforeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 2;
            if (pos == -1) {
                pos = 0;
            }
            // perform actions here

            String expected = toCompare.remove(pos);
            String actual = testList.remove(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean remove(E obj)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            String objToRemove = toCompare.get((int) (Math.random() * toCompare.size()));

            // perform actions here
            testList.remove(objToRemove);
            toCompare.remove(objToRemove);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // Ilist<E> getSubList(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int size()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (actualA.size() == expectedB.size()) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int indexOf(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());
            toCompare.add(pos, methodName);
            testList.insert(pos, methodName);
            // perform actions here

            int expected = toCompare.indexOf(methodName);
            int actual = testList.indexOf(methodName);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // int indexOf(E item, int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos2 = (int) (Math.random() * toCompare.size()) + 1;
            int pos1 = (int) (Math.random() * pos2);
            toCompare.add(pos1, methodName);
            toCompare.add(pos2, methodName);
            testList.insert(pos1, methodName);
            testList.insert(pos2, methodName);

            int posToCheckFrom = (int) (Math.random() * toCompare.size());
            // perform actions here
            int expected;
            if (posToCheckFrom > pos2) {
                expected = -1;
            } else if (posToCheckFrom > pos1 && posToCheckFrom <= pos2) {
                expected = pos2;
            } else {
                expected = pos1;
            }

            int actual = testList.indexOf(methodName, posToCheckFrom);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual + "  toCompare Array: " + toCompare.toString()
                        + " testList array " + testList.toString() + "  POS1: " + pos1 + " POS2: " + pos2
                        + " POSTTOCHECK: " + posToCheckFrom);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void makeEmpty()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.makeEmpty();
            toCompare.clear();

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void removeRange(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            testList.removeRange(start, stop);
            for (int j = stop - 1; j >= start; j--) {
                toCompare.remove(j);
            }
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual) + " START: " + start
                        + " STOP: " + stop);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // string tosString()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here

            String expected = toCompare.toString();
            String actual = testList.toString();
            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean equals(other)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            LL314<String> toCompareLinkedList = arrayListToLinkedList(toCompare);
            // perform actions here

            if (testList.equals(toCompareLinkedList)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR LLIterator()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            // perform actions here

            if (testList.iterator().hasNext() && testList.iterator().next().equals(testList.get(0))) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // ITERATOR boolean hasNext()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int count1 = 0;
            int count2 = 0;
            while (testListIterator.hasNext()) {
                count1++;
                testListIterator.next();
            }
            while (toCompareIterator.hasNext()) {
                count2++;
                toCompareIterator.next();
            }

            if (count1 == count2) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR E next()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            boolean pass = true;
            while (testListIterator.hasNext() && toCompareIterator.hasNext() && pass) {
                if (!testListIterator.next().equals(toCompareIterator.next())) {
                    pass = false;
                }
            }
            if (testListIterator.hasNext() != toCompareIterator.hasNext()) {
                pass = false;
            }

            if (pass) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR void remove()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int random = (int) (Math.random() * toCompare.size()) + 1;
            for (int j = 0; j < random; j++) {
                if (testListIterator.hasNext()) {
                    testListIterator.next();
                }
                if (toCompareIterator.hasNext()) {
                    toCompareIterator.next();
                }
            }
            toCompareIterator.remove();
            testListIterator.remove();
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        System.out.println("RESULTS:");
        System.out.println("TOTAL TESTS: " + (NUM_TESTS_PER_METHOD * methodNames.length) + " | TOTAL FAILED: "
                + numTestsFailed + " | FAILED METHODS: " + failedTests.toString() + " |");
    }


    private static LL314<String> newResetedTestList(LL314<String> a) {
        a.makeEmpty();
        int random = (int) (Math.random() * MAX_LENGTH) + 1;
        for (int j = 0; j < random; j++) {
            a.add(String.valueOf((char) (j + 'A')));
        }
        return a;
    }

    private static ArrayList<String> linkedListToArrayList(LL314<String> testList) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<String> s = testList.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static LL314<String> arrayListToLinkedList(ArrayList<String> toCompare) {
        LL314<String> result = new LL314<>();
        Iterator<String> s = toCompare.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static String[] toArray2(IList<String> actualA) {
        String[] result = new String[actualA.size()];
        Iterator<String> it = actualA.iterator();
        int index = 0;
        while (it.hasNext()) {
            result[index] = it.next();
            index++;
        }
        return result;
    }

    private static void itRemoveStressTests() {
        /*
         *  Test that the iterator remove is O(1).
         *  Total time to remove half of list should roughly double
         *  when size of list is doubled.
         */
        final int SEED = 19431215;
        Random r = new Random(SEED);
        Stopwatch st = new Stopwatch();
        final int NUM_DOUBLINGS = 6;
        final int INITIAL_N = 50_000;
        int n = INITIAL_N;
        for (int i = 0; i < NUM_DOUBLINGS; i++) {
            LL314<Double> list = new LL314<>();
            for (int j =0; j < n; j++) {
                list.add(r.nextDouble());
            }
            Iterator<Double> it = list.iterator();
            final int LIMIT = n / 2;
            for (int j = 0; j < LIMIT; j++) {
                it.next();
            }
            st.start();
            while(it.hasNext()) {
                it.next();
                it.remove();
            }
            st.stop();
            System.out.println("number of elements = " + n
                    + " time to remove half of list with iterator = " + st);
            n *= 2;
        }
    }

    // Convert elements of list to an array. Uses the list
    // size method and iterator.
    private static Object[] toArray(LL314<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while(it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    // pre: none
    // post: return true if the 
    private static boolean arraysSame(Object[] one, Object[] two)  {
        return Arrays.equals(one, two);
    }


    private static final int NUM_DOUBLINGS_OF_N = 5;
    private static final int NUM_REPEATS_OF_TEST = 100;

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    private static void comparison(){
        Stopwatch s = new Stopwatch();

        int initialN = 30000;
        addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 10000;
        addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 5000;
        removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 10000;
        getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 50000;
        getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
        getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 100000;
        getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

    }

    // These methods illustrate a failure to use polymorphism.
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repetition of code.
    private static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: ArrayList", totalTimes, initialN);
    }

    private static void showResults(String title, double[] times, int initialN) {
        System.out.println();
        System.out.println("Number of times test run: " + NUM_REPEATS_OF_TEST);
        System.out.println(title);
        for (double time : times) {
            System.out.print("N = " + initialN + ", total time: ");
            System.out.printf("%7.4f\n", time);
            initialN *= 2;
        }
        System.out.println();
    }

    private static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: LinkedList", totalTimes, initialN);
    }

    private static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: ArrayList", totalTimes, initialN);
    }

    private static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.insert(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: LinkedList", totalTimes, initialN);
    }

    private static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<String> javaList = new ArrayList<>();
                for(int j = 0; j < n; j++)
                    javaList.add(j + "");
                s.start();
                while (!javaList.isEmpty()) {
                    javaList.remove(0);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Removing from front: ArrayList", totalTimes, initialN);
    }

    private static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<String> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j + "");
                }
                s.start();
                while (studentList.size() != 0) {
                    studentList.removeFirst();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("removing from front: LinkedList", totalTimes, initialN);
    }

    private static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                for (int j = 0; j < n; j++) {
                    total += javaList.get(r.nextInt(javaList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: ArrayList", totalTimes, initialN);
    }

    private static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                int total = 0;
                s.start();
                for (int j = 0; j < n; j++) {
                    total += studentList.get(r.nextInt(studentList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                Iterator<Integer> it = javaList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                Iterator<Integer> it = studentList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < javaList.size(); j++) {
                    x += javaList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < studentList.size(); j++) {
                    x += studentList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: LinkedList", totalTimes, initialN);
    }
}