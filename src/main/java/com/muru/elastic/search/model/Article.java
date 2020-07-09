package com.muru.elastic.search.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Document(indexName = "blog")
@Data
@RequiredArgsConstructor
public class Article {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = Text, fielddata = true),
            otherFields = { @InnerField(suffix = "verbatim", type = Keyword) })
    private final String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;

    @Field(type = Keyword)
    private String[] tags;

}
