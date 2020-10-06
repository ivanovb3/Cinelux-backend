package nl.fontys.cinelux.models;

public class Ticket {
    private int ticketNumber;
    private User user;
    private String seat;


    public Ticket(User user, String seat){
        this.seat = seat;
        this.user = user;
    }

    public void GenerateTicketNumber(){

    }
    public User GetUser(){
        return this.user;
    }
    public String GetSeat(){
        return this.seat;
    }
    public void SetSeat(String seat){
        this.seat = seat;
    }


    @Override
    public String toString() {
        return "User{" +
                this.user.toString() +
                '}';
    }
}
