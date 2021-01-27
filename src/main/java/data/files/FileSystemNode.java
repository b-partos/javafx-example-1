package data.files;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class FileSystemNode {

    private final String name;
    private final FileSystemNode parent;
    private final List<FileSystemNode> children;

}
