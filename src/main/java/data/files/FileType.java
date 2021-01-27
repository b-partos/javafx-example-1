package data.files;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class FileType {

    private final String name;
    private final String extension;

}
