package serviceproducts.java.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "products")
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //KEY AUTOINCREMENTAL
    private long id;
    private String name;
    private Double price;
    
    @Column(name = "create_at")  // En la base de datos generalmente se declaran separadas con guion bajo
    @Temporal(TemporalType.DATE) // Formato en el que se guardara la fecha DATE/TIME/TIMESTAMP
    private Date createAt;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Date getDate() {
        return createAt;
    }
    public void setDate(Date date) {
        this.createAt = date;
    }

    //Generate serial version ?
}
