package technobel.gedev.utyapp.mapper;

public interface BaseMapper<TDTO, TFORM, TENTITY> {
    TDTO toDto(TENTITY entity);
    TENTITY formToEntity(TFORM form);
}
