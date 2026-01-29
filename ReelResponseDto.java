package com.myorganisation.nexify.response;

import com.myorganisation.nexify.model.InternalData;
import lombok.Data;

@Data
public class ReelResponseDto {
    private Long id;
    private String url;
    private InternalData internalData;
}