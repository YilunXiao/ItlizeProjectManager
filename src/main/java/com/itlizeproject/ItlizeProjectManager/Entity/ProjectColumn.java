package com.itlizeproject.ItlizeProjectManager.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project_column")
public class ProjectColumn {

    public enum Type{
        Number("number"),
        Text("text"),
        Formula("formula");
        private final String typename;
        Type(String typename){
            this.typename = typename;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "type")
    private Type type;

    @Column(name = "formula_text")
    private String formulaText;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "projectColumn",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ResourceDetail> resourceDetails;

    public ProjectColumn() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public List<ResourceDetail> getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(List<ResourceDetail> resourceDetails) {
        this.resourceDetails = resourceDetails;
    }
}
