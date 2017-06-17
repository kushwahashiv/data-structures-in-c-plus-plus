package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-10-19
 * Time: 上午11:39
 *
 * Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 */
public class C1_66_CircusSortingTest extends TestCase {
    public void testSort() throws Exception {
        C1_66_CircusSorting.Person[] persons = new C1_66_CircusSorting.Person[7];
        persons[0] = new C1_66_CircusSorting.Person(65, 100);
        persons[1] = new C1_66_CircusSorting.Person(70, 150);
        persons[2] = new C1_66_CircusSorting.Person(56, 90);
        persons[3] = new C1_66_CircusSorting.Person(65, 196);
        persons[4] = new C1_66_CircusSorting.Person(60, 95);
        persons[5] = new C1_66_CircusSorting.Person(68, 110);
        persons[6] = new C1_66_CircusSorting.Person(75, 190);

        List<C1_66_CircusSorting.Person> team = C1_66_CircusSorting.sort(persons);
        assertEquals(6, team.size());
        for(int i = 1; i < team.size(); i++){
            assertTrue(team.get(i-1).height <= team.get(i).height
                    && team.get(i-1).weight <= team.get(i).weight);
        }
        for(C1_66_CircusSorting.Person person : team){
            System.out.printf("(%d, %d)\t", person.weight, person.height);
        }
    }
}
