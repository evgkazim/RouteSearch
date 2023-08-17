package org.kazim.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseModel {
    private int from;
    private int to;
    private boolean direct;
}
