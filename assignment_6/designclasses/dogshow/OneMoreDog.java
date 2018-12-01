package assignment_6.designclasses.dogshow;

class OneMoreDog extends Dog{

    public OneMoreDog(double weight, String colour, String address) {
        // { name, weight, colour, age, address }

        super(weight, colour);
        super.setAddress(address);
        super.setName(String.valueOf(nickName.DWELLER));
        super.setAge(Dog.getAvgAge());
        updateAvgs();
    }


}
