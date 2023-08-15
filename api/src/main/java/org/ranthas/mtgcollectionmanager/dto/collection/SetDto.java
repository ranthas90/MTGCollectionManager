package org.ranthas.mtgcollectionmanager.dto.collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.ranthas.mtgcollectionmanager.constant.DateTimeConstants;

import java.time.LocalDate;

public record SetDto(
        String code,
        String name,
        String iconPath,
        long totalCards,
        long ownedCards,
        @JsonFormat(pattern = DateTimeConstants.DATE_PATTERN) LocalDate releaseDate,
        String setType
) {

}
