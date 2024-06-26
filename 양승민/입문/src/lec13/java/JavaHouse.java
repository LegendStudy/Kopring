package lec13.java;

public class JavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address, LivingRoom livingRoom) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public static class LivingRoom {
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }
        // 바깥 클래스를 불러올 수 없음
//        public String getAddress() {
//            return JavaHouse.this.LivingRoom;
//        }
    }
}
