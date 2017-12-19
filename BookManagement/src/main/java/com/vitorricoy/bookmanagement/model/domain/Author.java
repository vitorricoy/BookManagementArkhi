package com.vitorricoy.bookmanagement.model.domain;

import java.util.Date;

/**
 *
 * @author vitor
 */
public class Author {
    private Long id;
    private String authorName;
    private Date birthDate;
    private Date deathDate;

    /**
     * Constructor with death and birth date
     * @param id The author's id
     * @param authorName The author's name
     * @param birthDate The author's birth date
     * @param deathDate The author's death date
     */
    public Author(Long id, String authorName, Date birthDate, Date deathDate) {
        this.authorName = authorName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.id=id;
    }

    /**
     * Constructor with only birth date
     * @param authorName The author's name
     * @param birthDate The author's birth date
     * @param id The author's id
     */
    public Author(Long id, String authorName, Date birthDate) {
        this.authorName = authorName;
        this.birthDate = birthDate;
        this.id=id;
    }

    /**
     * Get the author's name
     * @return The author's name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Set the author's name
     * @param authorName The author's name
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * Get the author's birth date
     * @return The author's birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Set the author's birth date
     * @param birthDate The author's birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the author's death date
     * @return The author's death date
     */
    public Date getDeathDate() {
        return deathDate;
    }

    /**
     * Set the author's death date
     * @param deathDate The author's death date
     */
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    /**
     * Get the author's id
     * @return The author's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the author's id
     * @param id The author's id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
