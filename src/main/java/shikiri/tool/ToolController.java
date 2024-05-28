package shikiri.tool;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<ToolOut> create(
        @RequestHeader(required = true, name = "id-user") String userId,
        @RequestBody(required = true) ToolIn in
    );

    @PutMapping("/tools")
    ResponseEntity<ToolOut> update (
        @RequestBody(required = true) ToolIn in
    );

    @DeleteMapping("/tools")
    ResponseEntity<ToolOut> delete (
        @RequestBody(required = true) String id
    );

    @GetMapping("/tools/search/by-id")
    ResponseEntity<ToolOut> getById (
        @RequestBody(required = true) String id
    );

    @GetMapping("/tools/search/by-name-containing")
    ResponseEntity<List<ToolOut>> findByNameContaining (
        @RequestBody(required = true) String name,
        @RequestHeader(required = true, name = "id-user") String userId,
        @RequestParam(defaultValue = "name") String sortBy
    );

    @GetMapping("/tools/search/by-category")
    ResponseEntity<List<ToolOut>> findByCategory (
        @RequestBody(required = true) String category,
        @RequestHeader(required = true, name = "id-user") String userId,
        @RequestParam(defaultValue = "name") String sortBy
    );

    @GetMapping("/tool/search/by-user-id")
    ResponseEntity<List<ToolOut>> findOrderByName (
        @RequestHeader(required = true, name = "id-user") String userId
    );
}
