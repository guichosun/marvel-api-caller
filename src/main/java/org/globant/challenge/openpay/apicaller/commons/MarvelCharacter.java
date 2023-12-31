package org.globant.challenge.openpay.apicaller.commons;

import lombok.Data;

import java.util.Date;

/**
 * Represents a Marvel Character
 *
 * @author luis.delcampo
 */
@Data
public class MarvelCharacter {

    /**
     * The unique ID of the character resource.
     */
    private Integer id;

    /**
     * The name of the character.
     * */
    private String name;

    /**
     * A short bio or description of the character.
     */
    private String description;

    /**
     * The date the resource was most recently modified.
     */
    private Date modified;

    /**
     * The canonical URL identifier for this resource.
     */
    private String resourceURI;
//    urls (Array[Url], optional): A set of public web site URLs for the resource.,
//    thumbnail (Image, optional): The representative image for this character.,
//    comics (ComicList, optional): A resource list containing comics which feature this character.,
//    stories (StoryList, optional): A resource list of stories in which this character appears.,
//    events (EventList, optional): A resource list of events in which this character appears.,
//    series (SeriesList, optional): A resource list of series in which this character appears.
}

