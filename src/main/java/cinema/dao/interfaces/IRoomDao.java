package cinema.dao.interfaces;

import cinema.domain.Room;

import java.util.List;

public interface IRoomDao {
    void addRoom(Room room);
    List<Room> getRooms();
}
