package google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemons> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this. pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Pokemons> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemons> pokemons) {
        this.pokemons = pokemons;
    }

}
