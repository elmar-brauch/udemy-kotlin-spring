package de.bsi.fibonacci;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FibonacciController {
    
    @GetMapping("/fibonacci")
    public String printFibonacci(@RequestParam int numbers) {
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(0);
        fibonacciNumbers.add(1);
        for (int i = 2; i < numbers; i++) {
            int lastPosition = fibonacciNumbers.size() - 1;
            int beforeLastPosition = lastPosition - 1;
            Integer newNumber = fibonacciNumbers.get(beforeLastPosition) + fibonacciNumbers.get(lastPosition);
            fibonacciNumbers.add(newNumber);
        }
        return fibonacciNumbers.toString();
    }
    
}
