package com.example.moim.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
@Access(AccessType.FIELD)
public class Ingredients {
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Ingredient> values = new ArrayList<>();

    protected Ingredients() {
    }

    public Ingredients(List<String> ingredientsName) {
        List<Ingredient> ingredients = ingredientsName.stream().map(i -> new Ingredient(i)).collect(Collectors.toList());
        this.values = new ArrayList<>(ingredients);
    }

    public static List<String> convertString(Ingredients ingredients) {
        return ingredients.values.stream()
                .map(i -> i.getName())
                .collect(Collectors.toList());
    }
}
