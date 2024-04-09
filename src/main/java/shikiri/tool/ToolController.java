package shikiri.tool;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "shikiri-tool")
public interface ToolController {

    @PostMapping("/tools/create")
    ResponseEntity<ToolOut> createTool (
        @RequestHeader(required = true, name = "id-user") String idUser,
        @RequestBody(required = true) ToolIn in
    );

    @PutMapping("/tools/{id}")
    ResponseEntity<ToolOut> update (
        @RequestHeader(required = true, name = "id-user") String idUser,
        @RequestBody(required = true) ToolIn in
    );

    @DeleteMapping("/tools/{id}")
    ResponseEntity<ToolOut> delete (
        @RequestHeader(required = true, name = "id-user") String idUser,
        @RequestBody(required = true) ToolIn in
    );

    @GetMapping("/tools/{id}")
    ResponseEntity<ToolOut> getToolById (
        @RequestHeader(required = true, name = "id-user") String idUser,
        @PathVariable(required = true) String id
    );

    @GetMapping("/tools/search/by-name")
    ResponseEntity<List<ToolOut>> findToolsByNameContaining (
        @RequestHeader(required = true, name = "id-user") String idUser,
        @RequestParam(required = true) String name,
        @RequestParam(defaultValue = "name") String sortBy
    );

    @GetMapping("/tools/search/by-category")
    ResponseEntity<List<ToolOut>> findToolsByCategory (
        @RequestHeader(required = true, name = "id-user") String idUser,
        @RequestParam(required = true) String category,
        @RequestParam(defaultValue = "name") String sortBy
    );


    @GetMapping("/tools/all/sorted-by-date")
    ResponseEntity<List<ToolOut>> findAllToolsOrderedByCreationDateDesc (
        @RequestHeader(required = true, name = "id-user") String idUser
    );
}