package org.talend.daikon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("API name")
@RestController
public class SwaggerDemoController {

    @ApiOperation("Get a value")
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @ApiOperation("Get parameter with a parameter")
    @GetMapping("/get/{parameter}")
    public String getWithParameters(@ApiParam(required = true,
            value = "A value to add to the returned value") @PathVariable("parameter") String parameter) {
        return "GET" + parameter;
    }

}
