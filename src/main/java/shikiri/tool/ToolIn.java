package shikiri.tool;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(fluent = true, chain = true)
public record ToolIn (
    String name,
    String category,
    String description
) {
    
}
