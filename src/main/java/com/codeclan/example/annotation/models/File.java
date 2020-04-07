package com.codeclan.example.annotation.models;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private String extension;

    @Column(name = "sizeInMB")
    private double sizeInMB;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    public File(String name, String extension, double sizeInMB, Folder folder){
        this.name = name;
        this.extension = extension;
        this.sizeInMB = sizeInMB;
        this.folder = folder;
    }

    public File(){}

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

    public String getExtension(){
        return extension;
    }

    public void setExtension(String extension){
        this.extension = extension;
    }

    public double getSizeInMB(){
        return sizeInMB;
    }

    public void setSizeInMB(double sizeInMB){
        this.sizeInMB = sizeInMB;
    }
}
