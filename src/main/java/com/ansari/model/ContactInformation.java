package com.ansari.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ContactInformation {
    private String email;
    private String mobile;
    private String x;
    private String instagram;
}
