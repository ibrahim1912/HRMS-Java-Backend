package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cover_letters")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})
public class CoverLetter {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "writing")
    @NotNull
    @NotBlank
    private String writing;

    //@JsonIgnoreProperties({ "birthYear", "identityNumber", "email","password" })
    @ManyToOne()
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;
}
