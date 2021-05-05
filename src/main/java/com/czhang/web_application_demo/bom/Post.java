package com.czhang.web_application_demo.bom;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Setter
    @Getter
    private String userId;

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String title;

    @Setter
    @Getter
    private String body;
}
