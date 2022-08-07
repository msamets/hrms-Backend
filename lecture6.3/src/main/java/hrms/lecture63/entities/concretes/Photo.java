package hrms.lecture63.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "photos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "public_id", nullable = false)
    @NotNull
    private String publicId;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties(value ={"photo"})
    @NotNull
    private User user;

    @Column(name = "photo_url",nullable = false)
    @NotNull
    private String photoUrl;

    @Column(name = "width")
    private Short width;

    @Column(name = "height")
    private Short height;

    /*
    @JsonIgnore
    @OneToMany(mappedBy = "cvs")
    private List<Cv> cvs;

     */



}
