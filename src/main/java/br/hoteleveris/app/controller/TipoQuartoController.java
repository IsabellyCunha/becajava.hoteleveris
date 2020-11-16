package br.hoteleveris.app.controller;

/*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import br.hoteleveris.app.request.TipoQuartoList; import
 * br.hoteleveris.app.request.TipoQuartoRequest; import
 * br.hoteleveris.app.response.BaseResponse; import
 * br.hoteleveris.app.response.TipoQuartoResponse; import
 * br.hoteleveris.app.service.TipoQuartoService;
 * 
 * @RestController
 * 
 * @RequestMapping("/tipoQuarto") public class TipoQuartoController extends
 * BaseController{
 * 
 * private final TipoQuartoService _service;
 * 
 * @Autowired public TipoQuartoController(TipoQuartoService service) { _service
 * = service; }
 * 
 * @PostMapping public ResponseEntity inserir(@RequestBody TipoQuartoRequest
 * tipoQuartoRequest) { try { BaseResponse response =
 * _service.inserir(tipoQuartoRequest); return
 * ResponseEntity.status(response.StatusCode).body(response); }catch(Exception
 * e) { return ResponseEntity.status(errorBase.StatusCode).body(errorBase); } }
 * 
 * @GetMapping(path = "/{id}") public ResponseEntity obter(@PathVariable Long
 * id) { try { TipoQuartoResponse response = _service.obter(id); return
 * ResponseEntity.status(response.StatusCode).body(response); } catch (Exception
 * e) { return ResponseEntity.status(errorBase.StatusCode).body(errorBase); } }
 * 
 * @GetMapping public ResponseEntity listar() { try { TipoQuartoList tipoQuartos
 * = _service.listar(); return
 * ResponseEntity.status(HttpStatus.OK).body(tipoQuartos); } catch (Exception e)
 * { return ResponseEntity.status(errorBase.StatusCode).body(errorBase); } }
 * 
 * @DeleteMapping(path = "/{id}") public ResponseEntity deletar(@PathVariable
 * Long id) { try { BaseResponse response = _service.deletar(id); return
 * ResponseEntity.status(response.StatusCode).build(); } catch (Exception e) {
 * return ResponseEntity.status(errorBase.StatusCode).body(errorBase); } }
 * 
 * @PutMapping(path = "/{id}") public ResponseEntity atualizar(@RequestBody
 * TipoQuartoRequest tipoQuartoRequest, @PathVariable Long id) { try {
 * BaseResponse response = _service.atualizar(id, tipoQuartoRequest); return
 * ResponseEntity.status(response.StatusCode).body(response); } catch (Exception
 * e) { return ResponseEntity.status(errorBase.StatusCode).body(errorBase); } }
 * 
 * }
 */