package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        //System.out.println("STARTING");
        String returnString = "\n";

        if(Objects.isNull(this.name)&& Objects.isNull(this.employer) &&Objects.isNull(this.location)
                && Objects.isNull(this.positionType) && Objects.isNull(this.coreCompetency) && !Objects.isNull(this.id)){
            returnString += "\nOOPS! This job does not seem to exist\n";
            returnString = returnString + "\n";
            //System.out.println(returnString);
            return returnString;
        }

        returnString += "ID: "+ this.getId() + "\n";

        if(this.getName()==null|| this.getName()==""){returnString+= "Name: Data not available\n";}
        else{returnString += "Name: "+ this.getName() + "\n";}

        if(this.getEmployer().getValue()==null|| this.getEmployer().getValue()==""|| this.getLocation().getValue()==""){returnString+= "Employer: Data not available\n";}
        else{returnString += "Employer: "+ this.getEmployer().getValue() + "\n";}

        if(this.getLocation().getValue()==null || this.getLocation().getValue()==""){returnString+= "Location: Data not available\n";}
        else{returnString += "Location: "+ this.getLocation().getValue() + "\n";}

        if(this.getPositionType().getValue()==null|| this.getPositionType().getValue()==""){returnString+= "Position Type: Data not available\n";}
        else{returnString += "Position Type: "+ this.getPositionType().getValue() + "\n";}

        if(this.getCoreCompetency().getValue()==null|| this.getCoreCompetency().getValue()==""){returnString+= "Core Competency: Data not available\n";}
        else{returnString += "Core Competency: "+ this.getCoreCompetency().getValue() + "\n";}


       // returnString = returnString + "\n";
      //  System.out.println(returnString);
        return returnString;
    }



    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
