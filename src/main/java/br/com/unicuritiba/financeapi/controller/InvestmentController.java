package br.com.unicuritiba.financeapi.controller;

import br.com.unicuritiba.financeapi.dto.InvestmentDTO;
import br.com.unicuritiba.financeapi.model.Investment;
import br.com.unicuritiba.financeapi.service.InvestmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/investments")
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;

    @GetMapping
    public List<Investment> list(@PathVariable Long userId) {
        return investmentService.listByUser(userId);
    }

    @PostMapping
    public ResponseEntity<Investment> create(@PathVariable Long userId,
                                             @RequestBody @Valid InvestmentDTO dto) {
        Investment created = investmentService.create(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{investmentId}")
    public ResponseEntity<Investment> update(@PathVariable Long investmentId,
                                             @RequestBody @Valid InvestmentDTO dto) {
        return ResponseEntity.ok(investmentService.update(investmentId, dto));
    }

    @DeleteMapping("/{investmentId}")
    public ResponseEntity<Void> delete(@PathVariable Long investmentId) {
        investmentService.delete(investmentId);
        return ResponseEntity.noContent().build();
    }
}
