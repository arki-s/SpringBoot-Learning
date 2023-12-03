package SpringBoottutorial.demo.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import SpringBoottutorial.demo.domain.model.ReservableRoom;
import SpringBoottutorial.demo.domain.repository.room.ReservableRoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RoomService {

    @Autowired
    ReservableRoomRepository reservableRoomRepository;

    public List<ReservableRoom> findReservableRooms(LocalDate date){
        return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableroomId_roomIdAsc(date);
    }

}
