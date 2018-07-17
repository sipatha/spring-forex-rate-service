package cib.eureka.service.web;

import cib.eureka.service.model.RateRequest;
import cib.eureka.service.model.RateResponse;
import cib.eureka.service.srvc.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    private ForexService service;

    @GetMapping(value = "/{base}/{to}", produces = {"application/json"})
    public ResponseEntity<RateResponse> get(@PathVariable("base") String base, @PathVariable("to") List<String> to) {
        RateRequest req = RateRequest.builder()
                .base(base)
                .to(to)
                .build();

        return ResponseEntity.ok(service.getRates(req));
    }

}
