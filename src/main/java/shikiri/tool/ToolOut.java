package shikiri.tool;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(fluent = true, chain = true)
public record ToolOut (
    String id,
    String name,
    String category,
    String description,
    String userId
) {
    
}
