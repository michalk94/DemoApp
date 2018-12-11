package congerence.room.manager.demoapp.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    List<RoomDto> findAll(){
        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    RoomDto createRoom(RoomDto roomDto){
        Room roomEntity = RoomMapper.toEntity(roomDto);
        Room createRoom = roomRepository.save(roomEntity);
        return RoomMapper.toDto(createRoom);
    }

    RoomDto editRoom(RoomDto roomDto){
        
    }
}
