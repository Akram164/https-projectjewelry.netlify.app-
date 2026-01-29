package com.myorganisation.nexify.Service;

import com.myorganisation.nexify.dto.request.ReelRequestDto;
import com.myorganisation.nexify.dto.response.ReelResponseDto;

public interface ReelService<ReelResponseDto> {
    ReelResponseDto postReel(ReelRequestDto reelRequestDto);
}

