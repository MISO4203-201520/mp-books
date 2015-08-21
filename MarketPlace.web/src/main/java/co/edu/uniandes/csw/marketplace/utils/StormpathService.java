/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.marketplace.utils;

import co.edu.uniandes.csw.marketplace.dtos.UserDTO;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountStatus;
import com.stormpath.sdk.account.Accounts;
import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.api.ApiKeys;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.group.GroupList;
import com.stormpath.shiro.authz.CustomDataPermissionsEditor;
import com.stormpath.shiro.realm.ApplicationRealm;

/**
 *
 * @author Jonatan
 */
public class StormpathService {

    private static Client client, cli;
    private static Application application;

    public static Account createUser(UserDTO user) {
        String path = "/.stormpath/apiKey.properties";
        ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build(); 
        cli = new ApplicationRealm().getClient();
        client = Clients.builder().setApiKey(apiKey).build();       
        application = client.getResource("https://api.stormpath.com/v1/applications/KhmZ2ZpmAIUSPJd4CZFP2", Application.class);
        Account acct = client.instantiate(Account.class);
        acct.setUsername(user.getUserName());
        acct.setPassword(user.getPassword());
        acct.setEmail(user.getEmail());
        acct.setGivenName(user.getName());
        acct.setSurname(user.getName());
        acct.setStatus(AccountStatus.ENABLED);
        GroupList groups = application.getGroups();
        Group group = null;
        for (Group grp : groups) {
            if (grp.getName().equals(user.getRole())) {
                new CustomDataPermissionsEditor(acct.getCustomData())
                .append(user.getRole()+ ":**");
                group = grp;
                acct = application.createAccount(Accounts.newCreateRequestFor(acct).build());
                acct.addGroup(group);
                break;
            }
            
        }
        return acct;
    }

}
