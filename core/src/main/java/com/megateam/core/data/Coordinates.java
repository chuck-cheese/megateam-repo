package com.megateam.core;


public class Coordinates {
    static Float x;
    int y;

    public class CoordinatesBuilder {
        private Float x;
        private int y;


        public void CoordinatesBuilder(){}

        public CoordinatesBuilder setX(Float x){
            this.x = x;
            return this;
        }

        public CoordinatesBuilder setY(int y){
            this.y = y;
            return this;
        }
        public Coordinates build(){
            return new Coordinates(this);
        }
    }
    private Coordinates(CoordinatesBuilder builder)
    {
        this.x = builder.x;
        this.y = builder.y;
    }

    public Float getX(){
        return x;
    }
    public int  getY(){
        return y;
    }

    public CoordinatesBuilder builder()
    {
        return new CoordinatesBuilder();
    }
}
