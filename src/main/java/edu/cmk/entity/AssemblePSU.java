package edu.cmk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class AssemblePSU {

    private Product product;
    private Sale sale;
    private User user;

}
