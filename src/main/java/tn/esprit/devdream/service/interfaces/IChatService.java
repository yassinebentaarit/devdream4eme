package tn.esprit.devdream.service.interfaces;

import tn.esprit.devdream.entities.Chat;

import java.util.List;

public interface IChatService {
    public Chat addChat(Chat c);
    public Chat modifyChat(Chat chat);
    public List<Chat> retrieveAllChat();

    public Chat retrieveChat(Long idChat);
    public void removeChat(Long idChat);
}
