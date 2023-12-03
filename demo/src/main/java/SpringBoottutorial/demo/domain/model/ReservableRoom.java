package SpringBoottutorial.demo.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ReservableRoom implements Serializable {
  @EmbeddedId
  private ReservableRoomId reservableRoomId;

  @ManyToOne
  @JoinColumn(name = "room_id", insertable = false, updatable = false)
  @MapsId("roomId")
  private MeetingRoom meetingRoom;

  public ReservableRoom(ReservableRoomId reservableRoomId) {
    this.reservableRoomId = reservableRoomId;
  }

  public ReservableRoom() {
  }

  //  ここからgetter setter
  public ReservableRoomId getReservableRoomId() {
    return reservableRoomId;
  }

  public void setReservableRoomId(ReservableRoomId reservableRoomId) {
    this.reservableRoomId = reservableRoomId;
  }

  public MeetingRoom getMeetingRoom() {
    return meetingRoom;
  }

  public void setMeetingRoom(MeetingRoom meetingRoom) {
    this.meetingRoom = meetingRoom;
  }



}
