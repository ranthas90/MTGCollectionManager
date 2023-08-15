package org.ranthas.mtgcollectionmanager.dto.collection;

public record CardImage(String artCropUrl, String normalUrl) {

    public CardImage(String artCropUrl, String normalUrl) {
        this.artCropUrl = evaluateNullImage(artCropUrl);
        this.normalUrl = evaluateNullImage(normalUrl);
    }

    private String evaluateNullImage(String image) {
        return image == null ? "/assets/images/image-not-available.jpg" : image;
    }
}
