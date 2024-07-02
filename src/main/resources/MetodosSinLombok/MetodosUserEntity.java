import com.maen.persistence.entity.UserEntity;//Getter and Setter.
public Long getId(){
    return id;
}
public void setId(Long id){
    this.id = id;
}

public String getName(){
    return name;
}
public void setName(Strig name){
    this.getName = name;
}

public String getLastName(){
    return lastName;
}
public void setLastName(String lastName){
    this.getLastName = lastName;
}

public String getEmail(){
    return getEmail;
}
public void setEmail(String email){
    this.getEmail = email;
}

public byte getAge(){
    return age;
}
public void setAge(byte age){
    this.age = age;
}

//Constructor con parametros.
public UserEntity(Long id, String name, String lastName, String email, byte age){
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
}

//Constructor vacio.
public UserEntity(){

}