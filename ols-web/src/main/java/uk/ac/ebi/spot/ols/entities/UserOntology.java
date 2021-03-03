package uk.ac.ebi.spot.ols.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class UserOntology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Name is mandatory")
    private String name;
    
    @NotNull(message = "Consistency is mandatory")
    private boolean consistency;
    
    @NotNull(message = "Satisfiability is mandatory")
    private boolean satisfiability;

    public UserOntology() {}

    public UserOntology(String name, boolean consistency,boolean satisfiability) {
        this.name = name;
        this.consistency = consistency;
        this.satisfiability = satisfiability;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setConsistency(boolean consistency) {
        this.consistency = consistency;
    }
    
    public void setSatisfiability(boolean satisfiability) {
        this.satisfiability = satisfiability;
    }

    public String getName() {
        return name;
    }

    public boolean getConsistency() {
        return consistency;
    }
    
    public boolean getSatisfiability() {
        return satisfiability;
    }

    @Override
    public String toString() {
        return "UserOntology{" + "id=" + id + ", name=" + name + ", consistency=" + consistency + ", satisfiability=" + satisfiability + '}';
    }
}