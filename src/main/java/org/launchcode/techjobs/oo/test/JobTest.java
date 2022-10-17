package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob.getName(),"Product tester");
        assertEquals(testJob.getEmployer().getValue(),"ACME");
        assertEquals(testJob.getLocation().getValue(),"Desert");
        assertEquals(testJob.getPositionType().getValue(),"Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));

    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){

        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String test = aJob.toString();

        assertEquals('\n',test.charAt(0));
        assertEquals('\n', test.charAt(test.length()-1));


    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String correctFormat = "\n" + "ID: " +aJob.getId()+ "\n" + "Name: Product tester\n" +"Employer: ACME\n" +"Location: Desert\n" + "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(correctFormat,aJob.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job aJob = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency());

        String correctFormat = "\n" + "ID: " +aJob.getId()+ "\n" + "Name: Product tester\n" +"Employer: Data not available\n" +"Location: Desert\n" + "Position Type: Quality control\n" +
                "Core Competency: Data not available\n";

        assertEquals(correctFormat,aJob.toString());
    }


}
