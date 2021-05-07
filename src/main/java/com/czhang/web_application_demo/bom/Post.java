package com.czhang.web_application_demo.bom;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post {


    private String userId;
    private String id;
    private String title;
    private String body;
}
