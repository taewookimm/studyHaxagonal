package study.haxagonal.library.adapter.In.web.dto;

import jakarta.validation.constraints.NotNull;

public record LibraryDeleteCommand(
        @NotNull Long id
) {
}
