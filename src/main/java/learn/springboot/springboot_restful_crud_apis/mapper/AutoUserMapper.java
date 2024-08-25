package learn.springboot.springboot_restful_crud_apis.mapper;

import learn.springboot.springboot_restful_crud_apis.userDtoEntity.UserDTO;
import learn.springboot.springboot_restful_crud_apis.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDTO mapToUserDTO(User user);
    User mapToUser(UserDTO userDto);
}
