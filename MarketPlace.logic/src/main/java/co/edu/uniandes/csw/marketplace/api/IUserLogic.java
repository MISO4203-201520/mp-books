/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.UserDTO;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jonatan
 */
public interface IUserLogic {

    public Response login(UserDTO user);
}
