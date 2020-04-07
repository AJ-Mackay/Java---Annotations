package com.codeclan.example.annotation.components;

import com.codeclan.example.annotation.models.File;
import com.codeclan.example.annotation.models.Folder;
import com.codeclan.example.annotation.models.User;
import com.codeclan.example.annotation.repositories.FileRepository;
import com.codeclan.example.annotation.repositories.FolderRepository;
import com.codeclan.example.annotation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        fileRepository.deleteAll();
        folderRepository.deleteAll();
        userRepository.deleteAll();

        User andrew = new User("Andrew");
        userRepository.save(andrew);
        User colin = new User("Colin");
        userRepository.save(colin);
        User paul = new User("Paul");
        userRepository.save(paul);
        User rob = new User("Rob");
        userRepository.save(rob);

        Folder alice = new Folder("Alice Isn't Dead", paul);
        folderRepository.save(alice);
        Folder goodMorning = new Folder("Good Morning Night Vale", andrew);
        folderRepository.save(goodMorning);
        Folder orbiting = new Folder("The Orbiting Human Circus of the Air", colin);
        folderRepository.save(orbiting);
        Folder plague = new Folder ("Our Plague Year", rob);
        folderRepository.save(plague);
        Folder welcome = new Folder("Welcome to Night Vale", andrew);
        folderRepository.save(welcome);

        File podcon = new File("Ad For PodCon", "mp3", 2.90, alice);
        fileRepository.save(podcon);
        File reader = new File("Dear Reader", "mp3", 5.16, alice);
        fileRepository.save(reader);
        File trailer = new File("00 - Trailer", "mp3", 5.38, goodMorning);
        fileRepository.save(trailer);
        File notes = new File ("Notes", "txt", 1.37, goodMorning);
        fileRepository.save(notes);
        File art = new File("Artwork", "png", 1.28, orbiting);
        fileRepository.save(art);
        File webdev = new File("Web Dev Bootcamp", "pdf", 1.07, orbiting);
        fileRepository.save(webdev);
        File paws = new File("Dirty Paws", "mp4", 44.4, plague);
        fileRepository.save(paws);
        File cthulhu = new File("The Adventures of Lil Cthulhu", "avi", 14.4, plague);
        fileRepository.save(cthulhu);
        File hail = new File("All Hail", "zip", 149, welcome);
        fileRepository.save(hail);
        File depths = new File("61 - BRINY DEPTHS", "mp3", 28.4, welcome);
        fileRepository.save(depths);

    }
}
