package api.damdev.moneybook.controller;

import api.damdev.moneybook.domain.Cycle;
import api.damdev.moneybook.dto.cycle.CycleInfo;
import api.damdev.moneybook.service.CycleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/moneybook/cycle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CycleController {

    @Autowired
    CycleService cycleService;

    @PostMapping
    public ResponseEntity addCycleData(@RequestBody CycleInfo info) {
        Cycle cycle = cycleService.insertCycle(info);

        return ResponseEntity.ok(cycle);
    }

    @PutMapping("{cycleId}")
    public ResponseEntity modifyCycleData(@RequestBody CycleInfo info, @PathVariable("cycleId") String id) {
        Cycle cycle = cycleService.updateCycle(info, id);

        return ResponseEntity.ok(cycle);
    }

    @GetMapping("/list")
    public ResponseEntity viewListCycleData() {
        List<Cycle> list = cycleService.findAllCycle();

        return ResponseEntity.ok(list);
    }
}
