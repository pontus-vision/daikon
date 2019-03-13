package org.talend.daikon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api("API name")
@RestController
public class SwaggerDemoController {

    @ApiOperation("Get")
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @ApiOperation("Get parameters")
    @GetMapping("/get/{parameter}")
    public String getWithParameters(@PathVariable("parameter") String parameter) {
        return "GET" + parameter;
    }

}
