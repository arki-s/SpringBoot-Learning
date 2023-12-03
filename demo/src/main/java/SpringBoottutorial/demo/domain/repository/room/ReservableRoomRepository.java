package SpringBoottutorial.demo.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import SpringBoottutorial.demo.domain.model.ReservableRoom;
import SpringBoottutorial.demo.domain.model.ReservableRoomId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId>{
    List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableroomId_roomIdAsc(LocalDate reservedDate);
}

