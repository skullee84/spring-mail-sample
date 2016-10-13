package com.appskimo.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by dominic.lee on 2016. 10. 13..
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Mail implements Serializable {
    private static final long serialVersionUID = -3478614284990598285L;

    private String address;
    private String title;
    private String content;

}
