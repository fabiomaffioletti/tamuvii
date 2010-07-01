package com.tamuvii.property.editors;

import java.beans.PropertyEditorSupport;

import com.tamuvii.model.Genre;
import com.tamuvii.service.GenreManager;

public class GenrePropertyEditor extends PropertyEditorSupport {

    private final GenreManager genreManager;
 
    public GenrePropertyEditor(GenreManager genreManager) {
        this.genreManager = genreManager;
    }
 
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(genreManager.getGenreByName(text));
    }
 
    @Override
    public String getAsText() {
        Genre genre = (Genre) getValue();
        if (genre == null) {
            return null;
        } else {
            return genre.getName();
        }
    }
}