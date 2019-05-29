package hikingApp;

import javax.persistence.*;

@Entity
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String name;

    private String location;

    private Integer length;

    private Long elevation;

    private Integer stars;

    private String url;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public Integer getLength(){
        return length;
    }

    public void setLength(Integer length){
        this.length = length;
    }

    public Long getElevation(){
        return elevation;
    }

    public void setElevation(Long elevation){
        this.elevation = elevation;
    }

    public Integer getStars(){
        return stars;
    }

    public void setStars(Integer Stars){
        this.stars = stars;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }


}
