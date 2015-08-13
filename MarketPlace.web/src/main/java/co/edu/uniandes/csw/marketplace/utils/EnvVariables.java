/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.marketplace.utils;

import java.util.Properties;

/**
 *
 * @author Jhonatan
 */
public class EnvVariables extends Properties {

    public EnvVariables() {
        super.put("apiKey.id", System.getenv("STORMPATHAPIKEYID"));
        super.put("apiKey.secret", System.getenv("STORMPATHAPIKEYSECRET"));
    }
}
