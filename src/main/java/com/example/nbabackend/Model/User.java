package com.example.nbabackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User extends Card{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String nickname;
    private String senha;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int getCardCvv() {
        return super.getCardCvv();
    }

    @Override
    public void setCardCvv(int cardCvv) {
        super.setCardCvv(cardCvv);
    }

    @Override
    public int getCardNumber() {
        return super.getCardNumber();
    }

    @Override
    public void setCardNumber(int cardNumber) {
        super.setCardNumber(cardNumber);
    }

    @Override
    public String getCardName() {
        return super.getCardName();
    }

    @Override
    public void setCardName(String cardName) {
        super.setCardName(cardName);
    }
}
