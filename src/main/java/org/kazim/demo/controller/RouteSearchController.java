package org.kazim.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.kazim.demo.model.ResponseModel;
import org.kazim.demo.service.RouteSearchService;
import org.kazim.demo.utils.GenerateDoc;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@RequiredArgsConstructor
public class RouteSearchController {

    private final RouteSearchService routeSearchService;

    @GetMapping(path = "/generate")
    public Object generate(@RequestParam int str, @RequestParam int min, @RequestParam int max) throws Exception {
        GenerateDoc.generate(str, min, max);
        return "demo.txt - build!";
    }

    @GetMapping(path = "/direct")
    public Object search(@RequestParam int from, @RequestParam int to) throws Exception {
        if (routeSearchService.routeSearch(from, to))
            return new ObjectMapper().writeValueAsString(new ResponseModel(from, to, true));
        else
            return new ObjectMapper().writeValueAsString(new ResponseModel(from, to, false));
    }
}
