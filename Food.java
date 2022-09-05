package HotelRelated;

import Nonhotel.FoodType;

import java.time.LocalTime;

public class Food {
    private LocalTime time;
    private String platillo;
    private FoodType foodType;
    private int ROOM;

    public Food (Room room, LocalTime time)
    {
        setROOM(room.getRoomNumber());
        getFoodType(time);
    }


    private void getFoodType(LocalTime time)
    {
        int hour  = time.getHour();
        if (hour >= 7 && hour < 12)
            setFoodType(FoodType.DESAYUNO);
        else if (hour >= 12 && hour < 6)
            setFoodType(FoodType.COMIDA);
        else
            setFoodType(FoodType.CENA);
    }

    public void setROOM(int ROOM) {
        this.ROOM = ROOM;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }
}
