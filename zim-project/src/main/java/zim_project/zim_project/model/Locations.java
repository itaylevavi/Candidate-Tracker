package zim_project.zim_project.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "locations")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationid")
    private Long locationid;

    @NotNull
    private String name;

    // Getters and Setters

    public Long getLocationId() {
        return locationid;
    }

    public void setLocationId(Long locationId) {
        this.locationid = locationid; // שגוי - המשתנה "locationid" לא מקבל את הפרמטר
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optional: Override toString(), equals() and hashCode() if necessary
}