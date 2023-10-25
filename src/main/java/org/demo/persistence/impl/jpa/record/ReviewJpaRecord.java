package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Persistent class for "Review" entity stored in table "REVIEW" <br>
 * This class is a "record entity" without JPA links  <br>
 *
 */
@Entity
@Table(name="REVIEW", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ReviewJpaRecord.countAll",  query="SELECT COUNT(x) FROM ReviewJpaRecord x" ),
  @NamedQuery ( name="ReviewJpaRecord.countById", query="SELECT COUNT(x) FROM ReviewJpaRecord x WHERE x.compositePrimaryKey.customerCode = ?1  AND x.compositePrimaryKey.bookId = ?2 " )
} )
public class ReviewJpaRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    private ReviewJpaRecordKey compositePrimaryKey ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="REVIEW_TEXT")
    private String     reviewText   ; 

    @Column(name="REVIEW_NOTE")
    private Integer    reviewNote   ; 

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATION")
    private Date       creation     ; 

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATE")
    private Date       lastUpdate   ; 


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ReviewJpaRecord() {
		super();
		this.compositePrimaryKey = new ReviewJpaRecordKey();       
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    public void setCustomerCode( String customerCode ) {
        this.compositePrimaryKey.setCustomerCode( customerCode ) ;
    }
    public String getCustomerCode() {
        return this.compositePrimaryKey.getCustomerCode() ;
    }
    public void setBookId( Integer bookId ) {
        this.compositePrimaryKey.setBookId( bookId ) ;
    }
    public Integer getBookId() {
        return this.compositePrimaryKey.getBookId() ;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : REVIEW_TEXT ( LONG VARCHAR ) 
    public void setReviewText( String reviewText ) {
        this.reviewText = reviewText;
    }
    public String getReviewText() {
        return this.reviewText;
    }

    //--- DATABASE MAPPING : REVIEW_NOTE ( INTEGER ) 
    public void setReviewNote( Integer reviewNote ) {
        this.reviewNote = reviewNote;
    }
    public Integer getReviewNote() {
        return this.reviewNote;
    }

    //--- DATABASE MAPPING : CREATION ( TIMESTAMP ) 
    public void setCreation( Date creation ) {
        this.creation = creation;
    }
    public Date getCreation() {
        return this.creation;
    }

    //--- DATABASE MAPPING : LAST_UPDATE ( TIMESTAMP ) 
    public void setLastUpdate( Date lastUpdate ) {
        this.lastUpdate = lastUpdate;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        if ( compositePrimaryKey != null ) {  
            sb.append(compositePrimaryKey.toString());  
        }  
        else {  
            sb.append( "(null-key)" ); 
        }  
        sb.append("]:"); 
        // attribute 'reviewText' not usable (type = String Long Text)
        sb.append(reviewNote);
        sb.append("|");
        sb.append(creation);
        sb.append("|");
        sb.append(lastUpdate);
        return sb.toString(); 
    } 

}
