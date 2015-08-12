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
import com.stormpath.sdk.api.ApiKeys;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.group.GroupList;
import com.stormpath.shiro.authz.CustomDataPermissionsEditor;

/**
 *
 * @author Jonatan
 */
public class StormpathService {

    private static Client client;
    private static Application application;

    public static Account createUserClient(UserDTO user) {
        client = Clients.builder().setApiKey(ApiKeys.builder()
                .setId("6AY666GVQ7QEVVMGFXHYPYLJJ")
                .setSecret("xicC/gFw04GEkKaYdBmRSEEC9tnmuCN+PACVrAT+zAs")
                .build()).build();
        application = client.getResource("https://api.stormpath.com/v1/applications/KhmZ2ZpmAIUSPJd4CZFP2", Application.class);
        Account acct = client.instantiate(Account.class);
        acct.setUsername(user.getUserName());
        acct.setPassword(user.getPassword());
        acct.setEmail(user.getEmail());
        acct.setGivenName(user.getName());
        acct.setSurname(user.getName());
        acct.setStatus(AccountStatus.ENABLED);
        new CustomDataPermissionsEditor(acct.getCustomData())
                .append("user:1234:edit");
        GroupList groups = application.getGroups();
        Group group = null;
        for (Group grp : groups) {
            if (grp.getName().equals("user")) {
                group = grp;
                break;
            }
        }
        acct = application.createAccount(Accounts.newCreateRequestFor(acct).build());
        acct.addGroup(group);
        return acct;
    }

}
