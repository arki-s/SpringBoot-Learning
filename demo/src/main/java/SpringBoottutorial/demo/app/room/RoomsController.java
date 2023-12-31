package SpringBoottutorial.demo.app.room;

import SpringBoottutorial.demo.domain.model.ReservableRoom;
import SpringBoottutorial.demo.domain.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("rooms")
public class RoomsController {
    @Autowired
    RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    String listRooms(Model model){
        LocalDate today = LocalDate.now();
        List<ReservableRoom> rooms = roomService.findReservableRooms(today);
        model.addAttribute("date",today);
        model.addAttribute("rooms",rooms);
        return "room/listRooms";
    }

}
