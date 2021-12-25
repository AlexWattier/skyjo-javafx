package g49707.skyjo.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The type Image view card.
 *
 * @author alexandre
 */
public class ImageViewCard extends ImageView {


    /**
     * Instantiates a new Image view card.
     *
     * @param image the image
     */
    public ImageViewCard(Image image) {
        super(image);
        setFitWidth(100);
        setFitHeight(160);
    }
}
