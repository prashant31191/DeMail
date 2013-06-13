package edu.tsystems.demail.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: B
 * Date: 07.06.13
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="users")
@NamedQueries({
    @NamedQuery(name = "UserEntity.getAll", query = "SELECT u FROM UserEntity u"),
    @NamedQuery(name = "UserEntity.findByLogin",
        query = "SELECT u FROM UserEntity u WHERE u.login = :login"),
    @NamedQuery(name = "UserEntity.findByLoginAndPassword",
        query = "SELECT u FROM UserEntity u WHERE u.login = :login AND u.pass = :password")
})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "login", length = 30)
    @NotNull
    private String login;
    @Column (name = "first_name", length = 30)
    @NotNull
    private String first_name;
    @Column (name = "last_name", length = 30)
    @NotNull
    private String last_name;
    @Column (name = "phone", length = 30)
    @NotNull
    private String phone;
    @Column (name = "pass", length = 30)
    @NotNull
    private String pass;
    @OneToOne
    @PrimaryKeyJoinColumn
    private MBoxEntity mailBox;

    public UserEntity() {
    }

    public UserEntity(String login, String first_name, String last_name, String phone, String pass, MBoxEntity mailBox) {
        this.login = login;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.pass = pass;
        this.mailBox = mailBox;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public MBoxEntity getMailBox() {
        return mailBox;
    }

    public void setMailBox(MBoxEntity mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", pass='" + pass + '\'' +
                ", mailBox=" + mailBox +
                '}';
    }
}

