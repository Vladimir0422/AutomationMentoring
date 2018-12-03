package module18.models;

import com.google.common.collect.ImmutableList;

import javax.swing.text.html.HTML;
import java.util.List;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 11/25/2018
 */


public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<HTML.Tag> tags;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<HTML.Tag> getTags() {
        return tags;
    }

    public void setTags(List<HTML.Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Pet createBarsik() {
        Category category = new Category();
        category.setName("Cats");
        category.setId(123123);

        Pet cat = new Pet();
        cat.setId(807011);
        cat.setName("BarsikSV5");
        cat.setCategory(category);
        cat.setPhotoUrls(ImmutableList.of("someUrl"));
        cat.setStatus("available");
        return cat;
    }
}
