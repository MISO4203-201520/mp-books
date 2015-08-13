package co.edu.uniandes.csw.bookmp.api;

import co.edu.uniandes.csw.bookmp.dtos.EditorialDTO;
import java.util.List;

public interface IEditorialLogic {
    public int countEditorials();
    public List<EditorialDTO> getEditorials(Integer page, Integer maxRecords);
    public EditorialDTO getEditorial(Long id);
    public EditorialDTO createEditorial(EditorialDTO dto);
    public EditorialDTO updateEditorial(EditorialDTO dto);
    public void deleteEditorial(Long id);
    public List<EditorialDTO> findByName(String name);
}
