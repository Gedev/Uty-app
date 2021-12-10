package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.gedev.utyapp.models.entity.RoomEquipment;

import java.util.Set;

@Data
@Builder
public class ClassroomDTO {

    private long id;
    private String room_num;
    private int surface;

    private Set<ClassroomDTO.RoomEquipmentDTO> roomEquipmentList;

    @Data
    @Builder
    public static class RoomEquipmentDTO {
        private long id;
        private String name;
    }

}
