package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "Employee" entity stored in table "EMPLOYEE" <br>
 * This class is a "record entity" without JPA links  <br>
 *
 */
@Entity
@Table(name="EMPLOYEE", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="EmployeeJpaRecord.countAll",  query="SELECT COUNT(x) FROM EmployeeJpaRecord x" ),
  @NamedQuery ( name="EmployeeJpaRecord.countById", query="SELECT COUNT(x) FROM EmployeeJpaRecord x WHERE x.code = ?1 " )
} )
public class EmployeeJpaRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="CODE", nullable=false, length=4)
    private String     code         ; 

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="SHOP_CODE", nullable=false, length=3)
    private String     shopCode     ; // Foreign Key 

    @Column(name="FIRST_NAME", length=40)
    private String     firstName    ; 

    @Column(name="LAST_NAME", nullable=false, length=40)
    private String     lastName     ; 

    @Column(name="MANAGER")
    private Short      manager      ; 

    @Column(name="BADGE_NUMBER")
    private Integer    badgeNumber  ; // Foreign Key 

    @Column(name="EMAIL", length=60)
    private String     email        ; 


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EmployeeJpaRecord() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCode( String code ) {
        this.code = code ;
    }
    public String getCode() {
        return this.code;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : SHOP_CODE ( VARCHAR ) 
    public void setShopCode( String shopCode ) {
        this.shopCode = shopCode;
    }
    public String getShopCode() {
        return this.shopCode;
    }

    //--- DATABASE MAPPING : FIRST_NAME ( VARCHAR ) 
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    //--- DATABASE MAPPING : LAST_NAME ( VARCHAR ) 
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    //--- DATABASE MAPPING : MANAGER ( SMALLINT ) 
    public void setManager( Short manager ) {
        this.manager = manager;
    }
    public Short getManager() {
        return this.manager;
    }

    //--- DATABASE MAPPING : BADGE_NUMBER ( INTEGER ) 
    public void setBadgeNumber( Integer badgeNumber ) {
        this.badgeNumber = badgeNumber;
    }
    public Integer getBadgeNumber() {
        return this.badgeNumber;
    }

    //--- DATABASE MAPPING : EMAIL ( VARCHAR ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(code);
        sb.append("]:"); 
        sb.append(shopCode);
        sb.append("|");
        sb.append(firstName);
        sb.append("|");
        sb.append(lastName);
        sb.append("|");
        sb.append(manager);
        sb.append("|");
        sb.append(badgeNumber);
        sb.append("|");
        sb.append(email);
        return sb.toString(); 
    } 

}
