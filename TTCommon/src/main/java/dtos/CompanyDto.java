package dtos;

import entities.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private Long id;
    private String name1;
    private String name2;

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name1 = company.getName1();
        this.name2 = company.getName2();
    }

    public Company toEntity() {
        Company company = new Company();
        company.setId(this.id);
        company.setName1(this.name1);
        company.setName2(this.name2);
        return company;
    }
}
