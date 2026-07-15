package com.example.demo.services.cache;

import com.example.demo.dtos.GetProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.Optional;

@Service
@RequiredArgsConstructor

@Slf4j
public class ProductRedisCache {
    private static final String KEY_SUMMARY = "product:summary:";
    private static final Duration CACHE_TTL = Duration.ofMinutes(1);

    private final StringRedisTemplate stringRedisTemplate;


    private final ObjectMapper objectMapper;

    public Optional<GetProductResponseDto> getProductById(Long id){
        String responseJSON = stringRedisTemplate.opsForValue().get(KEY_SUMMARY + id);
        if(responseJSON == null) return Optional.empty();
        try{
            GetProductResponseDto response = objectMapper.readValue(responseJSON, GetProductResponseDto.class);
            return Optional.of(response);
        }
        catch (Exception ex){
            log.error("Error parsing product summary from cache: {}", ex.getMessage());
            stringRedisTemplate.delete(KEY_SUMMARY + id);
            return Optional.empty();
        }
    }

    private void putSummary(Long id, GetProductResponseDto responseDto)
    {
        try{
            stringRedisTemplate.opsForValue().set(KEY_SUMMARY + id, objectMapper.writeValueAsString(responseDto));
        }
        catch (Exception ex){
            log.error("Could you store the key inside redis : " + ex.getMessage());
        }

    }
}

