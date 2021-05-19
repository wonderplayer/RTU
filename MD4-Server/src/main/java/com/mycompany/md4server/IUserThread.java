/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.md4server;

/**
 *
 * @author rolands
 */
public interface IUserThread extends Runnable {
    public String getUserName();
    public void sendMessage(String message);
    public boolean IsGuessing();
    public boolean IsReady();
    public void SetGuessing(boolean value);
}
