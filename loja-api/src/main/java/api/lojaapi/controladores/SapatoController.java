package api.lojaapi.controladores;

// import org.springframework.web.multipart.MultipartFile;
import api.lojaapi.core.controller.BaseController;
import api.lojaapi.core.mapper.MapperBase;
import api.lojaapi.core.servicos.CrudService;
import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.modelos.Sapato;
// import api.lojaapi.dtos.SapatoDto;
// import api.lojaapi.modelos.Sapato;
// import api.lojaapi.repositorio.SapatoRepositorio;
// import api.lojaapi.servicos.SapatoService;
// import jakarta.validation.Valid;
// import java.io.IOException;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.beans.BeanUtils;
// import org.springframework.data.domain.Page;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sapato")
@CrossOrigin
public class SapatoController extends BaseController<Sapato, SapatoDto> {

    public SapatoController(CrudService<Sapato> service, MapperBase<Sapato, SapatoDto> mapper) {
        super(service, mapper);
    }


}
