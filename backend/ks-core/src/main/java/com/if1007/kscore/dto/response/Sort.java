
package com.if1007.kscore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sort {
    private Boolean empty;
    private Boolean sorted;
    private Boolean unsorted;
}
