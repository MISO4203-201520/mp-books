package co.edu.uniandes.csw.bookmp.services;

import co.edu.uniandes.csw.bookmp.api.IEditorialLogic;
import co.edu.uniandes.csw.bookmp.dtos.EditorialDTO;
import co.edu.uniandes.csw.bookmp.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @generated
 */
@Path("/editorials")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EditorialService {

    @Inject private IEditorialLogic editorialLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public EditorialDTO createEditorial(EditorialDTO dto) {
        return editorialLogic.createEditorial(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<EditorialDTO> getEditorials() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", editorialLogic.countEditorials());
        }
        return editorialLogic.getEditorials(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public EditorialDTO getEditorial(@PathParam("id") Long id) {
        return editorialLogic.getEditorial(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public EditorialDTO updateEditorial(@PathParam("id") Long id, EditorialDTO dto) {
        dto.setId(id);
        return editorialLogic.updateEditorial(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEditorial(@PathParam("id") Long id) {
        editorialLogic.deleteEditorial(id);
    }
}
