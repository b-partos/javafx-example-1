package data.ui;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Layout {

    @Builder.Default
    Double x = 0.0;
    @Builder.Default
    Double y = 0.0;

}
