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
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) ToolIn in
    );

    @PutMapping("/tools")
    ResponseEntity<ToolOut> update (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) ToolIn in
    );

    @DeleteMapping("/tools")
    ResponseEntity<ToolOut> delete (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) String id
    );

    @GetMapping("/tools")
    ResponseEntity<ToolOut> getById (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) String id
    );

    @GetMapping("/tools/search/by-name-containing")
    ResponseEntity<List<ToolOut>> findByNameContaining (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) String name,
        @RequestParam(defaultValue = "name") String sortBy
    );

    @GetMapping("/tools/search/by-category")
    ResponseEntity<List<ToolOut>> findByCategory (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) String category,
        @RequestParam(defaultValue = "name") String sortBy
    );

    @GetMapping("/tools")
    ResponseEntity<List<ToolOut>> findOrderByName (
        @RequestHeader(required = true, name = "Authorization") String key
    );
}
