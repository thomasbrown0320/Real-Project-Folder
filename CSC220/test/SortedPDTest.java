
import org.junit.jupiter.api.Test;
import prog02.DirectoryEntry;
import prog02.SortedPD;

import static org.junit.jupiter.api.Assertions.*;

class SortedPDTest extends SortedPD {
    int totalError = 0;

    void print() {
        for (int i = 0; i < theDirectory.length; i++) {
            if (theDirectory[i] == null)
                System.out.print("null");
            else
                System.out.print(theDirectory[i].getName() + ":" +
                        theDirectory[i].getNumber());
            if (i != theDirectory.length - 1)
                System.out.print(",");
        }
        System.out.println(" size = " + size);
    }

    DirectoryEntry[] dirR = {
            new DirectoryEntry("A", "a"),
            new DirectoryEntry("B", "b"),
            new DirectoryEntry("C", "c"),
            new DirectoryEntry("D", "d"),
            new DirectoryEntry("E", "e"),
            new DirectoryEntry("F", "f")
    };

    int indexR[] = {0, 0, 2, 5};
    int sizesR[] = {4, 1, 5, 6};

    boolean testRemove(int i) {
        size = sizesR[i];
        theDirectory = new DirectoryEntry[6];
        for (int j = 0; j < theDirectory.length; j++)
            theDirectory[j] = dirR[j];

        print();

        DirectoryEntry ret;
        try {
            System.out.println("Calling remove(" + indexR[i] + ")");
            ret = remove(indexR[i]);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("crashed");
            return false;
        }

        if (ret == null)
            System.out.println("returned null");
        else
            System.out.println("returned " + ret.getName() + ":" + ret.getNumber());
        if (ret != dirR[indexR[i]])
            return false;

        print();

        if (size != sizesR[i] - 1)
            return false;

        if (theDirectory.length != 6) {
            System.out.println("wrong length");
            return false;
        }

        for (int j = 0; j < indexR[i]; j++)
            if (theDirectory[j] != dirR[j])
                System.out.println("a");
        for (int j = indexR[i]; j < size; j++)
            if (theDirectory[j] != dirR[j + 1])
                return false;

        return true;
    }

    void testRemove() {
        for (int i = 0; i < indexR.length; i++)
            if (testRemove(i))
                System.out.println("SUCCESS");
            else {
                if (i == 0 && theDirectory[0] == dirR[3]) {
                    System.out.println("remove not implemented");
                    System.out.println("ERROR -20");
                    totalError += 20;
                    assertEquals(0, 1);
                    return;
                }
                System.out.println("ERROR -5");
                totalError += 5;
                assertEquals(0, 1);
            }
    }

    DirectoryEntry[] dirA = {new DirectoryEntry("A", "a"),
            new DirectoryEntry("B", "b"),
            new DirectoryEntry("C", "c"),
            new DirectoryEntry("D", "d"),
            new DirectoryEntry("E", "e"),
            new DirectoryEntry("F", "f")};

    DirectoryEntry deA = new DirectoryEntry("X", "x");

    int indexA[] = { 0, 2, 5, 0 };
    int sizesA[] = { 5, 5, 5, 6 };
    int lengthsA[] = { 6, 6, 6, 12 };

    boolean testAdd(int i) {
        theDirectory = new DirectoryEntry[6];
        size = sizesA[i];
        for (int j = 0; j < theDirectory.length; j++)
            theDirectory[j] = dirA[j];

        print();

        DirectoryEntry ret;
        try {
            System.out.println("Calling add(" + indexA[i] + ", {" + deA.getName() + ", " + deA.getNumber() + "})");
            ret = add(indexA[i], deA);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("crashed");
            return false;
        }

        System.out.println("returned " + ret.getName() + ":" + ret.getNumber());
        if (ret != deA)
            return false;

        print();

        if (size != sizesA[i] + 1)
            return false;

        if (theDirectory.length != lengthsA[i]) {
            System.out.println("wrong length");
            return false;
        }

        for (int j = 0; j < indexA[i]; j++)
            if (theDirectory[j] != dirA[j])
                return false;
        if (theDirectory[indexA[i]] != ret)
            return false;
        for (int j = indexA[i] + 1; j < size; j++)
            if (theDirectory[j] != dirA[j - 1])
                return false;

        return true;
    }

    boolean equals(DirectoryEntry a, DirectoryEntry b) {
        if (a == null || b == null)
            return false;
        return a.getName().equals(b.getName()) && a.getNumber().equals(b.getNumber());
    }

    void testAdd() {
        for (int i = 0; i < indexA.length; i++)
            if (testAdd(i))
                System.out.println("SUCCESS");
            else {
                if (i == 0 && theDirectory[5] == dirA[0]) {
                    System.out.println("add not implemented");
                    System.out.println("ERROR -20");
                    totalError += 20;
                    assertEquals(0, 1);
                    return;
                }
                System.out.println("ERROR -5");
                totalError += 5;
                assertEquals(0, 1);
            }
    }


    DirectoryEntry[] dirF = {new DirectoryEntry("B", "b"),
            new DirectoryEntry("D", "d"),
            new DirectoryEntry("F", "f"),
            new DirectoryEntry("H", "h"),
            new DirectoryEntry("J", "j"),
            new DirectoryEntry("L", "l")};

    int sizeF[] = {5, 0, 1, 1, 1, 2, 2, 2, 2, 2};
    String nameF[] = {"C", "A", "A", "B", "C", "A", "B", "C", "D", "E"};
    int retF[] = {1, 0, 0, 0, 1, 0, 0, 1, 1, 2};

    int lastRet;

    boolean testFind(int i) {
        size = sizeF[i];
        int ret;
        print();
        try {
            System.out.println("find(" + nameF[i] + ")");
            ret = find(nameF[i]);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("crashed");
            return false;
        }

        System.out.println("returned " + ret);
        lastRet = ret;
        return ret == retF[i];
    }

    void testFind() {
        theDirectory = dirF;
        for (int i = 0; i < nameF.length; i++)
            if (testFind(i))
                System.out.println("SUCCESS");
            else {
                if (i == 0 && lastRet == -6) {
                    System.out.println("find not implemented");
                    System.out.println("ERROR -20");
                    totalError += 20;
                    assertEquals(0, 1);
                    return;
                }
                System.out.println("ERROR -2");
                totalError += 2;
                assertEquals(0, 1);
            }
    }

    @Test
    void add() {
        testAdd();
    }

    @Test
    void find() {
        testFind();
    }

    @Test
    void remove() {
        testRemove();
    }
}
