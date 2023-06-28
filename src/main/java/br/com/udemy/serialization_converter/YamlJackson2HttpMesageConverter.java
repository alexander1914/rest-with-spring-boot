package br.com.udemy.serialization_converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJsonHttpMessageConverter;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;

public class YamlJackson2HttpMesageConverter extends AbstractJackson2HttpMessageConverter {
    public YamlJackson2HttpMesageConverter() {
        super(
                new YAMLMapper()
                        .setSerializationInclusion(
                                JsonInclude.Include.NON_NULL),
                MediaType.parseMediaType("application/x-yaml")
        );
    }

}
